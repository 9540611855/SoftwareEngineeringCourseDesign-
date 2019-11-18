package com.软设demo.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.软设demo.conncet.conmysql;
import com.软设demo.conncet.studentdao;
import com.软设demo.util.StringUntil;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class StudentFrm extends JInternalFrame {
	private JTextField textField;
	private conmysql consql=new conmysql();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentFrm frame = new StudentFrm();
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
	public StudentFrm() {
		setFrameIcon(new ImageIcon("D:\\java\\\u8F6F\u8BBEdemo\\images\\timg.png"));
		setTitle("[\u7BA1\u7406\u5458] \u5B66\u751F\u4FE1\u606F\u7BA1\u7406");
		setResizable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 571, 533);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u53F7");
		
		textField = new JTextField();
		textField.setColumns(10);
		/*
		 * 查询学生信息
		 * 
		 */
		JButton btnNewButton = new JButton("\u67E5\u8BE2\u4FE1\u606F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String stu_id=textField.getText();
				if(StringUntil.isEmpty(stu_id))
				{
					JOptionPane.showMessageDialog(null, "学生学号不能因为空");
					return;
				}

				sele_studentFrm sele=new sele_studentFrm();
				sele.AddData(stu_id);
				sele.setVisible(true);
				getContentPane().add(sele);
			}
		}
			 	
);
		/*
		 * 查询所有学生信息 按钮事件
		 */
		JButton btnNewButton_1 = new JButton("\u6240\u6709\u4FE1\u606F");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sele_studentFrm stu=new sele_studentFrm();
				stu.AllData();
				stu.setVisible(true);
				getContentPane().add(stu);
				
			}
		});
		/*
		 * 信息增加按钮
		 */
		JButton btnNewButton_2 = new JButton("\u589E\u52A0\u4FE1\u606F");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudentFrm add=new AddStudentFrm();
				add.setVisible(true);
				getContentPane().add(add);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton_1)
							.addPreferredGap(ComponentPlacement.RELATED, 297, Short.MAX_VALUE)
							.addComponent(btnNewButton_2))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(39)
							.addComponent(lblNewLabel)
							.addGap(61)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
							.addComponent(btnNewButton)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.RELATED, 327, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addGap(34))
		);
		getContentPane().setLayout(groupLayout);

	}
}
