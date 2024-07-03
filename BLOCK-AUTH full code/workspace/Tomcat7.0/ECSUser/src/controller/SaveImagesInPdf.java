package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
 
/**
* This is an example on how to extract images from pdf.
*/
public class SaveImagesInPdf extends PDFStreamEngine
{
    /**
     * Default constructor.
     *
     * @throws IOException If there is an error loading text stripper properties.
     */
	boolean testboolean;
	String imgname;
    public SaveImagesInPdf() throws IOException
    {
    }
    
    public int imageNumber = 1;
 
    /**
     * @param args The command line arguments.
     *
     * @throws IOException If there is an error parsing the document.
     */
    
    public static void main( String[] args ) throws IOException
    {
        
    }
    /*public void testdata(){
    	PDDocument document = null;
        String fileName = "webapps/Deduplication/document/Driving.pdf";
        try
        {
            document = PDDocument.load( new File(fileName) );
            SaveImagesInPdf printer = new SaveImagesInPdf();
            int pageNum = 0;
            for( PDPage page : document.getPages() )
            {
                pageNum++;
                System.out.println( "Processing page:" + pageNum );
                printer.processPage(page);
            }
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally
        {
            if( document != null )
            {
                try {
					document.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }
  
    }*/
    /**
     * @param operator The operation to perform.
     * @param operands The list of arguments.
     *
     * @throws IOException If there is an error processing the operation.
     */
    @Override
    protected void processOperator( Operator operator, List<COSBase> operands) throws IOException
    {
        String operation = operator.getName();
        if( "Do".equals(operation) )
        {
            COSName objectName = (COSName) operands.get( 0 );
            PDXObject xobject = getResources().getXObject( objectName );
            if( xobject instanceof PDImageXObject)
            {
                PDImageXObject image = (PDImageXObject)xobject;
                int imageWidth = image.getWidth();
                int imageHeight = image.getHeight();
 
                // same image to local
                BufferedImage bImage = new BufferedImage(imageWidth,imageHeight,BufferedImage.TYPE_INT_ARGB);
                bImage = image.getImage();
                ImageIO.write(bImage,"PNG",new File("webapps/ECSCentralBoardServer/docimage/photo.jpg"));
                System.out.println("Image saved.");
                testboolean = true;
                imageNumber++;
                
            }
            else if(xobject instanceof PDFormXObject)
            {
                PDFormXObject form = (PDFormXObject)xobject;
                showForm(form);
            }
        }
        else
        {
            super.processOperator( operator, operands);
        }
    }
	public void testdata(String doc,String image,String email) {
		PDDocument document = null;
		testboolean = false;
        String fileName = "webapps/ECSCentralBoardServer/Certificates/"+doc+"/"+ email+"/"+image;
        try
        {
            document = PDDocument.load( new File(fileName) );
            SaveImagesInPdf printer = new SaveImagesInPdf();
            int pageNum = 0;
            for( PDPage page : document.getPages() )
            {
                pageNum++;
                //System.out.println( "Processing page:" + page );
                printer.processPage(page);
            }
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally
        {
            if( document != null )
            {
            	//System.out.println("image found");
                try {
					document.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            else {
				System.out.println("not found");
			}
        }
  
		// TODO Auto-generated method stub
		//return testboolean;
	}
 
}
