package com.软设demo.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.软设demo.conncet.AdminDao;
import com.软设demo.conncet.conmysql;
import com.软设demo.model.admin;

import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class AdminFrm extends JInternalFrame {
	private JTextField id;
	private JTextField name;
	private JTextField pwd;
	private JTextField telnmuber;
	private String sexs;
	final JRadioButton man;
	final JRadioButton woman;
	private conmysql consql=new conmysql();
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFrm frame = new AdminFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void SetText()
	{
		
		 login_on login=new login_on();
		 AdminDao ad=new AdminDao();
		 String ss=login.username;
		 /*System.out.println("*******");
		 System.out.println(ss);*/
			Connection con=null;
			try
			{
			   
			   con=consql.getCon();
			   ResultSet rs=ad.showall(con, ss);
			   //System.out.println(rs);
		   
			   while(rs.next())
			   {

				   id.setText(rs.getString("ma_id"));
				   name.setText(rs.getString("ma_name"));
				   pwd.setText(rs.getString("ma_pwd"));
				   telnmuber.setText(rs.getString("telnmuber"));
				   String s=rs.getString("sex");
				   if(s=="男")
				   {
					   man.setSelected(true);   
				   }
				   else
				   {
					   woman.setSelected(true);
				   }
				   
				   	    
			   }
			   
			}catch(Exception es){
				es.printStackTrace();
				JOptionPane.showMessageDialog(null, "管理员信息获取失败！");
			}finally{
				
				try {
					consql.closeCon(con);
				} catch (Exception ess) {
					// TODO Auto-generated catch block
					ess.printStackTrace();
				}
		} 
			
}
	/**
	 * Create the frame.
	 */
	public AdminFrm() {
		setFrameIcon(new ImageIcon("D:\\java\\\u8F6F\u8BBEdemo\\images\\timg.png"));
		setTitle("\u7BA1\u7406\u5458\u4FE1\u606F\u4FEE\u6539");
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 541, 581);
		
		JLabel lblNewLabel = new JLabel("\u7BA1\u7406\u5458\u7F16\u53F7");
		
		JLabel lblNewLabel_1 = new JLabel("\u7BA1\u7406\u5458\u59D3\u540D");
		
		JLabel lblNewLabel_2 = new JLabel("\u7BA1\u7406\u5458\u5BC6\u7801");
		
		JLabel lblNewLabel_3 = new JLabel("\u7BA1\u7406\u5458\u7535\u8BDD");
		
		id = new JTextField();
		id.setEditable(false);
		id.setColumns(10);
		
		name = new JTextField();
		name.setColumns(10);
		
		pwd = new JTextField();
		pwd.setColumns(10);
		
		telnmuber = new JTextField();
		telnmuber.setColumns(10);
		
		 man = new JRadioButton("\u7537");
		buttonGroup.add(man);
		man.setSelected(true);
		
		woman = new JRadioButton("\u5973");
		buttonGroup.add(woman);
		/*
		 * 管理员信息修改
		 * 
		 */
		JButton btnNewButton = new JButton("\u4FE1\u606F\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 /*
			  * 	private JTextField id;
	private JTextField name;
	private JTextField pwd;
	private JTextField telnmuber;
	private JTextField sex;
			  * 
			  */
			AdminDao ads=new AdminDao();
			String names=name.getText();
			String pwds=pwd.getText();
			String telnmubers=telnmuber.getText();
			String ids=id.getText();
			Connection con=null;
			if(man.isSelected())
			{
				sexs="男";
			}
			else
			{
				sexs="女";
			}
			/*
			 * 		this.ma_id = ma_id;
		this.ma_name = ma_name;
		this.ma_sex = ma_sex;
		this.telnmuber = telnmuber;
		this.ma_pwd = ma_pwd;
			 */
			admin ss=new admin(ids,names,sexs,telnmubers,pwds);
			try
			{
			   
			   con=consql.getCon();
			   int n=ads.update(con, ss);
			   if(n>0)
			   {
				   JOptionPane.showMessageDialog(null, "管理员信息修改成功！");
			   }
			   else
			   {
				   JOptionPane.showMessageDialog(null, "管理员信息修改失败！");
			   }
			   
			}catch(Exception es){
				es.printStackTrace();
				JOptionPane.showMessageDialog(null, "管理员信息获取失败！");
			}finally{
				
				try {
					consql.closeCon(con);
				} catch (Exception ess) {
					// TODO Auto-generated catch block
					ess.printStackTrace();
				}
		} 
			
			
				
				
	}
			 
		});
		
		JLabel lblNewLabel_4 = new JLabel("\u4F5C\u8005\u6027\u522B");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_4))
							.addGap(65)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(man)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(woman)
									.addGap(34))
								.addComponent(telnmuber)
								.addComponent(pwd)
								.addComponent(name)
								.addComponent(id, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(86)
							.addComponent(btnNewButton)))
					.addContainerGap(145, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(pwd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(telnmuber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(54)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(woman)
						.addComponent(man)
						.addComponent(lblNewLabel_4))
					.addPreferredGap(ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(49))
		);
		getContentPane().setLayout(groupLayout);

	}
}
