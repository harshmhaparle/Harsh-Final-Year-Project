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
 * Servlet implementation class PaymentCon
 */
@WebServlet("/PaymentCon")
public class PaymentCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentCon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();

		String suppliername = request.getParameter("suppliername");			
		String rowmaterialname = request.getParameter("rowmaterialname");
		String accountno = request.getParameter("accountno");
		String amount = request.getParameter("amount");
		String date = request.getParameter("date");
		String status = "Active";
		

		ManufacturerBean b = new ManufacturerBean();	

		b.setSuppliername(suppliername);
		b.setRowmaterialname(rowmaterialname);
		b.setAccountno(accountno);
		b.setAmount(amount);
		b.setDate(date);
		b.setStatus(status);

		ManufacturerDao dao = new ManufacturerDao();

		if (dao.addpaymentdetails(b)) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Payment Done Successfully...')");
			out.println("location='ManufacturerHome.jsp';");
			out.println("</script>");
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Payment Not Done')");
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
