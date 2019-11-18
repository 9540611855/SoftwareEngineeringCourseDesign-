package com.软设demo.conncet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.软设demo.model.book;
import com.软设demo.util.StringUntil;

/*
 * 图书操作类
 *  * 书籍条码号（ISBN），书籍编号（book_id）,
 * 书名(title),类型(type),作者(author) 
 *,出版商(press),出版时间(press_time)
 *,价格(price)，存储量(count)
 * INSERT INTO `book` VALUES ('123', '0', '逆向工程核心原理', '信息安全，逆向', '李承远','人民邮电出版社','2014-5','109','5');
 */
public class bookdao {

	/*
	 * 
	 * 增加图书的操作
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
	 * 图书查询
	 * 使用通配
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
	 * 查询所有
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
	 * 图书删除
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
	 * 图书信息更新
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
	 * 判断图书id 是否重复
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
