package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.http.servlet.HttpsServlet;
import com.rest.client.ServerCall;

public class ApplyForProofs extends HttpsServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		String email = (String) session.getAttribute("email");
		String qrCode = request.getParameter("qrcode");
		String docs = request.getParameter("docs");
		System.out.println(email + "  " + qrCode + "  " + docs);
		try {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("email", email);
			jsonObject.put("qrcode", qrCode);
			jsonObject.put("docs", docs);
			ServerCall serverCall = new ServerCall();
			JSONObject sendQrDetails = serverCall.sendQrCode(jsonObject);
			String res = (String) sendQrDetails.get("response");
			if (res.equals("ok")) {
				out.print(docs.toUpperCase() + " applied successfully");
			} else {
				out.print(res);
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}
		out.close();
	}

}
