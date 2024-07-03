package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.QrDetailsPojo;
import service.AuthDao;

public class ResultQR extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String qrResponse[] = request.getParameter("qr").split("\n");
		String documents = "";
		for (String string : qrResponse) {
			documents += string + ",";
			System.out.println(string);
		}
		HttpSession hs = request.getSession(false);
		String email = qrResponse[0];
		
		System.out.println(email+"=================="+documents.replace(email+",", ""));
		AuthDao authDao = new AuthDao();
		QrDetailsPojo detailsPojo = new QrDetailsPojo(email, documents.replace(email+",", ""));
		boolean result = authDao.saveQrDetisl(detailsPojo);
		if (result) {
			out.print("QR Code Scanned");
		} else {
			out.print("QR Code failed to scan");
		}

		out.close();
	}

}
