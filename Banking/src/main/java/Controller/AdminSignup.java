package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.AdminDao;
import Dto.AdminDetails;

@WebServlet("/adminsighnup")
public class AdminSignup extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email= req.getParameter("adminemail");
		String password=req.getParameter("password");
		String name=req.getParameter("name");
		
		AdminDao adminDao=new AdminDao();
		
		List<AdminDetails> list1=adminDao.fetch(email);
		if (list1.isEmpty()) {
			AdminDetails adminDetails=new AdminDetails();
			adminDetails.setName(name);
			adminDetails.setEmail(email);
			adminDetails.setPass(password);
			adminDao.save(adminDetails);
			resp.getWriter().println("<h1> Admin Sighn Up Success");
			resp.getWriter().print("Hello admin "+adminDetails.getName()+" You can Log in now");
			req.getRequestDispatcher("admin.html").include(req, resp);
		}
		else {
			resp.getWriter().print("<h1> Admin is Already Exist You can Log In");
			req.getRequestDispatcher("admin.html").include(req, resp);
		}
	
		
}
	
}
