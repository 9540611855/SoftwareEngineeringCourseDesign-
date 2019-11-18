package com.软设demo.conncet;
import java.sql.*;


/*
 * 
 * INSERT INTO `Admin` VALUES ('1', '小康康', '123456', '123456', '男'), 
 * ('2', '小可可', '234567', '88888', '女');
 */
public class conmysql {

	 
	    // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
	    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	    static final String DB_URL = "jdbc:mysql://localhost:3306/BookManager";
	 
	    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
	    //static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	    //static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&serverTimezone=UTC";
	 
	 
	    // 数据库的用户名与密码，需要根据自己的设置
	    static final String USER = "pipixia";
	    static final String PASS = "123456";
	 
	    public Connection getCon()throws Exception{
			Class.forName(JDBC_DRIVER);
			Connection con=DriverManager.getConnection(DB_URL, USER, PASS);
			
			return con;
		}
		public void closeCon(Connection con)throws Exception{
			if(con!=null){
				con.close();
			}
		}
	
		public static void main(String[] args) {
			conmysql dbUtil=new conmysql();
			try {
				dbUtil.getCon();
				System.out.println("数据库连接成功！");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("数据库连接失败");
			}
		}
}
	    
