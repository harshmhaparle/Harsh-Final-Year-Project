package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.DBConnection;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("In do post method display image servlet");
		String idUser=request.getParameter("idUser");
		int id=Integer.parseInt(idUser);
         int imgid=0;
         String image_name=null; 	
          
		
		try {
			Connection con = DBConnection.getConnection();

			String sql = "select * from users";
			Statement stmt;
			stmt = con.createStatement();
           ResultSet rs= stmt.executeQuery(sql);
			
			while(rs.next())
			{
				if(rs.getInt("idUser")==id)
				{
					imgid=rs.getInt("idUser");
					image_name=rs.getString("image_name");
					
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		RequestDispatcher rd;
		request.setAttribute("id", imgid);
		request.setAttribute("img", image_name);
		rd=request.getRequestDispatcher("View.jsp");
		rd.forward(request, response);
	}
 
	}


