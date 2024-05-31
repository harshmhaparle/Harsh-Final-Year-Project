<!DOCTYPE html>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.connection.DBConnection"%>
<%@page import="java.sql.Connection"%>
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
<Style>
.contact .contact-btn{
  font-family: "Raleway", sans-serif;
  font-weight: 600;
  font-size: 15px;
  /* letter-spacing: 1px; */
  /* display: inline-block; */
  padding: 8px 28px;
  border-radius: 25px;
 /*  transition: 0.5s; */
 /*  margin-top: 10px; */
  border: 2px solid #fff;
  background-color:#0B7E51;
  color: #fff;
}
</Style>
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
          <li><a class="" href="Home.jsp">Home</a></li>
        <!--  <li><a class="" href="ProfileView.jsp">View Profile</a></li>  
          <li><a class="" href="SendDrugApproval.jsp">View Notifications</a></li>    -->      
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
      <!-- <div class="header-social-links">
        <a href="#" class="twitter"><i class="bi bi-twitter"></i></a>
        <a href="#" class="facebook"><i class="bi bi-facebook"></i></a>
        <a href="#" class="instagram"><i class="bi bi-instagram"></i></a>
        <a href="#" class="linkedin"><i class="bi bi-linkedin"></i></i></a>
      </div> -->

    </div>

  </header><!-- End Header -->

<!------------------------------------------------------------------------------>

<section id="contact">
			<div class="container"> 
				<div class="row">
					<div class="col-md-12">
						<!-- <div class="col-lg-12"> -->
							<div class="text-center color-elements">
								<br>
							<h2><b>Batch Details</b></h2>
						<br>
							</div>
						</div>
						
					<!-- <form action="SendToDistributor" Method="post">	 -->
                    <table class="table table-bordered" style="color:black">
                    
                     <%
                     Connection con=DBConnection.getConnection();
                     Statement st=con.createStatement();
                     ResultSet rs=st.executeQuery("select createbatch.id,manufacturer.name, manufacturer.address,createbatch.distname, manufacturer.email, manufacturer.mobileno, createbatch.hashcode, createbatch.batchname, createbatch.manufacturingdate, createbatch.expirydate, createbatch.price, createbatch.weight, createbatch.quantity, createbatch.status,createbatch.statuss from createbatch left join manufacturer on createbatch.email=manufacturer.email");
                     
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
                    	 <th > Name   </th>
		                     <th>Address</th>
		                     <th>Distributor</th>
		                     <th>Email</th>
		                    <!--  <th>Mobile No</th> -->
		                     <th >Batch Code</th>
		                     <th>Batch Name</th> 
		                     <th>Manufacturing Date</th>
		                     <th>Expiry Date</th>
		                    <th> Price</th>
		                     <th>Weight</th>
		                     <th>Quantity</th>
		                     <!-- <th>Email</th> -->
		                     
		                    <!--  <th>status</th> -->		                    
		                    <!--  <th>Status</th> -->
		                     <th>Send To Distributor</th>
		                     
		                  </tr>
		                  <%}%>
                    	 <TR>
                    	
                    	 <td style="color:black"><%=rs.getString(2) %></td> 
                    	  <td style="color:black"><%=rs.getString(3) %></td> 
                    	 <td style="color:black"><%=rs.getString(4) %></td>
                    	  <td style="color:black"><%=rs.getString(5) %></td>  
                         <%--<td style="color:black"><%=rs.getString(6) %></td>  --%>                  	
                    	 <td style="color:black"><%=rs.getString(7) %></td>
                    	 <td style="color:black"><%=rs.getString(8) %></td>
                    	 <td style="color:black"><%=rs.getString(9) %></td>
                          <td style="color:black"><%=rs.getString(10) %></td>
                           <td style="color:black"><%=rs.getString(11) %></td>
                            <td style="color:black"><%=rs.getString(12) %></td>
                            <td style="color:black"><%=rs.getString(13) %></td>
                               <%-- <td style="color:black"><%=rs.getString(14) %></td> --%>
                              <%-- <th><a href="BatchStatusCon?id=<%=rs.getInt(1)%>&statuss=<%=rs.getString(15)%>"><%=rs.getString(15)%></a></th> 
                    	       --%>
                    	      <%-- <td style="color:black"><%=rs.getString(15) %></td> --%>
                    	       <td><center><button style="background-color:green;"><a style="color:white;"href="SendBatchCon?id=<%=rs.getInt(1)%>&status=<%=rs.getString(14)%>"><%=rs.getString(14)%></button></a></center></td>
                                <%--  <td><a href="DeleteBatchCon?id=<%=rs.getInt(1)%>"><b>Delete</b></a></td>  --%>     
                                        	 </TR>                    	 
                    <%count++; }while(rs.next());}%> 
                   
                    </table><!-- </form>  --> 
                  
					</div>
				</div>
			</div>
		</section>


 
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
  <script src="assets/js/main.js"></script>

</body>

</html>