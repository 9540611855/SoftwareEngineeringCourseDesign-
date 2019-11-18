package com.软设demo.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.软设demo.conncet.bookdao;
import com.软设demo.conncet.conmysql;

public class student_sele_book extends JInternalFrame {
	private JTable table;
	private conmysql consql=new conmysql();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student_sele_book frame = new student_sele_book();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public student_sele_book() {
		setClosable(true);
		setTitle("[\u5B66\u751F]\u56FE\u4E66\u67E5\u8BE2");
		setFrameIcon(new ImageIcon("D:\\java\\\u8F6F\u8BBEdemo\\images\\timg.png"));
		setMaximizable(true);
		setBounds(100, 100, 957, 642);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 914, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ISBN", "\u4E66\u7C4D\u7F16\u53F7", "\u4E66\u7C4D\u540D\u79F0", "\u4E66\u7C4D\u7C7B\u522B", "\u4E66\u7C4D\u4F5C\u8005", "\u4E66\u7C4D\u51FA\u7248\u793E", "\u4E66\u7C4D\u51FA\u7248\u65F6\u95F4", "\u4E66\u7C4D\u4EF7\u683C", "\u4E66\u7C4D\u53EF\u501F\u9605\u6570\u91CF"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(61);
		table.getColumnModel().getColumn(1).setPreferredWidth(85);
		table.getColumnModel().getColumn(2).setPreferredWidth(86);
		table.getColumnModel().getColumn(3).setPreferredWidth(92);
		table.getColumnModel().getColumn(4).setPreferredWidth(86);
		table.getColumnModel().getColumn(5).setPreferredWidth(104);
		table.getColumnModel().getColumn(6).setPreferredWidth(126);
		table.getColumnModel().getColumn(7).setPreferredWidth(88);
		table.getColumnModel().getColumn(8).setPreferredWidth(139);
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);

	}
	/*
	 *  查询一条数据 
	 */
	public void AddData(String BookId)
	{
		DefaultTableModel dtm=(DefaultTableModel) table.getModel();
		dtm.setRowCount(0); // 设置成0行
		Connection con=null;
		try
		{
		   
		   con=consql.getCon();
		   bookdao bookda=new bookdao();
		   ResultSet rs=bookda.show(con, BookId);
		   //System.out.println(rs);
	   
		   while(rs.next())
		   {
			   Vector v=new Vector();
			  // System.out.println("112");
				  v.add(rs.getString("ISBN"));
				  v.add(rs.getString("book_id"));
				  v.add(rs.getString("title"));
				  v.add(rs.getString("type"));
				  v.add(rs.getString("author"));
				  v.add(rs.getString("press"));
				  v.add(rs.getString("press_time"));
				  v.add(rs.getString("price"));
				  v.add(rs.getString("count"));
			  dtm.addRow(v);
				   
		   }
		   
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书查询失败！");
		}finally{
			
			try {
				consql.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	}
	/*
	 * 查询所有信息数据
	 */
	public void AllData()
	{
		DefaultTableModel dtm=(DefaultTableModel) table.getModel();
		dtm.setRowCount(0); // 设置成0行
		Connection con=null;
		try
		{
		   
		   con=consql.getCon();
		   bookdao bookdaos=new bookdao();
		   ResultSet rs=bookdaos.showall(con);
		   //System.out.println(rs);
	   
		   while(rs.next())
		   {
			   Vector v=new Vector();
			  // System.out.println("112");
			  v.add(rs.getString("ISBN"));
			  v.add(rs.getString("book_id"));
			  v.add(rs.getString("title"));
			  v.add(rs.getString("type"));
			  v.add(rs.getString("author"));
			  v.add(rs.getString("press"));
			  v.add(rs.getString("press_time"));
			  v.add(rs.getString("price"));
			  v.add(rs.getString("count"));
			  dtm.addRow(v);
			   
			 
			    
		   }
		   
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书查询失败！");
		}finally{
			
			try {
				consql.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
		
	}
}
