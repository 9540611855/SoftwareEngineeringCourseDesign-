package com.软设demo.view;


import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.软设demo.conncet.AdminDao;
import com.软设demo.conncet.conmysql;
import com.软设demo.conncet.studentdao;
import com.软设demo.model.admin;
import com.软设demo.model.student;
import com.软设demo.util.StringUntil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;

public class login_on extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private conmysql conmysqls=new conmysql();
	private AdminDao admindao=new AdminDao();
	public  static String username=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_on frame = new login_on();
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
	public login_on() {
		Font font = new Font("Dialog", Font.PLAIN, 12);
		Enumeration<Object> keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, font);
			}
		}
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\java\\\u8F6F\u8BBEdemo\\images\\timg.png"));
		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u4F7F\u7528");
		lblNewLabel.setIcon(new ImageIcon("D:\\java\\\u8F6F\u8BBEdemo\\images\\timg.png"));
		
		JLabel lblNewLabel_1 = new JLabel("\u8D26\u53F7");
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801");
		
		textField = new JTextField();
		textField.setFont(new Font("黑体", Font.PLAIN, 22));
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("宋体", Font.PLAIN, 22));
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		/*
		 * 登录按钮事件响应
		 * 
		 */
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					login_bu(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E\u8F93\u5165");
	
		
		/*
		 * 
		 * 重置按钮响应事件
		 * 
		 */
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resettingtext(e);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
							.addGap(223))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 441, Short.MAX_VALUE)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(182)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE))
							.addGap(136))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(59)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addGap(82)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addGap(90)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(80, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
	}
	
	protected void login_bu(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub

		username=this.textField.getText();
		String password=new String(this.passwordField.getPassword());
		if(StringUntil.isEmpty(username)){
			JOptionPane.showMessageDialog(null, "账号不能为空！");
			return;
		}
		if(StringUntil.isEmpty(password)){
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
		int  number  = Integer.valueOf(username);
		Connection con=null;
		if(number<10)
		{
			try
			{			 
			 admin adminp=new admin(username,password);
			 con =conmysqls.getCon();
			 admin ads= admindao.login(con, adminp);
				if(ads!=null){
					JOptionPane.showMessageDialog(null, "登录成功！");	
					dispose();
					new MainFrm().setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "账号或者密码错误！");
					
				}
				
			}catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					try {
						conmysqls.closeCon(con);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

		else
		{
			
			try
			{	
			 student sts=new student(username,password);
			 con =conmysqls.getCon();
			 student ads= new student();
			 studentdao studao=new studentdao();
			 ads=studao.login(con, sts);
			// System.out.print(ads);
				if(ads!=null){
					JOptionPane.showMessageDialog(null, "登录成功！");	
					dispose();
					Main_Student_book ss=new Main_Student_book();
					
					ss.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "账号或者密码错误！");
				 	
				}
				
			}catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					try {
						conmysqls.closeCon(con);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}

	/*
 * 
 * 重置输入函数
 * 
 */
	protected void resettingtext(ActionEvent e) {
		// TODO Auto-generated method stub
		this.textField.setText("");
		this.passwordField.setText("");
			
	}
}

