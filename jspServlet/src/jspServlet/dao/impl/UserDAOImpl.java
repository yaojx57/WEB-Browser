package jspServlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jspServlet.dao.UserDAO;
import jspServlet.db.DBConnect;
import jspServlet.vo.User;

public class UserDAOImpl implements UserDAO {

	@Override
	public int queryByUsername(User user) throws Exception {
		// TODO Auto-generated method stub
		int flag=0;
		String sql = "select * from `mydb`.`CUSTOMER` where customer_id  = ?";
		PreparedStatement pstm = null;
		DBConnect dbc = null;
		try{
			//连接数据库
			dbc = new DBConnect();
			Connection conn = dbc.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, user.getCs_id());
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				//查处内容
				if(rs.getString("password").equals(user.getPassword())){
					flag=1;
				}
			}
			DBConnect.close(rs, pstm,conn);
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}finally{
		}
		return flag;
	}

	@Override
	public User listByUsername(String cs_id) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from `mydb`.`CUSTOMER` where customer_id=?";
		PreparedStatement pstm =null;
		DBConnect dbc= null;
		User user = new User();
		try{
			//连接数据库
			user=new User();
			dbc = new DBConnect();
			Connection conn = dbc.getConnection();
			pstm =conn.prepareStatement(sql);
			pstm.setString(1, cs_id);
			//放入结果集
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				user=new User();
				user.setCs_address(rs.getString("customer_address"));
				user.setCs_gender(rs.getString("customer_gender"));
				user.setCs_phonenumber(rs.getString("customer_phonenumber"));
				user.setCs_name(rs.getString("customer_name"));
				user.setCs_id(rs.getString("customer_id"));
			}
			DBConnect.close(rs, pstm, conn);
			return user;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	public void Register(String cs_id,String password,String cs_name,String cs_gender,String cs_phonenumber,String cs_address) throws Exception{
		try{
			DBConnect dbc = new DBConnect();
			Connection conn = dbc.getConnection();
			PreparedStatement pstm=null;
			String sql="INSERT INTO `mydb`.`CUSTOMER` "
					+ "(`customer_id`, `password`, `customer_name`, `customer_gender`, "
					+ "`customer_phonenumber`, `customer_address`) VALUES "
					+ "(?,?,?,?,?,?)";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, cs_id);
			pstm.setString(2, password);
			pstm.setString(3, cs_name);
			pstm.setString(4, cs_gender);
			pstm.setString(5, cs_phonenumber);
			pstm.setString(6, cs_address);
			pstm.executeUpdate();
			DBConnect.close(null, pstm, conn);
		}catch(SQLException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
