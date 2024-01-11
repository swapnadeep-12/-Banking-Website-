<%@page import="Dto.Transaction"%>
<%@page import="java.util.List"%>
<%@page import="Dto.BankAccount"%>
<%@page import="Dao.BankDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaction History</title>
<style type="text/css">
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
table{
	    position: absolute;
    top: 138px;
    left: 369px;
	align-self: center;
	background:  #ffe6b3;
	color: blue;
	width: 800px;
	background:#00d2ff;
	padding: auto auto;
	

}

button{
	  background-image: linear-gradient(to right, #4776E6 0%, #8E54E9  51%, #4776E6  100%);
            margin: 10px;
            padding: 15px 45px;
            text-align: center;
            text-decoration:none;
            text-transform: uppercase;
            transition: 0.5s;
            background-size: 200% auto;
            color: black;            
            font-weight:500;
            box-shadow: 0 0 20px #eee;
           
            display: block;
          }

}
 button:hover {
            background-position: right center; /* change the direction of the change here */
            color: #fff;
            text-decoration: none;
          }
         

</style>
</head>
<body>

	<nav  style="position: sticky;position: -webkit-sticky;top: 0; display: flex;padding-top:20px ; justify-content: space-around; height: 70px; background-color: rgb(0, 0, 64);color: white;">
			
		<a href="Home.html">		<div>Home</div></a>
		<a href="#services">		<div>Services</div></a>
		<a href="">		<div>Users</div></a>
		
		<a href="logout" >	<div>Logout</div></a>
	</nav>
<%
		long acno =(long) request.getSession().getAttribute("acno");
		BankDao bankDao=new BankDao();
		BankAccount bankAccount=bankDao.fetch_By_Accno(acno);
		List<Transaction> list=bankAccount.getBankTransactions();
		
	%>
<div style="display: flex; flex-direction: column;align-items: center;background: gray;">


<div style="display: flex; flex-direction: column;align-items: center;width: 800px;overflow: auto;height: 400px;overflow-x: hidden;	
">

	
	<table 	cellspacing='25' cellpadding='25'
	>
	<div style="background: yellow;width: 8000px;text-align: center;position:fixed; top: 71px;"><h2>Account No :<%=acno %></h2></div>
<div style="background: yellow;width: 800px;text-align: center;position: fixed;top: 98px"><h3>Account Type: <%=bankAccount.getAccount_type() %> </h3><br></div>
	
	
	<tr>
	<th>Transaction id</th>
	<th> Deposit amount</th>
	<th>Withdraw Amount</th>
	<th>Balance</th>
	<th>Time & Date</th>
	
	</tr>
	<%for(Transaction transaction:list) {%>
		<tr>
			<th><%=transaction.getTid() %></th>
			<th><%=transaction.getDeposit() %></th>
			<th><%=transaction.getWithdrawl() %></th>
			<th><%=transaction.getBalance() %></th>
			<th><%=transaction.getLocalDateTime() %></th>
		</tr>
		<%} %>
	</table>
	<div style="background: green;width: 800px;text-align: center;"> <h2>Total balance :<%=bankAccount.getAmount() %></h2></div>
	</div>
	<br><br>
		<a href="Transactionpage.jsp"><button style=" border-radius: 10px;  background-image: linear-gradient(to right, #4776E6 0%, #8E54E9  51%, #4776E6  100%);height: 50px;width: 150px">Back</button></a>
	
	</div>
	
	<footer style=" background-color: #333;
  color: #fff;
  padding: 20px;
  text-align: center;">
      <p>&copy; 2023 Bank Website. All rights reserved to Swapnadeep Baral.</p>
    </footer>
</body>
</html>