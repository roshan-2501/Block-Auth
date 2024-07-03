package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.UserDao;
import com.http.servlet.HttpsServlet;

public class Login extends HttpsServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//---------------------------
		UserDao userDao = new UserDao();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String result = userDao.userLogin(email, password);
		if (!result.equalsIgnoreCase("no")) {
			System.out.println("---------------------->>>>"+result);
			String temp[] = result.split(",");
			if (temp[1].equalsIgnoreCase("pending")) {
				request.setAttribute("msglog", "Your request is in pending...");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}else if(temp[1].equalsIgnoreCase("declined")){
				request.setAttribute("msglog", "Your request is rejected");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			} else {
				HttpSession session=request.getSession(true);
				session.setAttribute("image", temp[2]);
				session.setAttribute("email", email);
				session.setAttribute("name", temp[0]);
				RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
				rd.forward(request, response);
			}
		} else {
			request.setAttribute("msglog", "Invalid email or password");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		out.close();}

}
