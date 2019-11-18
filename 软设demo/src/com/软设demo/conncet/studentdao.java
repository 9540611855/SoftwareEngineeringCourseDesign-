package com.����demo.conncet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.����demo.model.admin;
import com.����demo.model.student;



public class studentdao {

	/*
	 *����ѧ����Ϣ 
	 */
	public int add(Connection con,student stu)throws Exception{
	String sqls="INSERT INTO `student` VALUES (?,?,?,?,?,?,?)";
	PreparedStatement pstmt=con.prepareStatement(sqls);
    pstmt.setString(1, stu.getStu_id());
    pstmt.setString(2, stu.getStu_pwd());
    pstmt.setString(3,stu.getStu_name());
    pstmt.setString(4,stu.getStu_sex());
    pstmt.setString(5,stu.getFaculites());
    pstmt.setString(6,stu.getLimit());
    pstmt.setString(7,stu.getStu_number());
    return pstmt.executeUpdate();
		  
	}
	/*
	 * ��ʾ���ѧ����Ϣ
	 */
	public ResultSet show(Connection con,String id) throws Exception
	{
		StringBuffer sql=new StringBuffer("select * from `student`");
		String Stu_Id=id;
		sql.append("where stu_id like '%"+Stu_Id+"%'");
		PreparedStatement pstmt=con.prepareStatement(sql.toString());
		return pstmt.executeQuery();
		
	}
	/*
	 * ��ʾ����ѧ����Ϣ
	 */
	public ResultSet showall(Connection con) throws Exception
	{
		StringBuffer sql=new StringBuffer("select * from `student`");
		PreparedStatement pstmt=con.prepareStatement(sql.toString());
		return pstmt.executeQuery();
		
	}
	/*
	 * ɾ��ѧ����Ϣ
	 */
	public int delete(Connection con,String id)throws Exception
	{
		String sql="delete from `student` where stu_id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	/*
	 * ѧ����Ϣ����
	 */
	public int update(Connection con, student stu)throws Exception
	{
		String sql="update `student` set stu_pwd=?,stu_name=?,stu_sex=?,faculites=?,`limit`=?,stu_number=? where stu_id=?";
	  //String sql="update `book` set ISBN=?,title=?,type=?,author=?,press=?,press_time=?,price=?,count=? where book_id=?";
		
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,stu.getStu_pwd());
		pstmt.setString(2,stu.getStu_name());
		pstmt.setString(3,stu.getStu_sex());
		pstmt.setString(4,stu.getFaculites());
		pstmt.setString(5,stu.getLimit());
		pstmt.setString(6,stu.getStu_number());
		pstmt.setString(7,stu.getStu_id());
	    return pstmt.executeUpdate();
	}
	/*
	 * ѧ���޸�����
	 * 
	 */
	public int update_pwd(Connection con, String pwd,String id)throws Exception
	{
		String sql="update `student` set stu_pwd=? where stu_id=?";
	  		
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,pwd);
		pstmt.setString(2,id);
	    return pstmt.executeUpdate();
	}
	/*
	 * �ж�ѧ��ѧ���Ƿ��ظ�
	 */
	public boolean exist_stu_id_(Connection con,String stuid)throws Exception{
		String sql="select * from `student` where stu_id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, stuid);
		ResultSet rs=pstmt.executeQuery();
		return rs.next();
	}
	public  student login(Connection sqls,student students)throws Exception{
		student rets=null;
		String str_sql="select * from `student` where stu_id=? and stu_pwd=?";
		PreparedStatement pstmt=sqls.prepareStatement(str_sql);
		pstmt.setString(1,students.getStu_id());
		pstmt.setString(2,students.getStu_pwd());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			rets= new student();
			rets.setStu_id(rs.getString("stu_id"));
			rets.setStu_id(rs.getString("stu_pwd"));
			
		}
		return rets;
	
	}
}
