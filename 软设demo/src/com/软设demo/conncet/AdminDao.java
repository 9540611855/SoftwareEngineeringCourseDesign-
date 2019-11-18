package com.软设demo.conncet;

import com.软设demo.model.admin;
import com.软设demo.model.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDao {
	public admin login(Connection sqls,admin admins)throws Exception{
	
		admin RetAdmin=null;
		//"select * from t_user where userName=? and password=?";
		String str_sql="select * from Admin where ma_id=? and ma_pwd=?";
		PreparedStatement pstmt=sqls.prepareStatement(str_sql);
		//System.out.println(pstmt);
		//System.out.printf("****************");
		pstmt.setString(1, admins.getMa_id());
		pstmt.setString(2, admins.getMa_pwd());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			RetAdmin=new admin();
			RetAdmin.setMa_name(rs.getString("ma_id"));
			RetAdmin.setMa_name(rs.getString("ma_pwd"));
		}
		return RetAdmin;
	}
	/*
	 * 搜寻登陆的管理员信息
	 * 
	 */
	public ResultSet showall(Connection sqls,String ma_id)throws Exception{
		StringBuffer sql=new StringBuffer("select * from `admin`");
		String maid=ma_id;
		sql.append("where ma_id ="+maid);
		PreparedStatement pstmt=sqls.prepareStatement(sql.toString());
		return pstmt.executeQuery();
	 
	}
	
	/*
	 * 更改管理员的信息
	 * 
	 */
	public int update(Connection con,admin admins)throws Exception
	{
		String sql="update `admin` set ma_name=?,ma_pwd=?,telnmuber=?,sex=? where ma_id=?";
	    
		
		PreparedStatement pstmt=con.prepareStatement(sql);
	    pstmt.setString(1, admins.getMa_name());
	    pstmt.setString(2, admins.getMa_pwd());
	    pstmt.setString(3, admins.getTelnmuber());
	    pstmt.setString(4, admins.getMa_sex());
	    pstmt.setString(5, admins.getMa_id());
	    return pstmt.executeUpdate();
	}
	
	
}
