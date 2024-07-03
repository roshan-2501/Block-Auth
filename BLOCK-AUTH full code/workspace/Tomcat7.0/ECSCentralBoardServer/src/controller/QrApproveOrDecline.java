package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ServerDao;

import com.google.zxing.WriterException;
import com.http.servlet.HttpsServlet;
import com.rest.client.BlockChain;

public class QrApproveOrDecline extends HttpsServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String reason = request.getParameter("reason");
		String certificates = request.getParameter("certificates");
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + request.getContextPath()
				+ "/";
		System.out.println("Project URL is---------->" + basePath);
		ServerDao serverDao = new ServerDao();
		if (reason.equals("generate")) {
			String path = "webapps/ECSCentralBoardServer/QR Codes/";
			File f = new File(path);
			if (!f.exists()) {
				f.mkdir();
			}
			String temp[] = certificates.split(",");
			// =========================================================
			// String signature = "";
			// HMac mac = new HMac();
			// for (String t : temp) {
			// signature += mac.Sourcemac1(email, t) + ",";
			// }
			// System.out
			// .println("QR Code formation is------------->" + signature);
			// String qrCodeText[] = signature.split(",");
			// String qr="";
			// for (String string : qrCodeText) {
			// qr+=string+".txt\n";
			// }
			// ==========================================================
			try {
				String signature = BlockChain.getQrDetails(email, certificates);
				String qrCodeText[] = signature.split(",");
				String qr = "";
				for (String string : qrCodeText) {
					qr += string + "\n";
				}
				String filePath = path + File.separator + email + ".png";
				int size = 250;
				String fileType = "png";
				File qrFile = new File(filePath);
				QRCode.createQRImage(qrFile, email + "\n" + qr, size, fileType);
			} catch (WriterException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			boolean result = serverDao.QrAcceptOrDecline(email, reason,
					basePath + "QR Codes/" + email + ".png");
			request.setAttribute("msg", "QR Code Generated");
			RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
			rd.forward(request, response);

		} else {
			boolean result = serverDao.QrAcceptOrDecline(email, reason, null);
			request.setAttribute("msg", "QR Code request declined");
			RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
			rd.forward(request, response);
		}
		out.close();
	}
}
