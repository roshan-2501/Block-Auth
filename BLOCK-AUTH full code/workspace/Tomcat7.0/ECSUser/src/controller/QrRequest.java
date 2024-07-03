package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CertificatesPojo;
import model.QrPojo;
import service.UserDao;

import com.http.servlet.HttpsServlet;

public class QrRequest extends HttpsServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		String email = (String) session.getAttribute("email");
		String documents[] = request.getParameterValues("docs");
		String certificates = "";
		for (String docs : documents) {
			certificates += docs + ",";
		}
		System.out.println("--------------->" + certificates);
		UserDao userDao = new UserDao();
		List<CertificatesPojo> list = userDao.loadCertificateStatus(email);
		for (CertificatesPojo certificatesPojo : list) {
			if (certificatesPojo.getStatus().equals("approved")) {
				QrPojo qrPojo = new QrPojo(email, certificates.substring(0, certificates.length()-1), "pending", null);
				boolean result = userDao.saveQR(qrPojo);
				System.out.println("------------------------->"+result);
				if (result) {
					request.setAttribute("msgs", "QR Request sent");
					RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
					rd.forward(request, response);
				} else {
					request.setAttribute("msgs", "QR Request already sent");
					RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
					rd.forward(request, response);
				}
			} else {
				request.setAttribute("msgs",
						"Your Documents are not ready to request for QR Code");
				RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
				rd.forward(request, response);

			}
		}
		out.close();
	}

}
