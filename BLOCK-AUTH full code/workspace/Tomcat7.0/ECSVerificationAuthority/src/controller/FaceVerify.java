package controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.rest.service.ReadProperty;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class FaceVerify extends HttpServlet {

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession hs=request.getSession(false);
		String email=(String)hs.getAttribute("email");
		System.out.println(""+email);
		ReadProperty readProperty = new ReadProperty();

		String user = "verify";
		String image = request.getParameter("img").replace(
				"data:image/jpeg;base64,", "");
		byte[] bytearray = Base64.decode(image);
		String path = "webapps/ECSVerificationAuthority/VerifyFace";
		File dirName = new File(path);
		if (!dirName.exists()) {
			dirName.mkdir();
		}
		System.out.println("*****************inside");

		BufferedImage imag = ImageIO.read(new ByteArrayInputStream(bytearray));
		ImageIO.write(imag, "jpg", new File(dirName, user + ".jpg"));

		/*
		 * BufferedImage bufferedImage;
		 * 
		 * try { bufferedImage = ImageIO.read(new File(dirName, user + ".png"));
		 * BufferedImage newBufferedImage = new BufferedImage(bufferedImage
		 * .getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
		 * newBufferedImage.createGraphics().drawImage(bufferedImage, 0, 0,
		 * Color.WHITE, null); ImageIO.write(newBufferedImage, "jpg", new
		 * File(dirName, user + ".png")); System.out.println("Done"); } catch
		 * (IOException e) { e.printStackTrace(); }
		 */

		PythonCall callPython = new PythonCall();
		try {
			List<String> respo = callPython.executeMultiPartRequest(
					UrlCall.FACE_VERIFY, new File(dirName, user + ".jpg"),
					email+"Aadhar Card");

			System.out.println("**************" + respo);

			try {
				String result = respo.toString().replaceFirst(",", "")
						.replaceAll(",,", ",");
				System.out.println("" + result);
				JSONArray jaArray = (JSONArray) new JSONParser().parse(result);
				JSONObject jsonObject = (JSONObject) jaArray.get(0);
				String data = String.valueOf(jsonObject.get("face_match"));

				// String name = jsonObject.get("result").toString();
				if (data.equalsIgnoreCase("true")) {

					RequestDispatcher dispatcher = request
							.getRequestDispatcher("issuepass.jsp");
					dispatcher.forward(request, response);

				} else {

					RequestDispatcher dispatcher = request
							.getRequestDispatcher("menu.jsp");
					dispatcher.forward(request, response);
				}

				// alertbox3(data);
			} catch (IndexOutOfBoundsException e) {
				System.out.println("No Image Found");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}