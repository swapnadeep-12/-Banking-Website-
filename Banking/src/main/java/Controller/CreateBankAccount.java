package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BankDao;
import Dao.CustomerDao;
import Dto.BankAccount;
import Dto.Customer;

@WebServlet("/createbankaccount")
public class CreateBankAccount extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String banktype=req.getParameter("banktype");
		Customer customer=(Customer) req.getSession().getAttribute("customer");
		
		List<BankAccount> list1=customer.getList();
		boolean flag=true;
		for (BankAccount bankAccount : list1) {
			if (bankAccount.getAccount_type().equals(banktype)) {
				
//				resp.getWriter().print("<script>window.alert(`Account is already Exist`)</script>");
				resp.getWriter().print("<!DOCTYPE html>\r\n"
						+ "<html>\r\n"
						+ "<head>\r\n"
						+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
						+ "<style>\r\n"
						+ ".alert {\r\n"
						+ "  padding: 22px;\r\n"
						+"font-size:20px;\r\n"
						+ "  background-color: red;\r\n"
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
						+ "  <strong>Your Account Is already Existed!</strong> .\r\n"
						+ "</div>\r\n"
						+ "\r\n"
						+ "</body>\r\n"
						+ "</html>\r\n"
						+ "");
				req.getRequestDispatcher("customerhome.html").include(req, resp);
				flag=false;
			}
		}
		if(flag)
		{
			BankAccount bankAccount=new BankAccount();
			
			bankAccount.setAccount_type(banktype);
			
			if (bankAccount.getAccount_type().equals("savings")) 
				bankAccount.setAcc_limit(10000);
			else 
				bankAccount.setAcc_limit(20000);
			
			bankAccount.setCustomer(customer);
			
			BankDao bankDao=new BankDao();
			bankDao.save(bankAccount);
			
			List<BankAccount> list2=list1;
			list2.add(bankAccount);
			customer.setList(list2);
			
			CustomerDao dao=new CustomerDao();
			dao.update(customer);
//			resp.getWriter().print(customer.getName()+" your "+bankAccount.getAccount_type()+"account is created Succefully");
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
					+ "  <strong>Bank Account has been created Successfully Waiting for Bank Manager Approval !</strong> .\r\n"
					+ "</div>\r\n"
					+ "\r\n"
					+ "</body>\r\n"
					+ "</html>\r\n"
					+ "");
			req.getRequestDispatcher("Home.html").include(req, resp);

		}
			}
	
}
