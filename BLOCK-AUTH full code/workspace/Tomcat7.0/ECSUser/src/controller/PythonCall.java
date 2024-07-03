package controller;


import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;

@SuppressWarnings("deprecation")
public class PythonCall {

	@SuppressWarnings("deprecation")
	public List<String> executeMultiPartRequest(String urlString, File file, String fileName,String email) throws Exception
    {
        List<String> respons = new ArrayList<String>();
        HttpClient client = new DefaultHttpClient() ;
        HttpPost postRequest = new HttpPost (urlString) ;
        try
        {
            //Set various attributes
            MultipartEntity multiPartEntity = new MultipartEntity() ;
         
            multiPartEntity.addPart("name", new StringBody(fileName)) ;
  
            FileBody fileBody = new FileBody(file, "application/octect-stream") ;
            //Prepare payload
            multiPartEntity.addPart("file", fileBody);
            multiPartEntity.addPart("email", new StringBody(email));
            multiPartEntity.addPart("imagename", new StringBody(email));
            //Set to request body
            postRequest.setEntity(multiPartEntity) ;
            //Send request
            HttpResponse response = client.execute(postRequest) ;
             
            System.out.println("-Response-----     "+response.getStatusLine().getStatusCode());
            //Verify response if any
            if (response != null)
            {
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                   response.getEntity().getContent()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                respons.add(line);
            }
            reader.close();
            
                return respons;
            }else{
            	return null;
            }
        }
        catch (Exception ex)
        {
        	return null;
        }
        
    }
	
}
