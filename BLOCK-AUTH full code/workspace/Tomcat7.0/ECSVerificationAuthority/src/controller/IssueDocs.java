package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.QrDetailsPojo;
import service.AuthDao;

import com.http.servlet.HttpsServlet;

public class IssueDocs extends HttpsServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession hs = request.getSession(false);
		String email = (String) hs.getAttribute("email");
		String type = (String) hs.getAttribute("type");
		AuthDao authDao = new AuthDao();
		boolean result = authDao.issueProofs(email, type);
		String msg = "";
		if (result) {
			msg = type + " approved";
		} else {
			msg = type + " approval failed";
		}
		List<QrDetailsPojo> list = authDao.retriveQrDetails(email);
		for (QrDetailsPojo qrDetailsPojo : list) {
			String temp[] = qrDetailsPojo.getDocuments().split(",");
			for (String string : temp) {
				String path = "webapps/ECSVerificationAuthority/decrypted documents/"
						+ string.replace(".txt", ".png");
				File file = new File(path);

				if (file.delete()) {
					System.out.println("QR Code deleted successfully");
				} else {
					System.out.println("Failed to delete the QR Code");
				}

			}
		}
		boolean resault = authDao.deleteUserInfo(email);
		request.setAttribute("msg", msg);
		RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
		rd.forward(request, response);
		out.close();
	}
}
