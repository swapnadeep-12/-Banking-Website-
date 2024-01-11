package Controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import Dao.CustomerDao;
import Dto.Customer;


@WebServlet("/customersignup")
public class CustomerSighnup extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name= req.getParameter("customer");
		String mobile= req.getParameter("mobile");
		String password= req.getParameter("password");
		String email= req.getParameter("email");
		String gender= req.getParameter("gender");
		String dob= req.getParameter("dob");
		
		long mob=Long.parseLong(mobile);
//		resp.getWriter().println("<h1> Customer name: "+name+"</h1>"
//								+"<h1> Customer Mobile: "+mobile+"</h1>"
//								+"<h1> Customer password: "+password+"</h1>"
//								+"<h1> Customer Email: "+email+"</h1>"
//								+"<h1> Customer Gender: "+gender+"</h1>"
//								+"<h1> Customer Dob: "+dob+"</h1>"
//									);
		Date date=Date.valueOf(dob);
		Period period=Period.between(date.toLocalDate(), LocalDate.now());
		
		int age=period.getYears();
		if(age>=18)
		{
//			resp.getWriter().print("<h1> Person is eligible to create a Account </h1>");
			CustomerDao dao=new CustomerDao();
			
			List<Customer> list1=dao.fetch(mob);
			
			
			List<Customer> list2=dao.fetch(email);
			
			if(list1.isEmpty()&&list2.isEmpty())
			{
			Customer customer=new Customer();
			
			customer.setName(name);
			customer.setEmail(email);
			customer.setDob(date);
			customer.setPwd(password);
			customer.setGender(gender);
			customer.setMob(mob);
			
			
			dao.save(customer);
			
			Customer customer2= dao.fetch(email).get(0);
			long id=customer2.getCustid();
			if(gender.equals("female"))
//			if(customer2.getGender().equals("female"))  
				{
				resp.getWriter().print("<script>window.alert(`Hello mam account create succssefully`) </script>");
					resp.getWriter().print("<h1>Your Customer id is "+id);
					req.getRequestDispatcher("Home.html").include(req, resp);
				}
			else 
				{
				resp.getWriter().print("<script>window.alert(`Hello Sir account create succssefully`) </script>");
//					resp.getWriter().print("<h1>Your Customer id is "+id);
				resp.getWriter().print("<!DOCTYPE html>\r\n"
						+ "<html>\r\n"
						+ "<head>\r\n"
						+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
						+ "<style>\r\n"
						+ ".alert {\r\n"
						+ "  padding: 22px;\r\n"
						+"font-size:20px;\r\n"
						+ "  background-color: green;\r\n"
						+ "  color: white;\r\n"
						

						+ "}\r\n"
						+ "\r\n"
						+ ".closebtn {\r\n"
						+ "  margin-left: 15px;\r\n"
						+ "  color: white;\r\n"
						+ "  font-weight: bold;\r\n"
						+ "  float: right;\r\n"
						+ "  font-size: 30px;\r\n"
						+ "  line-height: 20px;\r\n"
						+ "  cursor: pointer;\r\n"
						+ "  transition: 0.3s;\r\n"
						+ "}\r\n"
						+ "\r\n"
						+ ".closebtn:hover {\r\n"
						+ "  color: black;\r\n"
						+ "}\r\n"
						+ "</style>\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "\r\n"
						+ "\r\n"
						+ "<div  class=\"alert\">\r\n"
						+ "  <span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span> \r\n"
						+ "  <strong>Your Customer id is :"+id+"</strong> .\r\n"
						+ "</div>\r\n"
						+ "\r\n"
						+ "</body>\r\n"
						+ "</html>\r\n"
						+ "");
					req.getRequestDispatcher("Home.html").include(req, resp);
				}
			}
			else {
				resp.getWriter().print("<script>window.alert(`account is alreadyexisted`)</script>");
				req.getRequestDispatcher("customerlogin.html").include(req, resp);
			}
		}
		else {
			resp.getWriter().print("<script>window.alert(`Person is not eligible to create a Account`)</script>");
			req.getRequestDispatcher("customersignup.html").include(req, resp);
			
			
		}
	}
}
