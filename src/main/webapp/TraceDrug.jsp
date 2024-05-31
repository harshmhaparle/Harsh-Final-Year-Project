<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.connection.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page import="java.sql.*" %>

<html lang="en">
<head>
<meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Drug Traceability</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: Kelly - v4.7.0
  * Template URL: https://bootstrapmade.com/kelly-free-bootstrap-cv-resume-html-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>
<body>

  <!-- ======= Header ======= -->
  <header id="header" class="fixed-top">
    <div class="container-fluid d-flex justify-content-between align-items-center">

      <h1 class="logo me-auto me-lg-0"><a href="index.html"><b>Drug Traceability</b></a></h1>
      <!-- Uncomment below if you prefer to use an image logo -->
      <!-- <a href="index.html" class="logo"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

      <nav id="navbar" class="navbar order-last order-lg-0">
        <ul>
          <li><a class="active" href="Home.jsp">Home</a></li>
         <li class="dropdown">
           <a><b>Welcome<%response.setContentType("text/html");  
				 HttpSession sessio=request.getSession(true);  
	               if(session!=null){  
	               String name=(String)session.getAttribute("name");  
	                out.print(" "+name+""); }   %></b><i class="bi bi-chevron-down"></i></a>
         <ul> <li><a href="LogoutCon">Logout</a></li>
          </ul></li>
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->
<br>
	<h2>Search Results</h2>
    <form method="post" action="TraceDrug.jsp">
        Enter Number: <input type="text" name="searchNumber">
        <input type="submit" value="Search">
    </form>
    </header>
<section id="contact">
			<div class="container"> 
				<div class="row">
					<div class="col-md-12">
						<!-- <div class="col-lg-12"> -->
							<div class="text-center color-elements">
								<br>
							<h2><b>Trace</b></h2>
						<br>
							</div>
						</div>
						
					<!-- <form action="TraceDrug" Method="post">	 -->
                    <table class="table table-bordered" style="color:black">
                    
                     <%
			String searchTerm = request.getParameter("searchNumber");
			
			//ResultSet rs = null;
			
                     	Connection con=DBConnection.getConnection();
                     	Statement st=con.createStatement();
                     	ResultSet rs=st.executeQuery("SELECT name, mobileno , distname FROM drugtracability.createbatch join manufacturer on manufacturer.email=createbatch.email WHERE hashcode = '" + searchTerm + "'");
                     
                     	//while(rs.next())
                     	if(rs.next() == false) {
                    		%>
                    	<h4 style="text-align:right;margin-right:70px"><b>No Users Present</b></h4>
                    	<%
                     	}
                    	else{
                    		int count=0;
                    		do{	 
                    	 	if(count == 0) {	
                    	 	%>
                    	 	<tr  class="danger" style="color:black">
                    	 	<!-- <th>ID</th> -->                   	 
                    	 	
		         	
		                <th > Manufacturer Name   </th>
		                <th> Manufacturer Mobile No</th> 
		                <th> Distributor </th>  
		                
		                 		                     
		                  </tr>
		                  <%}%>
                    	 <TR>
                    	
                    	 <td style="color:black"><%=rs.getString(1) %></td> 
                    	  <td style="color:black"><%=rs.getString(2) %></td> 
						<td style="color:black"><%=rs.getString(3) %></td> 
                                 	 
                    <%count++; }while(rs.next());}%> 
                   
                    </table><!-- </form>  --> 
                  
					</div>
				</div>
			</div>
		</section>

<%--
<!------------------------------------------------------------------------------>
  <div id="preloader"></div>
  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/purecounter/purecounter.js"></script>
  <script src="assets/vendor/aos/aos.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="assets/vendor/waypoints/noframework.waypoints.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script> --%>
</body>
</html>