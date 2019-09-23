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

public class Listbytype extends HttpServlet  {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Product> prd=new ArrayList<Product>();
		ListPrdImpl a= new ListPrdImpl();
		HttpSession session = req.getSession();
		//判断是否有商品列表
		if(session.getAttribute("merchandiselist")!=null){
			//有商品列表
			try {
				//根据类型列出产品
				ListByType(req,res);
				res.sendRedirect("./ListProductByType.jsp");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				//没有产品列表，导入产品列表
				prd= a.ListPrd();
				session.setAttribute("merchandiselist",prd);
				//根据类型列出产品
				ListByType(req,res);
				res.sendRedirect("./ListProductByType.jsp");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void ListByType(HttpServletRequest req, HttpServletResponse res) throws Exception{
		List<Product> prd = new ArrayList<Product>();
		List<Product> prdbytype = new ArrayList<Product>();
		ListPrdImpl a = new ListPrdImpl();
		HttpSession session = req.getSession();
		String me_Prdclass=(String)req.getParameter("me_Prdclass");
		prd = a.ListPrd();
		for(Product p :prd){
			if(p.getPrdclass().equals(me_Prdclass)){
				prdbytype.add(p);
			}
		}
		session.setAttribute("merchandiselisttype",prdbytype);
	}
}
