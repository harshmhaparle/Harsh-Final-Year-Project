package com.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algo.Encryptor;
import com.algo.MD5;
import com.bean.PatientBean;
import com.dao.PatientDao;

/**
 * Servlet implementation class PharmacyRegCon
 */
@WebServlet("/PharmacyRegCon")
public class PharmacyRegCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PharmacyRegCon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");		
		String address = request.getParameter("address");		
		String email = request.getParameter("email");
		String mobileno = request.getParameter("mobileno");
		String dob = request.getParameter("dob");		
		String password = request.getParameter("password");		
		String status = "Active";

		PatientBean b = new PatientBean();
		

		b.setName(name);		
		b.setAddress(address);
		b.setEmail(email);
		b.setMobileno(mobileno);		
		b.setDob(dob);
		b.setPassword(password);
		b.setStatus(status);

		PatientDao dao = new PatientDao();
		MD5 md5=new MD5();
		String hashvalue=md5.generate(name);
		String filename=name+".txt";
	      File myObj = new File("D:\\Nodes\\Pharmacy\\"+filename+hashvalue);
	      if (myObj.createNewFile()) {
	        System.out.println("File created: " + myObj.getName());
	      } else {
	        System.out.println("File already exists.");
	      }
	      
	      FileWriter myWriter = new FileWriter("D:\\Nodes\\Pharmacy\\"+filename+hashvalue);
	      myWriter.write("Pharmacy Details-"+"Name:"+name+",Address:"+address+",Email:"+email+",Mobile No:"+mobileno+"");
	      myWriter.close();
	      
	      Encryptor bfe=new Encryptor();
			
			try {
				
				bfe.encrypt("D:\\Nodes\\Pharmacy\\"+filename+hashvalue);
				
				  
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
		if (dao.InsertPharmacyData(b)) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Registration Successful')");
			out.println("location='PharmacyLogin.jsp';");
			out.println("</script>");
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Registration UnSuccessful')");
			out.println("location='PharmacyReg.jsp';");
			out.println("</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
