package Test;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import javax.imageio.ImageIO;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
 
public class Image2Base64 {
 
public static void main(String args[]) {
try{
      BufferedImage image = ImageIO.read(new File("C:/Users/gts/Desktop/as.png"));
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      ImageIO.write(image, "png", baos);
     byte[] res=baos.toByteArray();
      String encodedImage = Base64.encode(baos.toByteArray());
      System.out.println("The encoded image byte array is shown below.Please use this in your webpage image tag.\n"+encodedImage);
} 
catch(Exception e) {
     e.printStackTrace();
System.out.println("Some problem has occurred. Please try again");
}
}
 
}
