package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.BankAccount;
import Dto.Customer;

@WebServlet("/fetchActiveAccounts")
public class Fetch_Active_Accounts extends HttpServlet{
	 
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Customer customer=(Customer) req.getSession().getAttribute("customer");
		
		List<BankAccount> list= customer.getList();
		
		List<BankAccount> list2=new ArrayList<BankAccount>();
		
		for (BankAccount bankAccount : list) {
			if(bankAccount.isStatus())
			{
				list2.add(bankAccount);
//				resp.getWriter().print("Active Accounts found");
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
						+ "   Active account Founds! \r\n"
						+ "</div>\r\n"
						+ "\r\n"
						+ "</body>\r\n"
						+ "</html>\r\n"
						+ "");
			}
			else {
				resp.getWriter().print("Active Accounts not found");
			}
		}
		req.getSession().setAttribute("list", list2);
		req.getRequestDispatcher("Accounts.jsp").forward(req, resp);
	}
}
