package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.bean.ManufacturerBean;
import com.dao.ManufacturerDao;
import com.dao.PatientDao;

/**
 * Servlet implementation class AddDrugStockCon
 */
@WebServlet("/AddDrugStockCon")
public class AddDrugStockCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDrugStockCon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();

		String categoryname = request.getParameter("categoryname");			
		String drugname = request.getParameter("drugname");
			
		String drugprice = request.getParameter("drugprice");
		String drugdesc = request.getParameter("drugdesc");
		String date = request.getParameter("date");
		String status = "Active";
		ManufacturerBean b = new ManufacturerBean();
		/*ManufacturerBean name= new ManufacturerBean(1001,"ABC");*/	
		/*int hashcodevalueofdrugnameObject=b.hashCode();
		System.out.println("drugname hashcode value is:"+hashcodevalueofdrugnameObject);*/
		
		int hashcode=b.hashCode();
		System.out.println("drugname hashcode value is:"+hashcode);
		
		
		PatientDao db=new PatientDao();
		Part part=request.getPart("file");
		
		/*if(part!=null)
		{
			image=part.getInputStream();
			System.out.println("is size:"+image.available());
			
			imageName=db.extractFileName(part);
			System.out.println("name:"+imageName);
		}
		*/

		
		

		b.setCategoryname(categoryname);
		b.setDrugname(drugname);
		b.setDrugprice(drugprice);
		b.setDrugdesc(drugdesc);
		b.setDate(date);
		b.setStatus(status);
		/*b.setImage(image);		
		b.setImage_name(imageName);*/
		b.setHashcode(hashcode);

		ManufacturerDao dao = new ManufacturerDao();

		if (dao.AddDrug(b)) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Registration Successful')");
			out.println("location='ManufacturerHome.jsp';");
			out.println("</script>");
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Registration UnSuccessful')");
			out.println("location='ManufacturerHome.jsp';");
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
