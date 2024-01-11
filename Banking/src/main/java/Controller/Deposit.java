package Controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BankDao;
import Dto.BankAccount;
import Dto.Transaction;

@WebServlet("/deposit")
public class Deposit extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String amt=req.getParameter("amount");
		double amount=Double.parseDouble(amt);
		
		long acc_no=(long) req.getSession().getAttribute("acno");
		
		BankDao bankDao=new BankDao();
		BankAccount bankAccount=bankDao.fetch_By_Accno(acc_no);
		
		double preAmount=bankAccount.getAmount();
		preAmount=preAmount+amount;
		
		bankAccount.setAmount(preAmount);
		
		bankDao.update(bankAccount);
		
		Transaction transaction=new Transaction();
		
		transaction.setBalance(bankAccount.getAmount());
		transaction.setDeposit(amount);
		transaction.setLocalDateTime(LocalDateTime.now());
		transaction.setWithdrawl(0);
		
		
		
		List<Transaction> list=bankAccount.getBankTransactions();
		
		list.add(transaction);
		bankDao.update(bankAccount);
		
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
				+ "  <strong>Amount has been deposited  successfully</strong> .\r\n"
				+ "</div>\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "</html>\r\n"
				+ "");
		req.getRequestDispatcher("Transactionpage.jsp").include(req, resp);
	}
	
}
