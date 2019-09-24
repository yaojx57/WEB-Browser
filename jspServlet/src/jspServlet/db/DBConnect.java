package jspServlet.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DBConnect {  
	    private final String DBDRIVER = "com.mysql.cj.jdbc.Driver" ;   
	    private final String DBURL = "jdbc:mysql://127.0.0.1:3306/mydb" ;   
	    private final String DBUSER = "root" ;   
	    private final String DBPASSWORD = "yaojx199957" ;   
	    private Connection conn = null ;   
	  
	    public DBConnect()   {   
	        try{   
	            Class.forName(DBDRIVER) ;   
	            this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD) ;  
	        }catch (Exception e){ 
	        	System.out.println(e.getMessage());  
	        	}   
	    }   
	  
	    // 取得数据库连接   
	    public Connection getConnection(){   
	        return this.conn ;   
	    }   
	  
	    // 关闭数据库连接   
	    public static void close(ResultSet rs,PreparedStatement pstm,Connection conn){   
	        try{   
		        	rs.close();
		        	pstm.close();
		        conn.close() ;   
	        }catch (Exception e){ }          
	    }   
}  
