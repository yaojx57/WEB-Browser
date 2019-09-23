package jspServlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import jspServlet.db.DBConnect;
import jspServlet.dao.listOrder;
import jspServlet.vo.Order;

public class ListOrderImpl implements listOrder {

	@Override
	public Order listorder(String sc_id) throws Exception {
		// TODO Auto-generated method stub
		try{
			DBConnect dbc = new DBConnect();
			Connection conn = dbc.getConnection();
			PreparedStatement pstm = null;
			String sql = "select * from `mydb`.`ORDER` where shoppingcart_id = ?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, sc_id);
			ResultSet rs = null;
			rs=pstm.executeQuery(sql);
			Order od = new Order();
			while(rs.next()){
				od.setOrder_date(rs.getString("order_date"));
				od.setOrder_id(rs.getString("order_id"));
				od.setOrder_state(rs.getString("order_state"));
				od.setSc_id(rs.getString("shoppingcart_id"));
			}
			DBConnect.close(rs, pstm, conn);
			return od;
		}catch(SQLException e ){
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void addorder(String od_id,String sc_id,String od_date,String od_state) throws Exception{
		//连接数据库
		try{
			DBConnect dbc = new DBConnect();
			Connection conn = dbc.getConnection();
			String sql="insert into `mydb`.`ORDER` (`order_id`,`shoppingcart_id`,`order_date`,`order_state`) "
					+ "VALUES (?,?,?,?)";
			PreparedStatement pstm=conn.prepareStatement(sql);
			//设定插入的值
			pstm.setString(1, od_id);
			pstm.setString(2,sc_id);
			pstm.setString(3,od_date);
			pstm.setString(4, od_state);
			pstm.executeUpdate(sql);
			//关闭数据库
			DBConnect.close(null, pstm, conn);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
