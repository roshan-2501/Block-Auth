package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CertificatesPojo;
import model.UserPojo;
import service.UserDao;

import com.http.servlet.HttpsServlet;

public class Register extends HttpsServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		UserDao userDao = new UserDao();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("cpassword");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String pincode = request.getParameter("pincode");
		UserPojo userPojo = new UserPojo(name, email, password,
				confirmPassword, dob, gender, address, pincode, "pending", null);
		boolean result = userDao.saveUser(userPojo);
		if (result) {
			CertificatesPojo certificatesPojo = new CertificatesPojo(email,
					null, "pending", null, "pending", null, "pending", null,
					"pending", "null");
			boolean res = userDao.saveCertificates(certificatesPojo);
			HttpSession session = request.getSession(true);
			session.setAttribute("name", name);
			session.setAttribute("email", email);
			request.setAttribute("msg", "Registered successfully");
			RequestDispatcher rd = request.getRequestDispatcher("identity.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("msg", "Email already exists!");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		out.close();
	}

}
