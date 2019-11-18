package com.软设demo.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.软设demo.conncet.bookdao;
import com.软设demo.conncet.conmysql;
import com.软设demo.model.book;
import com.软设demo.util.StringUntil;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class bookFrm extends JInternalFrame {
	private JTextField textField_1;
	private String stringsql;
	private conmysql consql=new conmysql();
	private bookdao bookdaos=new bookdao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bookFrm frame = new bookFrm();
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
	public bookFrm() {
		setMaximizable(true);
		getContentPane().setFont(new Font("宋体", Font.PLAIN, 83));
		setFrameIcon(new ImageIcon("D:\\java\\\u8F6F\u8BBEdemo\\images\\timg.png"));
		setIconifiable(true);
		setResizable(true);
		setClosable(true);
		setTitle("[\u7BA1\u7406\u5458]\u56FE\u4E66\u7BA1\u7406");
		setBounds(100, 100, 598, 480);
		/*
		 * 
		 * 查询按钮事件
		 * 
		 * 
		 */
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String BookId=textField_1.getText();
				//System.out.printf(BookId);
				if(StringUntil.isEmpty(BookId))
				{  
					JOptionPane.showMessageDialog(null, "账号不能为空！");
				}
				else
				{
					sele_book_listFrm lists=new sele_book_listFrm();
					lists.setVisible(true);
					lists.AddData(BookId);
					getContentPane().add(lists);
					
					
				}
					
					
				
				
			}
		});
		
		JButton btnNewButton_3 = new JButton("\u589E\u52A0");
		/*
		 *  增加按钮事件
		 * 
		 */
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBookFrm addbook=new AddBookFrm();
				addbook.setVisible(true);
				getContentPane().add(addbook);
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("\u4E66\u7C4D\u7F16\u53F7");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		/*
		 * 查看所有成员信息
		 * 
		 */
		JButton btnNewButton_1 = new JButton("\u67E5\u770B\u6240\u6709\u4FE1\u606F");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sele_book_listFrm lists=new sele_book_listFrm();
				lists.setVisible(true);
				lists.AllData();
				getContentPane().add(lists);
				
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED, 303, Short.MAX_VALUE)
					.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addGap(72))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.RELATED, 313, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton_1)))
		);
		getContentPane().setLayout(groupLayout);

	}
}
