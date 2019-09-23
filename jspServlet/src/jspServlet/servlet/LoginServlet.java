package jspServlet.servlet;

import jspServlet.dao.UserDAO;
import jspServlet.dao.impl.UserDAOImpl;
import jspServlet.vo.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException, IOException {
		User user = new User();
		//获取响应：id和password
		user.setCs_id(req.getParameter("cs_id"));
		user.setPassword(req.getParameter("password"));
		
		UserDAO dao = new UserDAOImpl();
		int flag=0;
		try{
			//判断是否用户名密码匹配
			flag=dao.queryByUsername(user);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(flag==1){
			HttpSession session = req.getSession();
			try {
				session.setAttribute("cs_id", user.getCs_id());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			res.sendRedirect("./Home.jsp");
		}else {
			res.sendRedirect("./error.jsp");
		}
	}
	
}
