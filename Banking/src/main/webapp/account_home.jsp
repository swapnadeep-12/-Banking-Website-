
<%@page import="Dto.BankAccount"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All accounts</title>
<link href="acconthome.css" rel="stylesheet">
<style>
*{
	box-sizing: border-box;
	margin: 0px;
	padding: 0px;
}

#main{
	margin: 10px auto;
	width: 90%;
}
table{
	align-self: center;
	background:  #ffe6b3
;
}

a{
	 text-decoration:none;

}
nav a{
	 text-decoration:none;

	 color: white;
	 cursor: pointer;
}
nav a:hover{
	color: hotpink;
	
}
body{
		background-image: linear-gradient(to top, rgb(192, 192, 192) 0%, rgb(255, 255, 255) 100%);

}
#changebtn{
         
         
            background-image: linear-gradient(to right, #1D976C 0%, #93F9B9  51%, #1D976C  100%);
            margin: 10px;
            text-align: center;
            text-transform: uppercase;
            transition: 0.5s;
            background-size: 200% auto;
            color: blue;            
            box-shadow: 0 0 20px #eee;
            border-radius: 10px;
            display: block;
          height: 40px;width: 100px;
          text-decoration:none;

          #changebtn:hover {
            background-position: right center; /* change the direction of the change here */
            color: #fff;
            text-decoration: none;
          }
         
}
table th{
color:blue;font-size: 15px;
font-weight: 600;
}
tr td{
text-align: center;
}
</style>
</head>
<body>
<Marquee ><h1 style="color: rgb(0, 0, 160);">Welcome To  Online Bank Services</h1></Marquee>
<nav  style="position: sticky;position: -webkit-sticky;top: 0; display: flex;padding-top:20px ; justify-content: space-around; height: 70px; background-color: rgb(0, 0, 64);color: white;">
		
		<a href="Home.html"><div>Home</div></a>
		<a href="#services"><div>Services</div></a>
		<a href="">	<div>Users</div></a>
		<a href="">	<div>About us</div></a>
	</nav>
<%
	List<BankAccount> list = (List<BankAccount>) request.getSession().getAttribute("list");
	%>
<div id="main" style="display: flex;flex-direction: column;align-items: center;">
    		<h1>All Accounts </h1>
    
    <table width='1100px' id="sig" cellspacing='25' cellpadding='25' border-spacing='2' style="margin:0;padding:0;">
<tr>
<th>Account Number</th>
<th>Account Type</th>

<th>Balance</th>

<th>Account Limit</th>


<th>Customer Name</th>

<th>Customer  id</th>

<th>Account Status</th>
</tr>
<%
		for (BankAccount bankAccount : list) {
		%>
		<tr>
			<th><%=bankAccount.getAcc_no()%></th>
			<th><%=bankAccount.getAccount_type()%></th>
			<th><%=bankAccount.getAmount()%></th>
			<th><%=bankAccount.getAcc_limit()%></th>
			
			<th><%=bankAccount.getCustomer().getName()%></th>
			<th><%=bankAccount.getCustomer().getCustid()%></th>
			<th><%=bankAccount.isStatus()%></th>

<td><a href="changestatus?acno=<%=bankAccount.getAcc_no() %>"><button id="changebtn" >Change Status</button></a></td>


</tr>
<%} %>

</table>
</div>
<footer style=" background-color: #333;
  color: #fff;
  padding: 20px;
  text-align: center;">
      <p>&copy; 2023 Bank Website. All rights reserved To Swapnadeep Baral.</p>
    </footer>

</body>
</html>