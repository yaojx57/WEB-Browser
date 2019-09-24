package jspServlet.dao;


import jspServlet.vo.Order;

public interface listOrder {
	public Order listorder(String order_id) throws Exception;
	public void addorder(String od_id,String sc_id,String od_date,String od_state) throws Exception;
}
