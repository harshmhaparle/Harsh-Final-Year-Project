package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.SupplierBean;
import com.bean.PatientBean;
import com.dao.SupplierDao;
import com.dao.PatientDao;

/**
 * Servlet implementation class AddRawMaterialCon
 */
@WebServlet("/AddRawMaterialCon")
public class AddRawMaterialCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRawMaterialCon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		PrintWriter out = response.getWriter();

		String suppliername = request.getParameter("suppliername");		
		String materialname = request.getParameter("materialname");		
		String quantity = request.getParameter("quantity");
		String date = request.getParameter("date");
		String payment = request.getParameter("payment");		
		String quality = request.getParameter("quality");		
		String status = "Active";

		SupplierBean b = new SupplierBean();
		

		b.setSuppliername(suppliername);		
		b.setMaterialname(materialname);
		b.setQuantity(quantity);
		b.setDate(date);	
		b.setPayment(payment);
		b.setQuality(quality);		
		b.setStatus(status);

		SupplierDao dao = new SupplierDao();

		if (dao.InsertRawMaterial(b)) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Raw Material Data Added Successfully...')");
			out.println("location='SupplierHome.jsp';");
			out.println("</script>");
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Raw Material Data Not Added')");
			out.println("location='SupplierRegistration.jsp';");
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
