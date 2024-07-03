package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ServerDao;

import com.http.servlet.HttpsServlet;

public class AcceptOrDecline extends HttpsServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String reason = request.getParameter("reason");
		ServerDao serverDao = new ServerDao();
		if (reason.equalsIgnoreCase("accept")) {
			Random random = new Random();
			String uid = "UID"
					+ String.valueOf(random.nextInt(10))
					+ String.valueOf(random.nextInt(10))
					+ String.valueOf(random.nextInt(10)
							+ String.valueOf(random.nextInt(10)));
			System.out.println("UID------>" + uid);
			File pf = new File("");
			String proppath = pf.getAbsolutePath();
			String filepath = proppath
					+ "\\webapps\\ECSCentralBoardServer\\Properties\\MailProperties.properties";
			// FileInputStream pfis=new FileInputStream(filepath);
			InputStream pfis = this.getClass().getResourceAsStream(
					"MailProperties.properties");
			Properties prop = new Properties();
			prop.load(pfis);
			String empuserid = prop.getProperty("adminid");
			String empmailpassword = prop.getProperty("password");
			String subject = "UID Generation";
			String text = "Hello " + email + "... \n Your UID is " + uid
					+ " \n Thanks & Regards \n Central Board";
			Mail sme = new Mail(empuserid, email, subject, text, empuserid,
					empmailpassword);
			boolean result = serverDao.accept(email, uid);
			request.setAttribute("msg", "User request approved successfully");
			RequestDispatcher rd = request.getRequestDispatcher("requests.jsp");
			rd.forward(request, response);

		} else if (reason.equalsIgnoreCase("decline")) {
			File pf = new File("");
			String proppath = pf.getAbsolutePath();
			String filepath = proppath
					+ "\\webapps\\ECSCentralBoardServer\\Properties\\MailProperties.properties";
			// FileInputStream pfis=new FileInputStream(filepath);
			InputStream pfis = this.getClass().getResourceAsStream(
					"MailProperties.properties");
			Properties prop = new Properties();
			prop.load(pfis);
			String empuserid = prop.getProperty("adminid");
			String empmailpassword = prop.getProperty("password");
			String subject = "UID Generation";
			String text = "Hello " + email + "... \n Your request is declined due to some issues..."
					+ " \n Thanks & Regards \n Central Board";
			Mail sme = new Mail(empuserid, email, subject, text, empuserid,
					empmailpassword);

			boolean result = serverDao.decline(email);
			request.setAttribute("msg", "User request is declined");
			RequestDispatcher rd = request.getRequestDispatcher("requests.jsp");
			rd.forward(request, response);

		} else {
			System.out.println("no reason");
		}

		out.close();
	}

}
