package controller;


import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.http.servlet.HttpsServlet;


public class Aadhar extends HttpsServlet {

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			String type = request.getParameter("Type");
			String name = request.getParameter("Name");
			String father=request.getParameter("Father");
			String address = request.getParameter("Address");
			String dob = request.getParameter("DOB");
			String sex=request.getParameter("sex");
			String aadhar=request.getParameter("Aadharno");
			
			System.out.println("--type--"+type);
			System.out.println("--name--"+name);
			System.out.println("--father"+father);
			System.out.println(address);
			System.out.println(dob);
			System.out.println(sex);
			System.out.println(aadhar);
			
			
			HashMap hashMap = new HashMap();
			hashMap.put("Name", name);
			hashMap.put("DOB", dob);
			hashMap.put("Father", father);
			hashMap.put("sex", sex);
			hashMap.put("Address", address);
			hashMap.put("Aadharno", aadhar);
			if (type.equals("Aadhar")) {
				request.setAttribute("Verify", hashMap);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("Aadhar.jsp");
				dispatcher.forward(request, response);
			} else if (type.equals("Pan")) {
				String Panholder = request.getParameter("Name");
				String Father = request.getParameter("Father");
				String DOB = request.getParameter("DOB");
				String Pan_no = request.getParameter("Panno");
				String party = request.getParameter("Option");
				System.out.println("Panholder"+Panholder);
				System.out.println("Father"+Father);
				System.out.println("DOB"+DOB);
				System.out.println("Pan no"+Pan_no);

				System.out.println(party);

				hashMap.put("Name", Panholder);
				hashMap.put("Father", Father);
				hashMap.put("DOB", DOB);
				hashMap.put("Panno", Pan_no);
				

				request.setAttribute("Verify", hashMap);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("Pan.jsp");
				dispatcher.forward(request, response);
			} else if(type.equals("Voter")) {
				String Electors=request.getParameter("Name");
				String Father = request.getParameter("Father");
				String Sex=request.getParameter("sex");
				String DateofBirth=request.getParameter("DOB");
				
				System.out.println(Electors);
				System.out.println(Father);
				System.out.println(Sex);
				System.out.println(DateofBirth);
				
				hashMap.put("Name", Electors);
				hashMap.put("Father", Father);
				hashMap.put("sex", Sex);
				hashMap.put("DOB", DateofBirth);
			
				request.setAttribute("Verify", hashMap);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("Voter.jsp");
				dispatcher.forward(request, response);
			}else if(type.equals("SSLC"))
			{
				String canditate=request.getParameter("Name");
				String date=request.getParameter("Date");
				String Tamil=request.getParameter("m1");
				String English=request.getParameter("m2");
				String Maths=request.getParameter("m3");
				String Science=request.getParameter("m4");
				String Social=request.getParameter("m5");
				String total=request.getParameter("m6");
				String DOB=request.getParameter("DOB");
				String register=request.getParameter("reg");
				System.out.println(canditate);
				System.out.println(date);
				System.out.println(Tamil);
				System.out.println(English);
				System.out.println(Maths);
				System.out.println(Science);
				System.out.println(Social);
				System.out.println(total);
				System.out.println(DOB);
				System.out.println(register);
				
				
				hashMap.put("Name", canditate);
				hashMap.put("Date", date);
				hashMap.put("m1", Tamil);
				hashMap.put("m2", English);
				hashMap.put("m3", Maths);
				hashMap.put("m4",Science);
				hashMap.put("m5",Social);
				hashMap.put("m6",total);
			    hashMap.put("DOB", DOB);
			    hashMap.put("reg", register);
				
			    request.setAttribute("Verify", hashMap);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("SSLC.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}


	