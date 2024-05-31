package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ManufacturerBean;
import com.dao.ManufacturerDao;

/**
 * Servlet implementation class SendToDistributor
 */
@WebServlet("/SendToDistributor")
public class SendToDistributor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendToDistributor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
	   
	  
		String batchname = request.getParameter("batchname");			
	    String manufacturingdate = request.getParameter("manufacturingdate");			
		String expirydate = request.getParameter("expirydate");
		String price = request.getParameter("price");
		String weight = request.getParameter("weight");
		String quantity = request.getParameter("quantity");
		String email = request.getParameter("email");
		String status = "Active";
		String statuss = "Pending";
		ManufacturerBean b = new ManufacturerBean();
		
		int hashcode=b.hashCode();
		System.out.println("Hashcode value is:"+hashcode);	
		
		
		ManufacturerDao dao=new ManufacturerDao();
		
		b.setHashcode(hashcode);
        b.setBatchname(batchname);
		b.setManufacturingdate(manufacturingdate);
		b.setExpirydate(expirydate);
		b.setPrice(price);		
		b.setWeight(weight);
		b.setEmail(email);
		b.setQuantity(quantity);
		b.setStatus(status);
		b.setStatuss(statuss);		

		if (dao.SendToDistributorBatch(b)) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Send Batch Successfully')");
			out.println("location='ManufacturerHome.jsp';");
			out.println("</script>");
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Not Send..Try Again')");
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
