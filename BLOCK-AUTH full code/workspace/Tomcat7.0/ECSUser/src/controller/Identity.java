package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import service.UserDao;

import com.http.servlet.HttpsServlet;

public class Identity extends HttpsServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession hs=request.getSession(false);
		String email=(String)hs.getAttribute("email");
		String image="";
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items = upload.parseRequest(request);
			for (FileItem locFileItem : items) {
				if (locFileItem.isFormField()) {
					System.out.println("---" + locFileItem.getFieldName());
				} else {
					try {
						image = locFileItem.getName().replace(locFileItem.getName(), email+".jpg");
						System.out.println("Uploaded image is---------->>"+ image);
						String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
						System.out.println("Project URL is---------->"+basePath);
						UserDao userDao=new UserDao();
						boolean result=userDao.setProfile(email, image);
						String path = "webapps/ECSUser/Identity/"+email;
						if (result) {
							File f = new File(path);
							if (!f.exists()) {
								f.mkdirs();
							}
							File tosave = new File(path + File.separator+ image);
							locFileItem.write(tosave);
							hs.invalidate();
							System.out.println("User Identity uploaded seccessfully");
							request.setAttribute("msg", "Registered successfully");
							RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
							rd.forward(request, response);
						} else {
							System.out.println("Failed to upload");
							request.setAttribute("msg", "Failed to upload");
							RequestDispatcher rd=request.getRequestDispatcher("identity.jsp");
							rd.forward(request, response);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		out.close();
	}

}
