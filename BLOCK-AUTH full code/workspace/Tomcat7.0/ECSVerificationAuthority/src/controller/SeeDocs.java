package controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.QrDetailsPojo;

import org.codehaus.jettison.json.JSONObject;

import service.AuthDao;

import com.http.servlet.HttpsServlet;
import com.rest.service.ServerCall;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class SeeDocs extends HttpsServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String docs = request.getParameter("doc");
		AuthDao authDao = new AuthDao();
		HttpSession hs = request.getSession(false);
		String email = (String) hs.getAttribute("email");
		List<QrDetailsPojo> list = authDao.retriveQrDetails(email);
		String d="";
		for (QrDetailsPojo qrDetailsPojo : list) {
			d=qrDetailsPojo.getDocuments();
		}
		String temp[]=d.split(",");
		for (String string : temp) {
			try {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("docs", string);
				ServerCall serverCall = new ServerCall();
				JSONObject resObject = serverCall.sendQrCode(jsonObject);
				String image = (String) resObject.get("image");
				String path = "webapps/ECSVerificationAuthority/decrypted documents";
				File file = new File(path);
				if (!file.exists()) {
					file.mkdir();

				}
				String rename[] = string.split("\\.");
				byte[] bytearray = Base64.decode(image);
				BufferedImage imag = ImageIO.read(new ByteArrayInputStream(
						bytearray));
				ImageIO.write(imag, "png", new File(path, rename[0] + ".png"));
			

			} catch (Exception e) {
				e.printStackTrace();
			}

			
		}
		 RequestDispatcher rd = request.getRequestDispatcher("seedocs.jsp");
		 rd.forward(request, response);
		 out.close();
	}

}
