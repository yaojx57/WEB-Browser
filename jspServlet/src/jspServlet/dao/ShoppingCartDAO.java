package jspServlet.dao;

import java.util.List;

import jspServlet.vo.ShoppingCart;

public interface ShoppingCartDAO {
	public List<ShoppingCart> listshoppingcart(String cs_id) throws Exception;
}
