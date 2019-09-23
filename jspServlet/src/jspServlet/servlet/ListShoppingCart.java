package jspServlet.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspServlet.dao.impl.ListSCImpl;
import jspServlet.vo.ShoppingCart;

public class ListShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		String cs_id = (String)session.getAttribute("cs_id");
		if(cs_id==null){
			res.sendRedirect("./Login.jsp");
		}
		else{
			try {
				String id = (String)session.getAttribute("cs_id");
				ListSCImpl a=new ListSCImpl() ;
				List<ShoppingCart> sc = new ArrayList<ShoppingCart>();
				sc=a.listshoppingcart(id);
				int total=0;
				for(ShoppingCart sum:sc){
					total+=sum.getSum_price();
				}
				session.setAttribute("sclist", sc);
				session.setAttribute("total", total);
				res.sendRedirect("./ListShoppingCart.jsp");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
