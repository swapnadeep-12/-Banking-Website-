package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.AdminDao;
import Dao.BankDao;
import Dto.AdminDetails;
import Dto.BankAccount;
@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email= req.getParameter("adminemail");
		String password=req.getParameter("password");
		
		AdminDao adminDao=new AdminDao();
			
			AdminDetails adminDetails2=adminDao.fetch(email).get(0);
			
			if(email.equals(adminDetails2.getEmail())&&password.equals(adminDetails2.getPass()))
			{
				resp.getWriter().print("<!DOCTYPE html>\r\n"
						+ "<html>\r\n"
						+ "<head>\r\n"
						+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
						+ "<style>\r\n"
						+ ".alert {\r\n"
						+ "  padding: 20px;\r\n"
						+ "  background-color: green;\r\n"
						+ "  color: white;\r\n"
						+ "}\r\n"
						+ "\r\n"
						+ ".closebtn {\r\n"
						+ "  margin-left: 15px;\r\n"
						+ "  color: white;\r\n"
						+ "  font-weight: bold;\r\n"
						+ "  float: right;\r\n"
						+ "  font-size: 22px;\r\n"
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
						+ "<div class=\"alert\">\r\n"
						+ "  <span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span> \r\n"
						+ "  <strong>Succsessfully Login!</strong> .\r\n"
						+ "</div>\r\n"
						+ "\r\n"
						+ "</body>\r\n"
						+ "</html>\r\n"
						+ "");
				BankDao bankDao=new BankDao();
				List<BankAccount> list=bankDao.fetch_all_Bank_details();
				
				req.getSession().setAttribute("list",list);
				req.getRequestDispatcher("account_home.jsp").include(req, resp);
			}
			else {
				resp.getWriter().print("<h1>Incorrrect Credential");
				req.getRequestDispatcher("admin.html").include(req, resp);
				
			}
		}
		
		
	}

