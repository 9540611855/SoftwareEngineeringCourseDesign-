package com.����demo.conncet;
import java.sql.*;


/*
 * 
 * INSERT INTO `Admin` VALUES ('1', 'С����', '123456', '123456', '��'), 
 * ('2', 'С�ɿ�', '234567', '88888', 'Ů');
 */
public class conmysql {

	 
	    // MySQL 8.0 ���°汾 - JDBC �����������ݿ� URL
	    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	    static final String DB_URL = "jdbc:mysql://localhost:3306/BookManager";
	 
	    // MySQL 8.0 ���ϰ汾 - JDBC �����������ݿ� URL
	    //static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	    //static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&serverTimezone=UTC";
	 
	 
	    // ���ݿ���û��������룬��Ҫ�����Լ�������
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
				System.out.println("���ݿ����ӳɹ���");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("���ݿ�����ʧ��");
			}
		}
}
	    
