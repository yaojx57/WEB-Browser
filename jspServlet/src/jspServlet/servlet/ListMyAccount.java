package jspServlet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jspServlet.dao.impl.UserDAOImpl;
import jspServlet.vo.User;

public class ListMyAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//判断是否登陆
		try{
			HttpSession session = req.getSession();
			UserDAOImpl user = new UserDAOImpl();
			String id =(String)session.getAttribute("cs_id");
			if(id!=null){
				//已经登陆
				//将数据库的数据放入session
				User cs=new User();
				String cs_id =(String)session.getAttribute("cs_id");
				user=new UserDAOImpl();
				cs = (User)user.listByUsername(cs_id);
				session.setAttribute("cs_name", cs.getCs_name());
				session.setAttribute("cs_gender", cs.getCs_gender());
				session.setAttribute("cs_phonenumber", cs.getCs_phonenumber());
				session.setAttribute("cs_address", cs.getCs_address());
				res.sendRedirect("./ListMyAccount.jsp");
				
			}else{
				//未登陆，进行登陆界面
				res.sendRedirect("./Login.jsp");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
