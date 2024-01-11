package Controller; 
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BankDao;
import Dto.BankAccount;
@WebServlet("/changestatus")
public class ChangeStatus extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String acn=req.getParameter("acno");
		
		long acno=Long.parseLong(acn);
		
		BankDao bankDao=new BankDao();
		BankAccount bankAccount=bankDao.fetch_By_Accno(acno);
		
		if (bankAccount.isStatus()) {
			bankAccount.setStatus(false);
		} 
		else {
			bankAccount.setStatus(true);
		}
		bankDao.update(bankAccount);
		
		List<BankAccount> list=bankDao.fetch_all_Bank_details();
		
		req.getSession().setAttribute("list", list);
//		resp.getWriter().print("<h1>For "+bankAccount.getAcc_no()+" Status has been Updated</h1>");
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
				+ "  <strong>For "+bankAccount.getAcc_no()+" Status has been Updated</strong> .\r\n"
				+ "</div>\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "</html>\r\n"
				+ "");
		req.getRequestDispatcher("account_home.jsp").include(req, resp);
	
//		resp.getWriter().print("<script>window.alert(` Status has been Updated`) </script>");
		
	}
	
}
