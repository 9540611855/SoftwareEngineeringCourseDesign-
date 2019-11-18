package com.软设demo.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.软设demo.conncet.conmysql;
import com.软设demo.conncet.studentdao;
import com.软设demo.model.student;
import com.软设demo.util.StringUntil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class sele_studentFrm extends JInternalFrame {
	private JTable table;
	private JTextField stu_ids;
	private JTextField stu_names;
	private JTextField stu_sexs;
	private JTextField faculitess;
	private JTextField limits;
	private JTextField stu_numbers;
	private conmysql consql=new conmysql();
	private JTextField stu_pwds;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sele_studentFrm frame = new sele_studentFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * 查询到的信息
	 * 
	 * */
	public void AddData(String id)
	{
		DefaultTableModel dtm=(DefaultTableModel) table.getModel();
		dtm.setRowCount(0); // 设置成0行
		Connection con=null;
		studentdao sds=new studentdao();
		try
		{
		   
		   con=consql.getCon();
		   ResultSet rs=sds.show(con,id);
		   while(rs.next())
		   {
			   Vector v=new Vector();
			   v.add(rs.getString("stu_id"));
			   v.add(rs.getString("stu_pwd"));
			   v.add(rs.getString("stu_name"));
			   v.add(rs.getString("stu_sex"));
			   v.add(rs.getString("faculites"));
			   v.add(rs.getString("limit"));
			   v.add(rs.getString("stu_number"));
			   dtm.addRow(v);   
		   }
		}
		catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "学生信息查询失败");
		}finally{
			
			try {
				consql.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
		
}
	
	/*
	 * 显示所有的学生信息
	 * 
	 */
	public void AllData()
	{
		DefaultTableModel dtm=(DefaultTableModel) table.getModel();
		dtm.setRowCount(0); // 设置成0行
		Connection con=null;
		studentdao sds=new studentdao();
		try
		{
		   
		   con=consql.getCon();
		   ResultSet rs=sds.showall(con);
		   while(rs.next())
		   {
			   Vector v=new Vector();
			   v.add(rs.getString("stu_id"));
			   v.add(rs.getString("stu_pwd"));
			   v.add(rs.getString("stu_name"));
			   v.add(rs.getString("stu_sex"));
			   v.add(rs.getString("faculites"));
			   v.add(rs.getString("limit"));
			   v.add(rs.getString("stu_number"));
			   dtm.addRow(v);   
		   }
		}
		catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "学生信息查询失败");
		}finally{
			
			try {
				consql.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
	}
	/**
	 * Create the frame.
	 */
	public sele_studentFrm() {
		setTitle("\u5B66\u751F\u67E5\u8BE2\u7ED3\u679C");
		setFrameIcon(new ImageIcon("D:\\java\\\u8F6F\u8BBEdemo\\images\\timg.png"));
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 759, 605);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u5B66\u53F7");
		
		stu_ids = new JTextField();
		stu_ids.setEditable(false);
		stu_ids.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u751F\u59D3\u540D");
		
		stu_names = new JTextField();
		stu_names.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5B66\u751F\u6027\u522B");
		
		stu_sexs = new JTextField();
		stu_sexs.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u5B66\u751F\u9662\u7CFB");
		
		faculitess = new JTextField();
		faculitess.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u501F\u4E66\u6743\u9650");
		
		limits = new JTextField();
		limits.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u8054\u7CFB\u53F7\u7801");
		
		stu_numbers = new JTextField();
		stu_numbers.setColumns(10);
		/*
		 * 学生信息修改 按钮 事件
		 */
		JButton btnNewButton = new JButton("\u4FE1\u606F\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				String ids=stu_ids.getText();
				String names=stu_names.getText();
				String sexs=stu_sexs.getText();
				String faculitesss=faculitess.getText();
				String  limitss=limits.getText();
				String numbers=stu_numbers.getText();
				String stu_pwd=stu_pwds.getText();
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
				student ssd=new student(ids,stu_pwd,names,sexs,faculitesss,limitss,numbers);
				
				Connection con=null;
				studentdao sds=new studentdao();
				try
				{
					con=consql.getCon();
					int n=sds.update(con, ssd);
					if(n>0)
					{
						JOptionPane.showMessageDialog(null, "学生信息修改成功");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "学生信息修改失败");
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
		});
		/*
		 * 信息删除按钮事件分析
		 * 
		 */
		JButton btnNewButton_1 = new JButton("\u4FE1\u606F\u5220\u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con=null;
				studentdao sds=new studentdao();
				try
				{
					con=consql.getCon();
					String id=stu_ids.getText();
					int n=sds.delete(con, id);
					if(n>0)
					{
						JOptionPane.showMessageDialog(null, "学生信息删除成功");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "学生信息删除失败");
					}
	
				}
				catch(Exception es){
					es.printStackTrace();
					JOptionPane.showMessageDialog(null, "学生信息删除失败");
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
		
		JLabel lblNewLabel_6 = new JLabel("\u5B66\u751F\u5BC6\u7801");
		
		stu_pwds = new JTextField();
		stu_pwds.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(stu_ids, 164, 164, 164))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_1)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(stu_names, 164, 164, 164))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_2)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(stu_sexs, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)))
									.addGap(35)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_3)
										.addComponent(lblNewLabel_4)
										.addComponent(lblNewLabel_5))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(stu_numbers, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
										.addComponent(limits, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
										.addComponent(faculitess, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_6)
									.addGap(32)
									.addComponent(stu_pwds, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(39)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED, 333, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addGap(37))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(stu_ids, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(faculitess, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(stu_names, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(limits, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(stu_sexs, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(stu_numbers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5))
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(stu_pwds, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addContainerGap())
		);
		
		table = new JTable();
		/*
		 * 表格左键相应事件
		 */
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {

				int row=table.getSelectedRow();
				stu_ids.setText((String)table.getValueAt(row, 0));
				stu_pwds.setText((String)table.getValueAt(row, 1));
				stu_names.setText((String)table.getValueAt(row, 2));
				stu_sexs.setText((String)table.getValueAt(row, 3));
				faculitess.setText((String)table.getValueAt(row, 4));
				limits.setText((String)table.getValueAt(row, 5));
				stu_numbers.setText((String)table.getValueAt(row, 6));
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u751F\u5B66\u53F7", "\u5B66\u751F\u5BC6\u7801", "\u5B66\u751F\u59D3\u540D", "\u5B66\u751F\u6027\u522B", "\u5B66\u751F\u9662\u7CFB", "\u501F\u4E66\u6743\u9650", "\u8054\u7CFB\u53F7\u7801"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(93);
		table.getColumnModel().getColumn(2).setPreferredWidth(92);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		table.getColumnModel().getColumn(4).setPreferredWidth(85);
		table.getColumnModel().getColumn(5).setPreferredWidth(85);
		table.getColumnModel().getColumn(6).setPreferredWidth(97);
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);

	}

}
