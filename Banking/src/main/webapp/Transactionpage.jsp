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
button {
	height: 50px;
	width: 200px;
	cursor: pointer;
	border:none;
	color:white;
	border-radius: 50px;
	font-weight:700;
		background: blue;
	
}
button:hover{
background-image: linear-gradient(to right, #C33764 0%, #1D2671  51%, #C33764  100%);

}
#main{
margin: 30px auto;
background-image: linear-gradient(to right, #B2FEFA 0%, #0ED2F7  51%, #B2FEFA  100%);
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
	
<div style="display: flex;justify-content: flex-start;">
		<div ><img src="transaction.jpg"></div>


<div id="main" style="height: 400px;width: 800px;display: flex;flex-direction: column;justify-content:space-between; align-items: center;padding-bottom: 30px">
			<div style="text-align: center; background: yellow;width: 100%"><h1>Chose Your Transaction</h1></div>
<a href="Deposit.html"><button>Deposit</button></a>
	<a href="Withdraw.html"><button>Withdraw</button></a>
	<a href="CheckBalance.jsp"><button>Check Balance</button></a>
	<a href="transactionHistory.jsp"><button>View Transaction History</button></a>
</div>
</div>

<br>

<footer style=" background-color: #333;
  color: #fff;
  padding: 20px;
  text-align: center;">
      <p>&copy; 2023 Bank Website. All rights reserved.</p>
    </footer>
    
             
         
    
    
</body>
</html>