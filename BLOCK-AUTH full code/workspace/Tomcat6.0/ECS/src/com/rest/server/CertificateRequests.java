package com.rest.server;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.NoSuchPaddingException;
import javax.imageio.ImageIO;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.commons.io.FileUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import com.encryption.HMac;
import com.encryption.RSAEncDec;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

@Path("cer")
public class CertificateRequests {
	@Path("cermethod")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject certificatesCall(JSONObject requestObj) throws Exception {
		String email = (String) requestObj.get("email");
		System.out.println("--------------------->" + email);
		try {
			String documents[] = { "PAN Card", "Aadhar Card", "Voter ID",
					"SSLC" };
			for (String docs : documents) {

				FileUtils.copyURLToFile(new URL(
						"http://localhost:8888/ECSCentralBoardServer/Certificates/"
								+ docs.replace(" ", "%20") + "/" + email + "/"
								+ email + ".png"), new File(
						"webapps/ECS/Certificates/" + docs + "/" + email + "/"
								+ email + ".png"));

				// ----------------------------------------------------------------------------------
				String dirName = "webapps/ECS/Certificates/" + docs + "/"
						+ email;
				ByteArrayOutputStream baos = new ByteArrayOutputStream(1000);
				BufferedImage img = ImageIO.read(new File(dirName, email
						+ ".png"));
				ImageIO.write(img, "png", baos);
				baos.flush();

				String base64String = Base64.encode(baos.toByteArray());
				// System.out.println("Base64 Image String is----->\n"+base64String);
				baos.close();
				RSAEncDec rsaEncDec = new RSAEncDec();
				String encrypDocs = rsaEncDec.encrypt(base64String,
						"392471751967971211782181758736273653665742289");
				// System.out.println("Encrypted Content is-------->\n"+encrypDocs);
				String path = "webapps/ECS/Encrypted Douments";
				File f = new File(path);
				if (!f.exists()) {
					f.mkdirs();
				}
				HMac hMac = new HMac();
				String mac = hMac.Sourcemac1(email, docs);
				System.out.println("Cryptography Signature is------>" + mac);
				FileWriter frw = new FileWriter(path + File.separator + mac
						+ ".txt");
				frw.write(encrypDocs);
				frw.close();
				 long number = (long) Math.floor(Math.random() * 9000000000L)
				 + 1000000000L;
				 JSONObject jsonObject = new JSONObject();
				 jsonObject.put("sender", email);
				 jsonObject.put("recipient", docs+"-"+mac+".txt");
				 jsonObject.put("amount", number);
				 ReadProperty property=new ReadProperty();
				 BlockChain.addTransaction(jsonObject.toString(),property.getURLDetails()+BlockChain.Store);
				 BlockChain.mineChain(property.getURLDetails()+BlockChain.Mine);
				String paths = "webapps/ECS/Certificates/" + docs
						+ File.separator + email;
				FileUtils.deleteDirectory(new File(paths));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject responseObj = new JSONObject();
		responseObj.put("response", "ok");
		return responseObj;
	}

	@Path("docmethod")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject docRequests(JSONObject jsonObject) throws JSONException,
			IOException, InvalidKeySpecException, NoSuchAlgorithmException,
			NoSuchPaddingException {
		String docs = (String) jsonObject.get("docs");

		String dirName = "webapps/ECS/Encrypted Douments/";
		StringBuffer buffer = new StringBuffer();
		FileReader fr = new FileReader(dirName + docs);
		int i;
		while ((i = fr.read()) != -1) {
			buffer.append((char) i);

		}
		fr.close();
		String kinle = buffer.toString();
		RSAEncDec dec = new RSAEncDec();
		String op = dec.decrypt(kinle,
				"392471751967971211782181758736273653665742289");
//		byte[] bytearray = Base64.decode(kinle);
		JSONObject sendJson = new JSONObject();
		sendJson.put("image", op);

		return sendJson;
	}
}
