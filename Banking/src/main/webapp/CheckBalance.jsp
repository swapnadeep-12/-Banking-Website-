<%@page import="Dto.Customer"%>
<%@page import="Dto.BankAccount"%>
<%@page import="Dao.BankDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
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

</style>
<body>
<Marquee ><h1 style="color: rgb(0, 0, 160);">Welcome To  Online Bank Services</h1></Marquee>
<nav  style="position: sticky;position: -webkit-sticky;top: 0; display: flex;padding-top:20px ; justify-content: space-around; height: 70px; background-color: rgb(0, 0, 64);color: white;">
			
		<a href="Home.html"><div>Home</div></a>
		<a href="#services"><div>Services</div></a>
		<a href="">	<div>Users</div></a>
		<a href="">	<div>About us</div></a>
	</nav><%long acno=(long)request.getSession().getAttribute("acno");
	BankDao dao=new BankDao();
	BankAccount bankAccount=dao.fetch_By_Accno(acno);
	Customer customer=bankAccount.getCustomer();
	%>
<br><br>
<div style="height: 400px;width: 800px;margin: auto auto;background: gray;" >
<div style="display: flex;justify-content: space-between;background:yellow; ">
	<h2>ACCOUNT NO:<%=bankAccount.getAcc_no() %></h2>
	<h2>ACCOUNT TYPE: <%=bankAccount.getAccount_type() %></h2>
</div>
<div style="display: flex;flex-direction: column;align-items: center;margin: auto auto;justify-content:space-around;">
<br><br><br>	<h1 style="text-align: center;"> Accounts holders name :<%=customer.getName() %></h1>
	<br><br><br><h1 style="">your Account balance is  <%=bankAccount.getAmount() %></h1>
</div>
	
	

</div>
<br><br><br><br>
 <footer style=" background-color: #333;
  color: #fff;
  padding: 20px;
  text-align: center;">
      <p>&copy; 2023 Bank Website. All rights reserved to Swapnadeep Baral.</p>
    </footer>
</body>
</html>