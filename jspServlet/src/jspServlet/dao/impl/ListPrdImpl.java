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
			//杩炴帴鏁版嵁搴�
			int flag=0;
			DBConnect dbc =new DBConnect();
			Connection conn=dbc.getConnection();
			PreparedStatement pstm = null;
			String sql="select * from `mydb`.`MERCHANDISE_TYPE`";
			pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery(sql);
			List<Product> p = new ArrayList<Product>();
			//灏嗙粨鏋滈泦鐨勪骇鍝佹暟鎹姞鍏ュ垪琛�
			Product hs = null;
			while(rs.next()){
				flag++;
				if(flag>2)break;
				hs=new Product();
				hs.setPrdname(rs.getString("merchandise_name"));
				hs.setPrdprice(rs.getLong("merchandise_price"));
				hs.setPrdclass(rs.getString("merchandise_class"));
				hs.setPrdimages(rs.getString("image"));
				p.add(hs);
			}
			//鍏抽棴鏁版嵁搴�
			DBConnect.close(rs, pstm, conn);
			return p;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
