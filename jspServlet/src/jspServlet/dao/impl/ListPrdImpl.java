package jspServlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import jspServlet.dao.ListProduct;
import jspServlet.db.DBConnect;
import jspServlet.vo.Product;

public class ListPrdImpl implements ListProduct{

	@Override
	public List<Product> ListPrd() throws Exception {
		// TODO Auto-generated method stub
		try {
			//连接数据库
			DBConnect dbc =new DBConnect();
			Connection conn=dbc.getConnection();
			PreparedStatement pstm = null;
			String sql="select * from `mydb`.`MERCHANDISE_TYPE`";
			pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery(sql);
			List<Product> p = new ArrayList<Product>();
			//将结果集的产品数据加入列表
			Product hs = null;
			while(rs.next()){
				hs=new Product();
				hs.setPrdname(rs.getString("merchandise_name"));
				hs.setPrdprice(rs.getLong("merchandise_price"));
				hs.setPrdclass(rs.getString("merchandise_class"));
				hs.setPrdimages(rs.getString("image"));
				p.add(hs);
			}
			//关闭数据库
			DBConnect.close(rs, pstm, conn);
			return p;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
