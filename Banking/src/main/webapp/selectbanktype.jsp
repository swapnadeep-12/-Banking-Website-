<%@page import="Dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bank type selection</title>
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

.main{
height:100vh;
width:50%;
display: flex;
flex-direction:column;
align-items: center;
justify-content: center;
color: blue;

}


.cancelbtn {
  padding: 14px 20px;
    background-image: linear-gradient(to right, rgb(255, 0, 0) 0%, rgb(255, 128, 64)  51%, rgb(255, 255, 0)  100%);
            margin: 10px;
            text-align: center;
            text-transform: uppercase;
            transition: 0.5s;
            background-size: 200% auto;
            color: rgb(0, 0, 128);            
            box-shadow: 0 0 20px #eee;
            border-radius: 50px;
            display: block;
                        width:150px;
            
}
.submit
	{
            background-image: linear-gradient(to right, rgb(0, 255, 0) 0%, rgb(128, 255, 128)  51%, rgb(255, 255, 0)  100%);
            margin: 10px;
            text-align: center;
            text-transform: uppercase;
            transition: 0.5s;
            width:150px;
            background-size: 200% auto;
            color: rgb(0, 0, 128);            
            box-shadow: 0 0 20px #eee;
            border-radius: 50px;
            display: block;
          
  padding: 14px 20px;
  
}
input[type=checkbox]{
.container input:checked ~ .checkmark {
  background-color: #2196F3;
}

}
</style>
</head>
<body>

<Marquee ><h1 style="color: rgb(0, 0, 160);">Welcome To  Online Bank Services</h1></Marquee>
<nav  style="position: sticky;position: -webkit-sticky;top: 0; display: flex;padding-top:20px ; justify-content: space-around; height: 70px; background-color: rgb(0, 0, 64);color: white;">
		<a href="">		
		<a href="Home.html"><div>Home</div></a>
		<a href="#services"><div>Services</div></a>
		<a href="">		<div>Users</div></a>
		<a href="">		<div>About us</div></a>
	</nav>	
	<div style="display: flex;justify-content: space-between;">
		<img alt="" src="https://img.freepik.com/free-vector/open-banking-data-access-financial-services-mobile-payment-app-development-api-technology-web-developers-designing-banking-platforms_335657-2401.jpg?w=740&t=st=1699198349~exp=1699198949~hmac=31e8941843bd824b4985d118c505fc8b1bb6c17cd8928aac989fb1f8d52ce6c8" style="width:50%; height:100vh">
	
		<div class="main" >
		<div style="height: 300px;width: 500px; background:silver; display: flex;flex-direction: column;justify-content: space-between;text-align: center;">
			<% Customer customer=(Customer)request.getSession().getAttribute("customer"); %>
		<div style="background: yellow;width: 100%">	<h1>hello: <%= customer.getName() %></h1></div>	
		<div>	<h1>Select Account Type</h1></div>
	<form action="createbankaccount" method="post">
	<div style="font-size: 30px;font-weight: 700">
		<input type="radio" name="banktype" value="savings" required="required">Savings
        <input type="radio" name="banktype" value="current" required="required">Current
	</div>
	<div style="display: flex;justify-content: space-between;"><button class="submit">Submit</button> <button class="cancelbtn" type="reset">Cancel</button></div>
	</form>
	</div>
		</div>
	</div>
	 <footer style=" background-color: #333;
  color: #fff;
  padding: 20px;
  text-align: center;">
      <p>&copy; 2023 Bank sine bank. All rights reserved to Swapnadeep Baral.</p>
    </footer>


</body>
</html>