package jspServlet.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspServlet.dao.impl.ListPrdImpl;
import jspServlet.vo.Product;

public class ListPrdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Product> prd =  new ArrayList<Product>();
		ListPrdImpl a = new ListPrdImpl();
		HttpSession session = req.getSession();
		try {
			prd=a.ListPrd();
			session.setAttribute("merchandiselist",prd);
			res.sendRedirect("./ListProduct.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
