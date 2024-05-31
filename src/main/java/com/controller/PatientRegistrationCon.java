package com.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
/*import javax.servlet.annotation.MultipartConfig;*/
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.algo.Encryptor;
import com.algo.MD5;
import com.bean.PatientBean;
import com.dao.PatientDao;


/**
 * Servlet implementation class UserRegCon
 */
@MultipartConfig
@WebServlet("/PatientRegistrationCon")
public class PatientRegistrationCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientRegistrationCon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		String mobileno=request.getParameter("mobileno");
		String dob=request.getParameter("dob");
		String password=request.getParameter("password");
		String status="Active";
	
		PatientBean user = new PatientBean();
		
		user.setName(name);
		user.setAddress(address);
		user.setEmail(email);
		user.setMobileno(mobileno);
		user.setDob(dob);
		user.setPassword(password);	
		user.setStatus(status);
	  
		
		PatientDao dao=new PatientDao();
		
		MD5 md5=new MD5();
		String hashvalue=md5.generate(name);
		String filename=name+".txt";
	      File myObj = new File("D:\\Nodes\\Patient\\"+filename+hashvalue);
	      if (myObj.createNewFile()) {
	        System.out.println("File created: " + myObj.getName());
	      } else {
	        System.out.println("File already exists.");
	      }
	      
	      FileWriter myWriter = new FileWriter("D:\\Nodes\\Patient\\"+filename+hashvalue);
	      myWriter.write("Patient Details-"+"Name:"+name+",Address:"+address+",Email:"+email+",Mobile No:"+mobileno+"");
	      myWriter.close();
	      
	      Encryptor bfe=new Encryptor();
			
			try {
				
				bfe.encrypt("D:\\Nodes\\Patient\\"+filename+hashvalue);
				
				  
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
		if(dao.InsertPatientD(user))
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('User Registration Successful...')");
			out.println("location='PatientLogin.jsp';");
			out.println("</script>");
			
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('User Registration UnSuccessful')");
			out.println("location='PatientRegistration.jsp';");
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
