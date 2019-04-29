<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
    <%@page import="com.mysql.jdbc.*" %>
    <%@page import="java.sql.Connection" %>
    <%@page import="java.sql.PreparedStatement" %>
    <%@page import="java.sql.ResultSet" %>
    <%@page import="java.sql.SQLException" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Resturant Search</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.6/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
  
   <style>
 .center {
    margin: auto;
    width: 60%;
    border: 3px solid #73AD21;
    padding: 10px;
    
}
* {
  box-sizing: border-box;
}
</style>
<script type="text/javascript">



</script>		

</head>
<body background="/project_term/images/5.jpg" >

<div class="container">
<div class="center" style="background-color: white">


  <h2 >Choose the Restaurants !! &#9786</h2>
  
    <form method="post" action="">
    <table class="table">
    <thead>
      <tr>
      </tr>
    </thead>
    <tbody>
  <tr>
  <td>
  	<div  >
  	 <input type="text" class="form-control" id="Search" placeholder="Search for restaurant..." name="Search" onkeyup="myFunction()">
      </div>
    </td> 
    <td>
    <div >
      <button type="submit" class="btn btn-default btn-l">
          <span class="glyphicon glyphicon-search"></span> Search 
        </button>
    </div>
    </td>
    </tr>
    
    </tbody>
  </table>
  </form>
  <%
  Connection con=null;
  try
  {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:33066/termproject?useSSL=false", "root", "Helloanant@12");
  }
  catch(ClassNotFoundException e)
	{
		System.out.println(e);
	}
 
  PreparedStatement ps=null;
	ResultSet rs=null;
   Statement stat=null;
   stat=con.createStatement();
	//PrintWriter out=response.getWriter();
	String s=request.getParameter("Search");
	//out.println(s);
	String reginsert2 = "select restid,name,address from termproject.tpj_rst where city like '%Orlando%'";
	try
	{
		StringBuffer data=null;
		//con.setAutoCommit(false); 
		
		//ps = con.prepareStatement(reginsert2);
	//	ps.setString(1, s);
		rs=stat.executeQuery(reginsert2);
		String str="<table><tr><th>name</th><th>address</th></tr>";
		out.print(str);
		while(rs.next())
		{
  
  %>
  <table>
        <tr>
            <td><%=rs.getString(1) %></td>
            <td><%=rs.getString(2) %></td>
            <td><%=rs.getString(3) %></td>
        </tr>
<%
		}
		request.setAttribute("data",data);
		request.getRequestDispatcher("resturant.jsp").forward(request, response);
		
	}
	catch(SQLException se)
	{
		System.out.println(se);
	}

%>
</table>
  
  </table>
   
</div>
 
   
</div>



</body>
</html>
