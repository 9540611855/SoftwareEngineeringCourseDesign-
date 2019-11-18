package com.软设demo.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.软设demo.conncet.bookdao;
import com.软设demo.conncet.conmysql;
import com.软设demo.model.book;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class sele_book_listFrm extends JInternalFrame {
	private JTable book_table;
	private conmysql consql=new conmysql();
	private bookdao bookdaos=new bookdao();
	private JTextField title_text;
	private JTextField author_text;
	private JTextField press_time_text;
	private JTextField count_text;
	private JTextField ISBN_text;
	private JTextField book_id_text;
	private JTextField type_text;
	private JTextField press_text;
	private JTextField price_text;
	/** 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sele_book_listFrm frame = new sele_book_listFrm();
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
	public sele_book_listFrm() {
		setMaximizable(true);
		setClosable(true);
		setTitle("\u56FE\u4E66\u67E5\u8BE2\u7ED3\u679C");
		setFrameIcon(new ImageIcon("D:\\java\\\u8F6F\u8BBEdemo\\images\\timg.png"));
		setIconifiable(true);
		setResizable(true);
		setBounds(100, 100, 923, 758);
		
		JScrollPane scrollPane = new JScrollPane();
		
		book_table = new JTable();
		/*
		 * 表格    鼠标左键点击事件
		 * 
		 * 
		 */
		book_table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				//System.out.println("****");
				BookTableMousePressed(arg0);
			}
		});
		book_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ISBN", "\u4E66\u7C4D\u7F16\u53F7", "\u4E66\u7C4D\u540D\u79F0", "\u4E66\u7C4D\u7C7B\u522B", "\u4E66\u7C4D\u4F5C\u8005", "\u4E66\u7C4D\u51FA\u7248\u793E", "\u4E66\u7C4D\u51FA\u7248\u65F6\u95F4", "\u4E66\u7C4D\u4EF7\u683C", "\u4E66\u7C4D\u53EF\u501F\u9605\u6570\u91CF"
			}
		));
		book_table.getColumnModel().getColumn(1).setPreferredWidth(87);
		book_table.getColumnModel().getColumn(2).setPreferredWidth(85);
		book_table.getColumnModel().getColumn(3).setPreferredWidth(87);
		book_table.getColumnModel().getColumn(4).setPreferredWidth(84);
		book_table.getColumnModel().getColumn(5).setPreferredWidth(103);
		book_table.getColumnModel().getColumn(6).setPreferredWidth(122);
		book_table.getColumnModel().getColumn(7).setPreferredWidth(87);
		book_table.getColumnModel().getColumn(8).setPreferredWidth(143);
		scrollPane.setViewportView(book_table);
		
		JLabel lblNewLabel = new JLabel("\u4E66\u7C4D\u540D\u79F0");
		
		JLabel lblNewLabel_1 = new JLabel("\u4E66\u7C4D\u4F5C\u8005");
		
		JLabel lblNewLabel_2 = new JLabel("\u4E66\u7C4D\u51FA\u7248\u65F6\u95F4");
		
		JLabel lblNewLabel_3 = new JLabel("\u4E66\u7C4D\u53EF\u501F\u9605\u6570\u91CF");
		
		title_text = new JTextField();
		title_text.setColumns(10);
		
		author_text = new JTextField();
		author_text.setColumns(10);
		
		press_time_text = new JTextField();
		press_time_text.setColumns(10);
		
		count_text = new JTextField();
		count_text.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("ISBN");
		
		ISBN_text = new JTextField();
		ISBN_text.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u4E66\u7C4D\u7F16\u53F7");
		
		book_id_text = new JTextField();
		book_id_text.setEditable(false);
		book_id_text.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u4E66\u7C4D\u7C7B\u522B");
		
		type_text = new JTextField();
		type_text.setColumns(10);
		
		press_text = new JTextField();
		press_text.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\u4E66\u7C4D\u51FA\u7248\u793E");
		
		JLabel lblNewLabel_8 = new JLabel("\u4E66\u7C4D\u4EF7\u683C");
		
		price_text = new JTextField();
		price_text.setColumns(10);
		/*
		 * 修改按钮事件
		 * 
		 */
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				book bookup=new book();

				bookup.setISBN((String)ISBN_text.getText());
				bookup.setBook_id((String)book_id_text.getText());
				bookup.setTitle((String)title_text.getText());
				bookup.setAuthor((String)author_text.getText());
				bookup.setPress((String)press_text.getText());
				bookup.setPress_time((String)press_time_text.getText());
				bookup.setPrice((String)price_text.getText());
				bookup.setType((String)type_text.getText());
				bookup.setCount((String)count_text.getText());
				Connection con=null;
				try
				{
				   bookdao bookdap=new bookdao();
				   con=consql.getCon();
				   int n=bookdap.update(con, bookup);
				   if(n>0)
				   {
					   JOptionPane.showMessageDialog(null, "图书修改成功！");   
				   }
				   else
				   {
					   JOptionPane.showMessageDialog(null, "图书修改失败！");   
				   }
				   
				}catch(Exception e){
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "图书修改失败！");
				}finally{
					
					try {
						consql.closeCon(con);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
				
			}
		}
		});
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookdao bookdap=new bookdao();
				String id=(String)book_id_text.getText();
				Connection con=null;
				try
				{
				  
				   con=consql.getCon();
				   int n=bookdap.delete(con, id);
				   if(n>0)
				   {
					   JOptionPane.showMessageDialog(null, "图书删除成功！");
				   }
				   else
				   {
					   JOptionPane.showMessageDialog(null, "图书删除失败！");
				   }
				  
				}catch(Exception es){
					es.printStackTrace();
					JOptionPane.showMessageDialog(null, "图书删除失败！");
				}finally{
					
					try {
						consql.closeCon(con);
					} catch (Exception es) {
						// TODO Auto-generated catch block
						es.printStackTrace();
					}
				}
				
				//bookdap.delete(con, id);
				
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 907, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_4))
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(ISBN_text)
								.addComponent(count_text)
								.addComponent(press_time_text)
								.addComponent(author_text)
								.addComponent(title_text, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
							.addGap(107)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_5)
										.addComponent(lblNewLabel_6)
										.addComponent(lblNewLabel_7)
										.addComponent(lblNewLabel_8))
									.addGap(65)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(price_text)
										.addComponent(press_text)
										.addComponent(type_text)
										.addComponent(book_id_text, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED, 188, Short.MAX_VALUE))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
									.addGap(92)))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_4)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(ISBN_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_5)
							.addComponent(book_id_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(title_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6)
						.addComponent(type_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(author_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(press_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_7))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(press_time_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_8)
						.addComponent(price_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(count_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
	/*
	 *  表格行点击
	 *  鼠标点击函数
	 * 
	 */
	private void BookTableMousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int row=book_table.getSelectedRow();

		ISBN_text.setText((String)book_table.getValueAt(row,0));
		book_id_text.setText((String)book_table.getValueAt(row,1));
		title_text.setText((String)book_table.getValueAt(row,2));
		type_text.setText((String)book_table.getValueAt(row,3));
		author_text.setText((String)book_table.getValueAt(row,4));
		press_text.setText((String)book_table.getValueAt(row,5));
		press_time_text.setText((String)book_table.getValueAt(row,6));
		price_text.setText((String)book_table.getValueAt(row,7));
		count_text.setText((String)book_table.getValueAt(row,8));
		
	}

	public void AddData(String BookId)
	{
		DefaultTableModel dtm=(DefaultTableModel) book_table.getModel();
		dtm.setRowCount(0); // 设置成0行
		Connection con=null;
		try
		{
		   
		   con=consql.getCon();
		   ResultSet rs=bookdaos.show(con, BookId);
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
	public void AllData()
	{
		DefaultTableModel dtm=(DefaultTableModel) book_table.getModel();
		dtm.setRowCount(0); // 设置成0行
		Connection con=null;
		try
		{
		   
		   con=consql.getCon();
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
