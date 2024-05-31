package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.bean.ManufacturerBean;
import com.dao.ManufacturerDao;
import com.dao.PatientDao;

/**
 * Servlet implementation class CreateBatchCon
 */
@WebServlet("/CreateBatchCon")
public class CreateBatchCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateBatchCon() {
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
		String email = request.getParameter("email");
		String quantity = request.getParameter("quantity");
		String distname = request.getParameter("distname");
		String status = "Send";
		String statuss = "Send";
		
		ManufacturerBean b = new ManufacturerBean();
		
		int hashcode=b.hashCode();
		System.out.println("drugname hashcode value is:"+hashcode);		
		
		ManufacturerDao dao=new ManufacturerDao();
		
		b.setHashcode(hashcode);
        b.setBatchname(batchname);
		b.setManufacturingdate(manufacturingdate);
		b.setExpirydate(expirydate);
		b.setPrice(price);		
		b.setWeight(weight);
		b.setEmail(email);
		b.setQuantity(quantity);
		b.setDistName(distname);
		b.setStatus(status);
		b.setStatuss(statuss);
		

		if (dao.CreateBatch(b)) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Batch Created Successfully')");
			out.println("location='ManufacturerHome.jsp';");
			out.println("</script>");
			HttpSession session=request.getSession();  
	        session.setAttribute("batchname",b.getBatchname());  
	        session.setAttribute("name", b.getName());
	        session.setAttribute("userId", b.getId());
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Not created..Try Again')");
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
