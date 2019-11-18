package com.软设demo.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.软设demo.conncet.bookdao;
import com.软设demo.conncet.conmysql;
import com.软设demo.model.book;
import com.软设demo.util.StringUntil;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class AddBookFrm extends JInternalFrame {
	private JTextField ISBN_text;
	private JTextField book_id_text;
	private JTextField title_text;
	private JTextField type_text;
	private JTextField author_text;
	private JTextField press_text;
	private JTextField press_time_text;
	private JTextField price_text;
	private JTextField count_text;
	private conmysql consql=new conmysql();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBookFrm frame = new AddBookFrm();
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
	public AddBookFrm() {
		setFrameIcon(new ImageIcon("D:\\java\\\u8F6F\u8BBEdemo\\images\\timg.png"));
		setResizable(true);
		setTitle("\u56FE\u4E66\u589E\u52A0");
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 783, 651);
		
		JLabel lblNewLabel = new JLabel("ISBN");
		
		JLabel lblNewLabel_1 = new JLabel("\u4E66\u7C4D\u7F16\u53F7");
		
		JLabel lblNewLabel_2 = new JLabel("\u4E66\u7C4D\u540D\u79F0");
		
		JLabel lblNewLabel_3 = new JLabel("\u4E66\u7C4D\u7C7B\u522B");
		
		JLabel lblNewLabel_4 = new JLabel("\u4E66\u7C4D\u4F5C\u8005");
		
		JLabel lblNewLabel_5 = new JLabel("\u4E66\u7C4D\u51FA\u7248\u793E");
		
		JLabel lblNewLabel_6 = new JLabel("\u4E66\u7C4D\u51FA\u7248\u65F6\u95F4");
		
		JLabel lblNewLabel_7 = new JLabel("\u4E66\u7C4D\u4EF7\u683C");
		
		JLabel lblNewLabel_8 = new JLabel("\u4E66\u7C4D\u53EF\u501F\u9605\u6570\u91CF");
		
		ISBN_text = new JTextField();
		ISBN_text.setColumns(10);
		
		book_id_text = new JTextField();
		book_id_text.setColumns(10);
		
		title_text = new JTextField();
		title_text.setColumns(10);
		
		type_text = new JTextField();
		type_text.setColumns(10);
		
		author_text = new JTextField();
		author_text.setColumns(10);
		
		press_text = new JTextField();
		press_text.setColumns(10);
		
		press_time_text = new JTextField();
		press_time_text.setColumns(10);
		
		price_text = new JTextField();
		price_text.setColumns(10);
		
		count_text = new JTextField();
		count_text.setColumns(10);
		/*
		 * 
		 * 增加图书  按钮事件
		 * 
		 * 
		 */
		JButton btnNewButton = new JButton("\u6DFB\u52A0\u4E66\u7C4D\u4FE1\u606F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				book bookup=new book();
				if(StringUntil.isEmpty((String)ISBN_text.getText())
				||StringUntil.isEmpty((String)book_id_text.getText())
				||StringUntil.isEmpty((String)title_text.getText())
				||StringUntil.isEmpty((String)author_text.getText())
				||StringUntil.isEmpty((String)press_text.getText())
				||StringUntil.isEmpty((String)press_time_text.getText())
				||StringUntil.isEmpty((String)price_text.getText())
				||StringUntil.isEmpty((String)type_text.getText())
				||StringUntil.isEmpty((String)count_text.getText())
						)
				{ 
					
					 JOptionPane.showMessageDialog(null, "输入框内不能为空");
					 return;
					
				}
				
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
				   String bookid=(String)bookup.getBook_id();
				   if(bookdap.existBookByBookTypeId(con, bookid))
				   {
					   JOptionPane.showMessageDialog(null, "书籍编号已经存在！");
					   return;
				   }
				   int n=bookdap.add(con, bookup);
				   if(n==1)
				   {
					   JOptionPane.showMessageDialog(null, "图书添加成功！");	   
				   }
				   else
				   {
					   JOptionPane.showMessageDialog(null, "图书添加失败！");
				   }
				}catch(Exception e){
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "图书添加失败！");
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
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_5)
						.addComponent(lblNewLabel_6)
						.addComponent(lblNewLabel_7)
						.addComponent(lblNewLabel_8))
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(count_text)
						.addComponent(price_text)
						.addComponent(press_time_text)
						.addComponent(press_text)
						.addComponent(author_text)
						.addComponent(type_text)
						.addComponent(title_text)
						.addComponent(book_id_text)
						.addComponent(ISBN_text, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(87))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(ISBN_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(book_id_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addGap(43)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3)
								.addComponent(type_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(49)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_4)
								.addComponent(author_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(54)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_5)
								.addComponent(press_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(title_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_6)
							.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_7)
								.addComponent(price_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_8)
								.addComponent(count_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(29))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(press_time_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addGap(48))))
		);
		getContentPane().setLayout(groupLayout);

	}
   
}
