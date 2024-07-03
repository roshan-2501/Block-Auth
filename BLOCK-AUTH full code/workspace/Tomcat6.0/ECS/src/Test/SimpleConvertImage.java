package Test;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.NoSuchPaddingException;
import javax.imageio.ImageIO;

import com.encryption.RSAEncDec;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class SimpleConvertImage {
	public static void main(String[] args) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException {
		String dirName = "C:/Users/gts/Desktop/ims/";
		 ByteArrayOutputStream baos = new ByteArrayOutputStream(1000);
		 BufferedImage img = ImageIO.read(new File(dirName, "as.png"));
		 ImageIO.write(img, "png", baos);
		 baos.flush();
		 String base64String = Base64.encode(baos.toByteArray());
		 System.out.println(base64String);
		 baos.close();
//		StringBuffer buffer = new StringBuffer();
//		FileReader fr = new FileReader(dirName+"9C973BE7238C9022DFD5430F55BEFDFC.txt");
//		int i;
//		while ((i = fr.read()) != -1) {
//			buffer.append((char) i);
//
//		}
//		fr.close();
//		String kinle = buffer.toString();
//		RSAEncDec dec=new RSAEncDec();
//		String op=dec.decrypt(kinle, "392471751967971211782181758736273653665742289");
		byte[] bytearray = Base64.decode(base64String);
		BufferedImage imag = ImageIO.read(new ByteArrayInputStream(bytearray));
		ImageIO.write(imag, "png", new File(dirName, "snapk.png"));
	}
}
