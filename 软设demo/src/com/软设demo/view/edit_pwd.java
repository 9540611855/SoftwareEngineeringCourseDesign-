package com.ÈíÉèdemo.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.ÈíÉèdemo.conncet.conmysql;
import com.ÈíÉèdemo.conncet.studentdao;
import com.ÈíÉèdemo.util.StringUntil;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class edit_pwd extends JInternalFrame {
	private JTextField stu_ids;
	private JTextField stu_pwds;
	private JTextField stu_names;
	private JTextField stu_sexs;
	private JTextField faculitess;
	private JTextField limits;
	private JTextField stu_numbers;
	private JTextField stu_pwdss;
	private conmysql consql=new conmysql();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					edit_pwd frame = new edit_pwd();
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
	public edit_pwd() {
		setMaximizable(true);
		setClosable(true);
		setFrameIcon(new ImageIcon("D:\\java\\\u8F6F\u8BBEdemo\\images\\timg.png"));
		setResizable(true);
		setTitle("\u5B66\u751F\u4FE1\u606F\u4FEE\u6539");
		setBounds(100, 100, 505, 581);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u5B66\u53F7");
		
		stu_ids = new JTextField();
		stu_ids.setEditable(false);
		stu_ids.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u751F\u5BC6\u7801");
		
		stu_pwds = new JTextField();
		stu_pwds.setEditable(false);
		stu_pwds.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5B66\u751F\u540D\u5B57");
		
		stu_names = new JTextField();
		stu_names.setEditable(false);
		stu_names.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u5B66\u751F\u6027\u522B");
		
		stu_sexs = new JTextField();
		stu_sexs.setEditable(false);
		stu_sexs.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u5B66\u751F\u7CFB\u522B");
		
		JLabel lblNewLabel_5 = new JLabel("\u501F\u9605\u7EA7\u522B");
		
		JLabel lblNewLabel_6 = new JLabel("\u8054\u7CFB\u7535\u8BDD");
		
		JLabel lblNewLabel_7 = new JLabel("\u65B0\u5BC6\u7801");
		
		faculitess = new JTextField();
		faculitess.setEditable(false);
		faculitess.setColumns(10);
		
		limits = new JTextField();
		limits.setEditable(false);
		limits.setColumns(10);
		
		stu_numbers = new JTextField();
		stu_numbers.setEditable(false);
		stu_numbers.setColumns(10);
		
		stu_pwdss = new JTextField();
		stu_pwdss.setColumns(10);
		/*
		 *  ÐÞ¸ÄÃÜÂë°´Å¥
		 * 
		 */
		JButton btnNewButton = new JButton("\u4FEE\u6539\u5BC6\u7801");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				String st=stu_pwdss.getText();
				String id=stu_ids.getText();
				if(StringUntil.isEmpty(st))
				{
					JOptionPane.showMessageDialog(null, "ÃÜÂë²»ÄÜÎª¿Õ");
					return;
				}
				Connection con=null;
				studentdao daos=new studentdao();
				try
				{
					
				   con=consql.getCon();
				   int n=daos.update_pwd(con, st,id);
				   if(n>0)
				   {
					   JOptionPane.showMessageDialog(null, "ÃÜÂëÐÞ¸Ä³É¹¦");
				   }
				   
				}catch(Exception e){
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "ÃÜÂëÐÞ¸ÄÊ§°Ü£¡");
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
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_5)
						.addComponent(lblNewLabel_6)
						.addComponent(lblNewLabel_7))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(stu_pwdss)
							.addComponent(stu_numbers)
							.addComponent(limits)
							.addComponent(faculitess)
							.addComponent(stu_sexs)
							.addComponent(stu_names)
							.addComponent(stu_pwds)
							.addComponent(stu_ids, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)))
					.addContainerGap(143, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(stu_ids, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(stu_pwds, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(stu_names, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(stu_sexs, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(faculitess, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(limits, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(stu_numbers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_7)
						.addComponent(stu_pwdss, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnNewButton)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
	public void put_std()
	{
		
		Connection con=null;
		studentdao daos=new studentdao();
		//System.out.print(login_on.username);
		try
		{
			
		   con=consql.getCon();
		   ResultSet rs=daos.show(con,login_on.username);
		   while(rs.next())
		   {
			   stu_ids.setText(rs.getString("stu_id"));
			   stu_names.setText(rs.getString("stu_name"));
			   stu_sexs.setText(rs.getString("stu_sex"));
			   faculitess.setText(rs.getString("faculites"));
			   limits.setText(rs.getString("limit"));
			   stu_numbers.setText(rs.getString("stu_number"));
			   stu_pwds.setText(rs.getString("stu_pwd"));			   
		   }

		   
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ÄúµÄÐÅÏ¢ÐÞ¸ÄÊ§°Ü£¡");
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
