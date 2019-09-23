package jspServlet.dao.impl;

import java.util.ArrayList;
import java.util.List;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jspServlet.db.DBConnect;
import jspServlet.dao.ShoppingCartDAO;
import jspServlet.vo.ShoppingCart;

public class ListSCImpl implements ShoppingCartDAO { 
	@Override
	public List<ShoppingCart> listshoppingcart(String cs_id) throws Exception {
		// TODO Auto-generated method stub
		try{
			DBConnect dbc = new DBConnect();
			Connection  conn  = dbc.getConnection();
			PreparedStatement pstm =null;
			String sql  = "select * from `mydb`.`SHOPPINGCART` where customer_id=?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, cs_id);
			List<ShoppingCart> SC = new ArrayList<ShoppingCart>();
			ResultSet rs=pstm.executeQuery();
			ShoppingCart sc  = null;
			while(rs.next()){
				sc=new ShoppingCart();
				sc.setMe_name(rs.getString("merchandise_name"));
				sc.setMe_number(rs.getInt("merchandise_number"));
				sc.setSc_id(rs.getString("shoppingcart_id"));
				sc.setCs_id(rs.getString("customer_id"));
				sc.setMe_price(rs.getInt("merchandise_price"));
				sc.setSum_price(rs.getInt("sumprice"));
				SC.add(sc);
			}
			DBConnect.close(rs, pstm, conn);
			return SC;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public void AddSC(String sc_id,String cs_id,String me_name,int me_number,int sumprice,int me_price) throws Exception{
		try{
			DBConnect dbc = new DBConnect();
			Connection conn=dbc.getConnection();
			PreparedStatement pstm=null;
			String sql="INSERT INTO `mydb`.`SHOPPINGCART` "
					+ "(`shoppingcart_id`, `merchandise_name`, `merchandise_number`, "
					+ "`sumprice`, `customer_id`, `merchandise_price`)" 
					+ " VALUES (?,?,?,?,?,?)";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, sc_id);
			pstm.setString(2,me_name);
			pstm.setInt(3,me_number);
			pstm.setInt(4, sumprice);
			pstm.setString(5,cs_id);
			pstm.setInt(6, me_price);
			pstm.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void plusSC(String sc_id,int me_number,int sumprice) throws Exception{
		try{
			DBConnect dbc = new DBConnect();
			Connection  conn  = dbc.getConnection();
			PreparedStatement pstm =null;
			String sql="UPDATE `mydb`.`SHOPPINGCART` SET `merchandise_number` = ?,`sumprice`=? WHERE (`shoppingcart_id` = ?)";
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, me_number);
			pstm.setInt(2, sumprice);
			pstm.setString(3, sc_id);
			pstm.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void delete(String sc_id) throws Exception{
		try{
			DBConnect dbc=new DBConnect();
			Connection conn=dbc.getConnection();
			PreparedStatement pstm=null;
			String sql="delete from `mydb`.`shoppingcart` where (shoppingcart_id=?)";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, sc_id);
			pstm.executeUpdate(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
