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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import service.UserDao;

import com.http.servlet.HttpsServlet;

public class PanCard extends HttpsServlet {
//	KeyGeneration k=new KeyGeneration();
//	diffEn diff=new diffEn();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession hs = request.getSession(false);
		ReadProperty readProperty = new ReadProperty();
		String email = (String) hs.getAttribute("email");
		String panCard = "", image = "", type = "", impo="";
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items = upload.parseRequest(request);
			for (FileItem locFileItem : items) {
				if (locFileItem.isFormField()) {
					System.out.println("---" + locFileItem.getFieldName());
					if (locFileItem.getFieldName().equals("name")) {
						panCard = locFileItem.getString();
					}
					if (locFileItem.getFieldName().equals("type")) {
						type = locFileItem.getString();
					}
				} else {
					System.out.println("-------------------------------->"+type);
					if (type.equalsIgnoreCase("pan card")) {
						System.out.println(type+"========pan");
						try {
							impo = locFileItem.getName();
							String temp[]=impo.split("\\.");
							image=temp[0].replace(temp[0], email+".pdf");
							
							System.out.println("Uploaded file is---------->>"+ image);
							UserDao userDao=new UserDao();
							boolean result=userDao.updatePanCard(email, panCard, "Uploaded", type);
							String path = "webapps/ECSCentralBoardServer/Certificates/PAN Card"+ File.separator+ email;
							String path2 = "webapps/ECSCentralBoardServer/docimage/";
							System.out.println("=================================="+result);
										
							if (result) {
								File fe = new File(path);
								if (!fe.exists()) {
									fe.mkdirs();
								}
								File fil = new File(path2);
								if (!fil.exists()) {
									fil.mkdirs();
								}
								
								File tosave = new File(path + File.separator+image);
								locFileItem.write(tosave);
								
								SaveImagesInPdf saveImagesInPdf = new SaveImagesInPdf();
								saveImagesInPdf.testdata("PAN Card",image,email);
								ConvertPDFPagesToImages convertPDFPagesToImages = new ConvertPDFPagesToImages();
								convertPDFPagesToImages.pdftoimage("PAN Card", image, email);
								
								
								try {
									PythonCall callPython = new PythonCall();
									List<String> respo = callPython
											.executeMultiPartRequest(
													readProperty.getURLDetails()+"/register", new File(fil,
															"photo.jpg"), email+"PANCard",email);
									String result1 = respo.toString().replaceFirst(",",
											"").replaceAll(",,", ",");
									System.out.println("" + result);
									JSONArray jaArray = (JSONArray) new JSONParser()
											.parse(result1);
									JSONObject jsonObject = (JSONObject) jaArray.get(0);
									String data = String.valueOf(jsonObject.get("Message"));
								} catch (Exception e) {
									e.printStackTrace();
								}
								
								System.out.println("Details uploaded successfully");
								request.setAttribute("msg", "Details uploaded successfully");
								RequestDispatcher rd=request.getRequestDispatcher("menu.jsp");
								rd.forward(request, response);
							} else {
								request.setAttribute("msg", "PAN Card details already exists");
								RequestDispatcher rd=request.getRequestDispatcher("menu.jsp");
								rd.forward(request, response);
								System.out.println("PAN Card details already exists");
							}
//								String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
//								System.out.println("Project URL is---------->"+basePath);
								
						} catch (Exception e) {
							e.printStackTrace();
						}

					} else if (type.equalsIgnoreCase("aadhar card")) {
						System.out.println(type+"========aadhar");
						try {
							impo = locFileItem.getName();
							String temp[]=impo.split("\\.");
							image=temp[0].replace(temp[0], email+".pdf");
							System.out.println("Uploaded file is---------->>"+ image);
							UserDao userDao=new UserDao();
							boolean result=userDao.updatePanCard(email, panCard, "Uploaded", type);
							String path = "webapps/ECSCentralBoardServer/Certificates/Aadhar Card"+ File.separator+ email;
							String path2 = "webapps/ECSCentralBoardServer/docimage/";
							if (result) {
								File f = new File(path);
								if (!f.exists()) {
									f.mkdirs();
								}
								File fil = new File(path2);
								if (!fil.exists()) {
									fil.mkdirs();
								}
								File tosave = new File(path + File.separator+image);
								locFileItem.write(tosave);
								
								SaveImagesInPdf saveImagesInPdf = new SaveImagesInPdf();
								saveImagesInPdf.testdata("Aadhar Card",image,email);
								ConvertPDFPagesToImages convertPDFPagesToImages = new ConvertPDFPagesToImages();
								convertPDFPagesToImages.pdftoimage("Aadhar Card", image, email);
								
								try {
									PythonCall callPython = new PythonCall();
									List<String> respo = callPython
											.executeMultiPartRequest(
													readProperty.getURLDetails()+"/register", new File(fil,
															"photo.jpg"), email+"AadharCard",email);
									String result1 = respo.toString().replaceFirst(",",
											"").replaceAll(",,", ",");
									System.out.println("" + result);
									JSONArray jaArray = (JSONArray) new JSONParser()
											.parse(result1);
									JSONObject jsonObject = (JSONObject) jaArray.get(0);
									String data = String.valueOf(jsonObject.get("Message"));
								
									
								} catch (Exception e) {
									e.printStackTrace();
								}
								
								System.out.println("Details uploaded successfully");
								request.setAttribute("msg", "Details uploaded successfully");
								RequestDispatcher rd=request.getRequestDispatcher("menu.jsp");
								rd.forward(request, response);
							} else {
								request.setAttribute("msg", "PAN Card details already exists");
								RequestDispatcher rd=request.getRequestDispatcher("menu.jsp");
								rd.forward(request, response);
								System.out.println("PAN Card details already exists");
							}
								
						} catch (Exception e) {
							e.printStackTrace();
						}

					} else if (type.equalsIgnoreCase("voter id")) {
						System.out.println(type+"========voter id");
						try {
							impo = locFileItem.getName();
							String temp[]=impo.split("\\.");
							image=temp[0].replace(temp[0], email+".pdf");
							System.out.println("Uploaded file is---------->>"+ image);
							UserDao userDao=new UserDao();
							boolean result=userDao.updatePanCard(email, panCard, "Uploaded", type);
							String path = "webapps/ECSCentralBoardServer/Certificates/Voter ID"+ File.separator+ email;
							String path2 = "webapps/ECSCentralBoardServer/docimage/";

							if (result) {
								File f = new File(path);
								if (!f.exists()) {
									f.mkdirs();
								}
								File fil = new File(path2);
								if (!fil.exists()) {
									fil.mkdirs();
								}
								File tosave = new File(path + File.separator+image);
								locFileItem.write(tosave);
								
								SaveImagesInPdf saveImagesInPdf = new SaveImagesInPdf();
								saveImagesInPdf.testdata("Voter ID",image,email);
								ConvertPDFPagesToImages convertPDFPagesToImages = new ConvertPDFPagesToImages();
								convertPDFPagesToImages.pdftoimage("Voter ID", image, email);
								
								try {
									PythonCall callPython = new PythonCall();
									List<String> respo = callPython
											.executeMultiPartRequest(
													readProperty.getURLDetails()+"/register", new File(fil,
															"photo.jpg"),email+"VoterID",email);
									String result1 = respo.toString().replaceFirst(",",
											"").replaceAll(",,", ",");
									System.out.println("" + result);
									JSONArray jaArray = (JSONArray) new JSONParser()
											.parse(result1);
									JSONObject jsonObject = (JSONObject) jaArray.get(0);
									String data = String.valueOf(jsonObject.get("Message"));
								
									
								} catch (Exception e) {
									e.printStackTrace();
								}
								
								System.out.println("Details uploaded successfully");
								request.setAttribute("msg", "Details uploaded successfully");
								RequestDispatcher rd=request.getRequestDispatcher("menu.jsp");
								rd.forward(request, response);
							} else {
								request.setAttribute("msg", "PAN Card details already exists");
								RequestDispatcher rd=request.getRequestDispatcher("menu.jsp");
								rd.forward(request, response);
								System.out.println("PAN Card details already exists");
							}
								
						} catch (Exception e) {
							e.printStackTrace();
						}

					} else if (type.equalsIgnoreCase("sslc")) {
						System.out.println(type+"========sslc");
						try {
							impo = locFileItem.getName();
							String temp[]=impo.split("\\.");
							image=temp[0].replace(temp[0], email+".pdf");
							System.out.println("Uploaded file is---------->>"+ image);
							UserDao userDao=new UserDao();
							boolean result=userDao.updatePanCard(email, panCard, "Uploaded", type);
							String path = "webapps/ECSCentralBoardServer/Certificates/SSLC"+ File.separator+ email;
							String path2 = "webapps/ECSCentralBoardServer/docimage/";

							if (result) {
								File f = new File(path);
								if (!f.exists()) {
									f.mkdirs();
								}
								File fil = new File(path2);
								if (!fil.exists()) {
									fil.mkdirs();
								}
								File tosave = new File(path + File.separator+image);
								locFileItem.write(tosave);
								
								SaveImagesInPdf saveImagesInPdf = new SaveImagesInPdf();
								saveImagesInPdf.testdata("SSLC",image,email);
								ConvertPDFPagesToImages convertPDFPagesToImages = new ConvertPDFPagesToImages();
								convertPDFPagesToImages.pdftoimage("SSLC", image, email);
								
								try {
									PythonCall callPython = new PythonCall();
									List<String> respo = callPython
											.executeMultiPartRequest(
													readProperty.getURLDetails()+"/register", new File(fil,
															"photo.jpg"), email+"SSLC",email);
									String result1 = respo.toString().replaceFirst(",",
											"").replaceAll(",,", ",");
									System.out.println("" + result);
									JSONArray jaArray = (JSONArray) new JSONParser()
											.parse(result1);
									JSONObject jsonObject = (JSONObject) jaArray.get(0);
									String data = String.valueOf(jsonObject.get("Message"));
								
									
								} catch (Exception e) {
									e.printStackTrace();
								}
							
								System.out.println("Details uploaded successfully");
								request.setAttribute("msg", "Details uploaded successfully");
								RequestDispatcher rd=request.getRequestDispatcher("menu.jsp");
								rd.forward(request, response);
							} else {
								request.setAttribute("msg", "PAN Card details already exists");
								RequestDispatcher rd=request.getRequestDispatcher("menu.jsp");
								rd.forward(request, response);
								System.out.println("PAN Card details already exists");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}

					} else {
						System.out.println("None of above");
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		out.close();
	}

}
