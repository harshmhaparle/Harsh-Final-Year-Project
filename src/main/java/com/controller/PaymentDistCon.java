package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ManufacturerBean;
import com.dao.PatientDao;

/**
 * Servlet implementation class PaymentDistCon
 */
@WebServlet("/PaymentDistCon")
public class PaymentDistCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentDistCon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String accountno=request.getParameter("accountno");
		String ifsc=request.getParameter("ifsc");
		String amount=request.getParameter("amount");
		String date=request.getParameter("date");		
		String status="Active";
	
		ManufacturerBean user = new ManufacturerBean();
		
		user.setName(name);
		user.setAccountno(accountno);
		user.setIfsc(ifsc);
		user.setAmount(amount);
		user.setDate(date);
		user.setStatus(status);
	  
		
		PatientDao dao=new PatientDao();
		
		
		if(dao.InsertPaymentDist(user))
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Payment Done Successfully...')");
			out.println("location='PaymentAll.jsp';");
			out.println("</script>");
			
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('UnSuccessful..Pls Try Again')");
			out.println("location='PaymentAll.jsp';");
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
