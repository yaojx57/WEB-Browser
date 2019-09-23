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

public class AddShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession session= req.getSession();
			List<ShoppingCart> sc = new ArrayList<ShoppingCart>();
			String cs_id = (String)session.getAttribute("cs_id");
			String me_name=req.getParameter("me_name");
			ListSCImpl c=new ListSCImpl();
			ListSCImpl a=new ListSCImpl();
			boolean flag=true;
			sc=a.listshoppingcart(cs_id);
			int count=0;
			String b[]=new String[100]; 
			for(ShoppingCart a1:sc){
				b[count]=a1.getSc_id();
				if(me_name.equals(a1.getMe_name())){
					int x=a1.getMe_number();
					x++;
					int sumprice=a1.getMe_price()*x;
					c.plusSC(a1.getSc_id(), x,sumprice);
					flag=false;
					req.getRequestDispatcher("ListProduct.jsp").forward(req, res);
				}
				count++;
			}
			count--;
			if(flag){
				int me_number=1;
				String sc_id=b[count]+"1";
				int me_price=Integer.parseInt(req.getParameter("me_price"));
				int sumprice=me_price;
				c.AddSC(sc_id, cs_id, me_name, me_number, sumprice,me_price);
				req.getRequestDispatcher("ListProduct.jsp").forward(req, res);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
