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
 * Servlet implementation class AddCategoryCon
 */
@MultipartConfig
@WebServlet("/AddCategoryCon")
public class AddCategoryCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InputStream image=null;		
	String imageName="";
	String path=null;
	File upload=null;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCategoryCon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();

		String categoryname = request.getParameter("categoryname");					
		String status = "Active";
		ManufacturerBean b = new ManufacturerBean();
		

		b.setCategoryname(categoryname);			
		b.setStatus(status);
       

		ManufacturerDao dao = new ManufacturerDao();

		if (dao.AddCatagory(b)) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Add Catagory Successfully...')");
			out.println("location='ManufacturerHome.jsp';");
			out.println("</script>");
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Catagory Not Added')");
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
