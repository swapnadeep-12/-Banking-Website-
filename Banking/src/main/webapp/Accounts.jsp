<%@page import="Dto.BankAccount"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
*{
	box-sizing: border-box;
	margin: 0px;
	padding: 0px;
}
nav a{
	 text-decoration: none;
	 color: white;
	 cursor: pointer;
}
nav a:hover{
	color: hotpink;
	
}


         
         button {
            background-image: linear-gradient(to right, #DA22FF 0%, #9733EE  51%, #DA22FF  100%);
            margin: 10px;
            padding: 15px 45px;
            text-align: center;
            text-transform: uppercase;
            transition: 0.5s;
            background-size: 200% auto;
            
            font-weight:700;
            box-shadow: 0 0 20px #eee;
            border-radius: 10px;
            display: block;
            font-size: 20px;
            
          }

          button:hover {
            background-position: right center; /* change the direction of the change here */
            color: #fff;
            text-decoration: none;
          }
         


</style>
</head>
<body>
<Marquee ><h1 style="color: rgb(0, 0, 160);">Welcome To  Online Bank Services</h1></Marquee>
	<nav  style="position: sticky;position: -webkit-sticky;top: 0; display: flex;padding-top:20px ; justify-content: space-around;background-color: rgb(0, 0, 64);color: white;">
		
		<a href="Home.html"><div>Home</div></a>
		<a href="#services"><div>Services</div></a>
		<a href=""><div>Users</div></a>
		<a href=""><div>About us</div></a>
	</nav>
	<div style="margin:40px auto;height: 300px;width: 700px; background: gray;display: flex;flex-direction: column;align-items: center;justify-content: space-around;">
	<h1> For use banking services click  click on bellow </h1>
<% List<BankAccount> list=(List<BankAccount>) request.getSession().getAttribute("list"); 
	
	if(list.isEmpty())
	{%>
		<h1>No_accounts_found</h1>
		
		
	<%} else{%>
		
		<%for(BankAccount bankAccount:list){ %>
			<a href="setactiveaccount?acno=<%=bankAccount.getAcc_no()%>"><button><%=bankAccount.getAcc_no() %></button></a>
			
		<%} %>
	
	<%} %>
	<a style="font-size: 20px" href="Home.html">Exit </a>
</div>
<footer style=" background-color: #333;
  color: #fff;
  padding: 20px;
  text-align: center;">
      <p>&copy; 2023 Bank Website. All rights reserved.</p>
    </footer>
</body>
</html>