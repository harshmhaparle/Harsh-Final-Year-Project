package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.bean.PatientBean;
import com.dao.PatientDao;

/**
 * Servlet implementation class BillMedicineCon
 */
@WebServlet("/BillMedicineCon")
public class BillMedicineCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillMedicineCon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		
		
		String date = request.getParameter("date");
		String email = request.getParameter("email");
		String payment = request.getParameter("payment");
		String status = "Active";
	

		PatientBean b = new PatientBean();
		PatientDao dao = new PatientDao();
		
	
		b.setDate(date);
		b.setEmail(email);
		b.setPayment(payment);
		b.setStatus(status);
		

		

		if (dao.InsertBillMedicineData(b)) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Bill Created Successfully...')");
			out.println("location='BuyOrderPayment.jsp';");
			out.println("</script>");
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('UnSuccessful..Pls Try Again')");
			out.println("location='BuyOrderPayment.jsp';");
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
