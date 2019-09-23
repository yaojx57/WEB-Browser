package jspServlet.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspServlet.dao.impl.ListOrderImpl;
import jspServlet.vo.Order;
import jspServlet.vo.ShoppingCart;

public class ListOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Order> OD =  new ArrayList<Order>();
		Order od=null;
		ListOrderImpl a = new ListOrderImpl();
		HttpSession session = req.getSession();
		try {
			List<ShoppingCart> SC=new ArrayList<ShoppingCart>();
			SC=(List<ShoppingCart>) session.getAttribute("sclist");
			for(ShoppingCart sc:SC){
				od=new Order();
				od=(Order) a.listorder(sc.getSc_id());
				OD.add(od);
			}
			session.setAttribute("OrderList",OD);
			res.sendRedirect("ListOrder.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
