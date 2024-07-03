package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.QrDetailsPojo;
import service.AuthDao;

import com.http.servlet.HttpsServlet;

public class QrData extends HttpsServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		System.out.println("===================" + name);
		HttpSession hs = request.getSession(false);
		String email = (String) hs.getAttribute("email");
		AuthDao authDao = new AuthDao();
		List<QrDetailsPojo> list = authDao.retriveQrDetails(email);
		if (!list.isEmpty()) {
			for (QrDetailsPojo qrDetailsPojo : list) {
				out.print(qrDetailsPojo.getDocuments());
			}
			
		} else {
			out.print("no");
		}

		out.close();
	}
}
