package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class Logout extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate();
//		resp.getWriter().print("<h1>You Are SuccessFully Logged out</h1>");
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
				+ "  <strong>You Are SuccessFully Logged out</strong> .\r\n"
				+ "</div>\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "</html>\r\n"
				+ "");
		req.getRequestDispatcher("Home.html").include(req, resp);
	}
}
