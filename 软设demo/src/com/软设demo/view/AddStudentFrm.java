package com.软设demo.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.软设demo.conncet.conmysql;
import com.软设demo.conncet.studentdao;
import com.软设demo.model.student;
import com.软设demo.util.StringUntil;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class AddStudentFrm extends JInternalFrame {
	private JTextField stu_ids;
	private JTextField stu_names;
	private JTextField faculitess;
	private JTextField limits;
	private JTextField stu_numbers;
	private conmysql consql=new conmysql();
	private JRadioButton man = new JRadioButton("\u7537");
	private JRadioButton woman = new JRadioButton("\u5973");
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField stu_pwds;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudentFrm frame = new AddStudentFrm();
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
	public AddStudentFrm() {
		setFrameIcon(new ImageIcon("D:\\java\\\u8F6F\u8BBEdemo\\images\\timg.png"));
		setTitle("\u5B66\u751F\u4FE1\u606F\u589E\u52A0");
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		setBounds(100, 100, 483, 516);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u5B66\u53F7");
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u751F\u59D3\u540D");
		
		JLabel lblNewLabel_2 = new JLabel("\u5B66\u751F\u6027\u522B");
		
		JLabel lblNewLabel_3 = new JLabel("\u5B66\u751F\u7CFB\u522B");
		
		JLabel lblNewLabel_4 = new JLabel("\u5B66\u751F\u6743\u9650");
		
		JLabel lblNewLabel_5 = new JLabel("\u8054\u7CFB\u65B9\u5F0F");
		
		stu_ids = new JTextField();
		stu_ids.setColumns(10);
		
		stu_names = new JTextField();
		stu_names.setColumns(10);
		
		faculitess = new JTextField();
		faculitess.setColumns(10);
		
		limits = new JTextField();
		limits.setColumns(10);
		
		stu_numbers = new JTextField();
		stu_numbers.setColumns(10);
		/*
		 * 增加信息按钮
		 */
		JButton btnNewButton = new JButton("\u589E\u52A0\u4FE1\u606F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ids=stu_ids.getText();
				String names=stu_names.getText();
				String sexs;
				if(man.isSelected())
				{
					sexs="男";
				}
				else
				{
					sexs="女";
				}
				String stu_pwd=stu_pwds.getText();
				String faculitesss=faculitess.getText();
				String  limitss=limits.getText();
				String numbers=stu_numbers.getText();
				if(StringUntil.isEmpty(ids)
				||StringUntil.isEmpty(names)
				||StringUntil.isEmpty(sexs)
				||StringUntil.isEmpty(faculitesss)
				||StringUntil.isEmpty(limitss)	
				||StringUntil.isEmpty(numbers)
				||StringUntil.isEmpty(stu_pwd))
				{
					JOptionPane.showMessageDialog(null, "学生信息不能为空！");
					return;
					
				}
				studentdao stds=new studentdao();
				
				
				Connection con=null;
				studentdao sds=new studentdao();
				student ssd=new student(ids,stu_pwd,names,sexs,faculitesss,limitss,numbers);
				try
				{
					con=consql.getCon();
					if(stds.exist_stu_id_(con, ids))
					{
						
						JOptionPane.showMessageDialog(null, "学生学号不能重复！");
						return;
					}
					int n=stds.add(con, ssd);
					if(n>0)
					{
						JOptionPane.showMessageDialog(null, "学生信息增加成功");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "学生信息增加失败");
					}
	
				}
				catch(Exception es){
					es.printStackTrace();
					JOptionPane.showMessageDialog(null, "学生信息修改失败");
				}finally{
					
					try {
						consql.closeCon(con);
					} catch (Exception ess) {
						// TODO Auto-generated catch block
						ess.printStackTrace();
					}
				}
			}
		}
			
			
		);
		
		
		buttonGroup.add(man);
		man.setSelected(true);
		
		buttonGroup.add(woman);
		
		JLabel lblNewLabel_6 = new JLabel("\u5B66\u751F\u5BC6\u7801");
		
		stu_pwds = new JTextField();
		stu_pwds.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_5)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_6))
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(man)
							.addPreferredGap(ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
							.addComponent(woman)
							.addGap(82))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(stu_pwds, Alignment.LEADING)
								.addComponent(limits, Alignment.LEADING)
								.addComponent(faculitess, Alignment.LEADING)
								.addComponent(stu_numbers, Alignment.LEADING)
								.addComponent(stu_names, Alignment.LEADING)
								.addComponent(stu_ids, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton)
							.addContainerGap(18, Short.MAX_VALUE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(stu_ids, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(stu_names, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(stu_pwds, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(man)
						.addComponent(woman))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(faculitess, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(limits, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(stu_numbers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}
