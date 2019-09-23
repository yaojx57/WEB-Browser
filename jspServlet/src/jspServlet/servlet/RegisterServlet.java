package jspServlet.servlet;

import jspServlet.dao.impl.UserDAOImpl;
import jspServlet.vo.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RegisterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		user.setCs_id(req.getParameter("cs_id"));
		user.setPassword(req.getParameter("password"));
		user.setCs_name(req.getParameter("cs_name"));
		user.setCs_gender(req.getParameter("cs_gender"));
		user.setCs_phonenumber(req.getParameter("cs_phonenumber"));
		user.setCs_address(req.getParameter("cs_address"));
		UserDAOImpl dao =new UserDAOImpl();
		try{
			dao.Register(user.getCs_id(), user.getPassword(), user.getCs_name(), user.getCs_gender(), user.getCs_phonenumber(), user.getCs_address());
			res.sendRedirect("./hometest.jsp");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
