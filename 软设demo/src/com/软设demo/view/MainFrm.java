package com.软设demo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table =null;
	private GroupLayout gl_contentPane=null;
	/**
	 * Launch the application.
	 */ 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\java\\\u8F6F\u8BBEdemo\\images\\timg.png"));
		setTitle("\u7BA1\u7406\u5458\u72B6\u6001");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		/*
		 * 
		 * 管理员图书管理系统
		 *  
		 */
		JButton btnNewButton = new JButton("\u56FE\u4E66\u4FE1\u606F\u7BA1\u7406");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bookFrm bookFtms=new bookFrm();
				bookFtms.setVisible(true);
				getContentPane().add(bookFtms);
				//System.out.println("111");
				
			}
		});
		table = new JDesktopPane();
		contentPane.add(table, BorderLayout.CENTER);
		/*
		 * 管理员信息修改按钮
		 * 
		 */
		JButton btnNewButton_1 = new JButton("\u7BA1\u7406\u5458\u4FE1\u606F\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminFrm ad=new AdminFrm();
				ad.setVisible(true);
				ad.SetText();
				getContentPane().add(ad);
			}
		});
		/*
		 * 管理员按钮响应事件
		 * 
		 */
		JButton btnNewButton_2 = new JButton("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 StudentFrm std=new StudentFrm();
			 std.setVisible(true);
			 getContentPane().add(std);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(table, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(54)
							.addComponent(btnNewButton_1)
							.addGap(33)
							.addComponent(btnNewButton_2)))
					.addGap(88))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addGap(355))
		);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
	}
}
