package com.����demo.conncet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.����demo.model.book;
import com.����demo.util.StringUntil;

/*
 * ͼ�������
 *  * �鼮����ţ�ISBN�����鼮��ţ�book_id��,
 * ����(title),����(type),����(author) 
 *,������(press),����ʱ��(press_time)
 *,�۸�(price)���洢��(count)
 * INSERT INTO `book` VALUES ('123', '0', '���򹤳̺���ԭ��', '��Ϣ��ȫ������', '���Զ','�����ʵ������','2014-5','109','5');
 */
public class bookdao {

	/*
	 * 
	 * ����ͼ��Ĳ���
	 * 
	 */
	public int add(Connection con,book books)throws Exception{
    String sqls="INSERT INTO `book` VALUES (?,?,?,?,?,?,?,?,?)";
    PreparedStatement pstmt=con.prepareStatement(sqls);
    pstmt.setString(1, books.getISBN());
    pstmt.setString(2,books.getBook_id());
    pstmt.setString(3,books.getTitle());
    pstmt.setString(4,books.getType());
    pstmt.setString(5,books.getAuthor());
    pstmt.setString(6,books.getPress());
    pstmt.setString(7,books.getPress_time());
    pstmt.setString(8,books.getPrice());
    pstmt.setString(9,books.getCount());
    return pstmt.executeUpdate();
	}
	/*
	 * ͼ���ѯ
	 * ʹ��ͨ��
	 * 
	 */
	
	public ResultSet show(Connection con,String id) throws Exception
	{
		StringBuffer sql=new StringBuffer("select * from `book`");
		String BookId=id;
		sql.append("where book_id like '%"+BookId+"%'");
		PreparedStatement pstmt=con.prepareStatement(sql.toString());
		return pstmt.executeQuery();
		
	}
	/*
	 * ��ѯ����
	 * 
	 */
	public ResultSet showall(Connection con) throws Exception
	{
		StringBuffer sql=new StringBuffer("select * from `book`");
		PreparedStatement pstmt=con.prepareStatement(sql.toString());
		return pstmt.executeQuery();
		
	}
	
	
	/*
	 * 
	 * ͼ��ɾ��
	 * 
	 * 
	 */
	public int delete(Connection con,String id)throws Exception
	{
		String sql="delete from `book` where book_id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	/*
	 * ͼ����Ϣ����
	 * 
	 */
	public int update(Connection con,book books)throws Exception
	{
		String sql="update `book` set ISBN=?,title=?,type=?,author=?,press=?,press_time=?,price=?,count=? where book_id=?";
	    
		
		PreparedStatement pstmt=con.prepareStatement(sql);
	    pstmt.setString(1, books.getISBN());
	    pstmt.setString(2,books.getTitle());
	    pstmt.setString(3,books.getType());
	    pstmt.setString(4,books.getAuthor());
	    pstmt.setString(5,books.getPress());
	    pstmt.setString(6,books.getPress_time());
	    pstmt.setString(7,books.getPrice());
	    pstmt.setString(8,books.getCount());
	    pstmt.setString(9,books.getBook_id());
	    return pstmt.executeUpdate();
	}
	/*
	 * �ж�ͼ��id �Ƿ��ظ�
	 * 
	 */
	public boolean existBookByBookTypeId(Connection con,String bookid)throws Exception{
		String sql="select * from `book` where book_id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, bookid);
		ResultSet rs=pstmt.executeQuery();
		return rs.next();
	}
	
}
