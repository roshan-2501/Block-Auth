package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import service.ServerDao;

import com.http.servlet.HttpsServlet;
import com.rest.client.SendCertificate;

public class ApproveDocuments extends HttpsServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String type = request.getParameter("type");
		ServerDao serverDao = new ServerDao();
		if (type.equals("accept")) {
			System.out
					.println("Accepting the documents and sending to the server");
			try {
				JSONObject jsonObject = SendCertificate.callService(email);
				System.out.println("--------->" + jsonObject);
				String res = (String) jsonObject.get("response");
				if (res.equals("ok")) {
					boolean result = serverDao.acceptOrDecline(email, type);
					System.out
							.println("============================================="
									+ result);
					String documents[] = { "PAN Card", "Aadhar Card", "Voter ID", "SSLC" };
					for (String docs : documents) {
						String path = "webapps/ECSCentralBoardServer/Certificates/"+docs+File.separator+email;
						FileUtils.deleteDirectory(new File(path));
		
					}
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("msg", "Documents moved to ECS Server");
			RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
			rd.forward(request, response);

		} else if (type.equals("decline")) {
			System.out.println(email);
			System.out.println(type);
			boolean result = serverDao.acceptOrDecline(email, type);
			System.out.println("============================================="
					+ result);
			System.out
					.println("Declining the request due to improper documents");
			request.setAttribute("msg", "User documents declined...");
			RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
			rd.forward(request, response);
		} else {
			System.out.println("None of the type");
		}
		out.close();
	}

}
