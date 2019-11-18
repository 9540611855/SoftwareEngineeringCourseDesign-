package com.软设demo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.软设demo.util.StringUntil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main_Student_book extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Student_book frame = new Main_Student_book();
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
	public Main_Student_book() {
		setTitle("[\u5B66\u751F] \u56FE\u4E66\u7BA1\u7406");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\java\\\u8F6F\u8BBEdemo\\images\\timg.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u4E66\u7C4D\u7F16\u53F7");
		
		textField = new JTextField();
		textField.setColumns(10);
		/*
		 * 增加书籍按钮事件
		 * 
		 */
		JButton btnNewButton = new JButton("\u4E66\u7C4D\u67E5\u627E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ids=textField.getText();
				if(StringUntil.isEmpty(ids))
				   {
				    JOptionPane.showMessageDialog(null, "图书编号不能为空");
				    return;
				   }
				student_sele_book books=new student_sele_book();
				   books.setVisible(true);
				   books.AddData(ids);
				   getContentPane().add(books);
			}
		});
		/*
		 * 显示所有书籍信息
		 */
		JButton btnNewButton_1 = new JButton("\u6240\u6709\u4E66\u7C4D");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				student_sele_book books=new student_sele_book();
				   books.setVisible(true);
				   books.AllData();
				   getContentPane().add(books);
			}
		});
		
		JButton btnNewButton_2 = new JButton("\u5BC6\u7801\u4FEE\u6539");
		/*
		 * 个人信息修改
		 */
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit_pwd pwd=new edit_pwd();
				pwd.put_std();
				pwd.setVisible(true);
				getContentPane().add(pwd);
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(41)
							.addComponent(lblNewLabel)
							.addGap(35)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(btnNewButton))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton_2)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton_1)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(84)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.RELATED, 369, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
