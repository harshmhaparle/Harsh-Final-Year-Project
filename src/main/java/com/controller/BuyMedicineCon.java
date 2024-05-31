package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.bean.ManufacturerBean;
import com.bean.PatientBean;
import com.dao.ManufacturerDao;
import com.dao.PatientDao;

/**
 * Servlet implementation class BuyMedicineCon
 */
@MultipartConfig
@WebServlet("/BuyMedicineCon")
public class BuyMedicineCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InputStream image=null;		
	String imageName="";
	String path=null;
	File upload=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyMedicineCon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

				
		String email = request.getParameter("email");
		String date = request.getParameter("date");
		String status = "Send";
		String statuss = "Send";

		PatientBean b = new PatientBean();
		PatientDao dao = new PatientDao();
		
         Part part=request.getPart("file");
		
		if(part!=null)
		{
			image=part.getInputStream();
			System.out.println("is size:"+image.available());
			
			imageName=dao.extractFileName(part);
			System.out.println("name:"+imageName);
		}
		
	
		b.setDate(date);
		b.setEmail(email);
		b.setImage(image);
		b.setImage_name(imageName);
		b.setStatus(status);
		b.setStatuss(statuss);

		

		if (dao.InsertBuyMedicineData(b)) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Successfully Order Medicine...')");
			out.println("location='PatientHome.jsp';");
			out.println("</script>");
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('UnSuccessful..Pls Try Again')");
			out.println("location='PatientHome.jsp';");
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
