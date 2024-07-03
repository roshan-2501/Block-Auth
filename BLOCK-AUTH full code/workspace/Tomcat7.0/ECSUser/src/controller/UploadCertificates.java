package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.http.servlet.HttpsServlet;

public class UploadCertificates extends HttpsServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String path = "webapps/ECSUser/Identity";
		String name, file = "", fatherName = "", dob = "", panCardNumber = "", image;
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items = upload.parseRequest(request);
			int i = 1;
			for (FileItem locFileItem : items) {
				if (locFileItem.isFormField()) {
					System.out.println("---" + locFileItem.getFieldName());
					if (locFileItem.getFieldName().equals("video")) {
						name = locFileItem.getString();
					}
					if (locFileItem.getFieldName().equals("stars")) {
						fatherName = locFileItem.getString();
					}
					if (locFileItem.getFieldName().equals("hits")) {
						dob = locFileItem.getString();
					}
					if (locFileItem.getFieldName().equals("tags")) {
						panCardNumber = locFileItem.getString();
					}
					
				} else {
					try {
						file = locFileItem.getName();
						System.out.println("Uploaded file is---------->>1."+ file);
							File f = new File(path);
							if (!f.exists()) {
								f.mkdirs();
							}
							File tosave = new File(path + File.separator+file);
							locFileItem.write(tosave);
//							String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
//							System.out.println("Project URL is---------->"+basePath);
							
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			i++;
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		out.close();
	}
}
