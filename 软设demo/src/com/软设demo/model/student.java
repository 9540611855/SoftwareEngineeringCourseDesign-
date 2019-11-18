package com.软设demo.model;
/*
 * 
 * 学生类
 *
 * CREATE TABLE `student` (
  `stu_id` VARCHAR(100) NOT NULL,
  `stu_pwd` VARCHAR(20) NOT NULL,
  `stu_name` VARCHAR(20) NOT NULL,
  `stu_sex`  VARCHAR(20) NOT NULL,
  `faculites` VARCHAR(40) NOT NULL,
  `limit` varchar(10) NOT NULL,
  `stu_number` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`stu_id`)
	)CHARSET=utf8;
	INSERT INTO `student` VALUES ('1', '123456','小灰灰', '男', '计算机', '10','987654'), ('2', '123456','小红红', '女','软件学院', '8', '1234567');
 * 
 * */
public class student 
{
	public student(String stu_id, String stu_pwd) {
		super();
		this.stu_id = stu_id;
		this.stu_pwd = stu_pwd;
	}
	private String stu_id;		//学号
	private String stu_pwd;     //
	private String stu_name;	//名字
	private String stu_sex;	// 0为男生 1为女生 
	private String faculites;	//系别
	public String getStu_pwd() {
		return stu_pwd;
	}
	public void setStu_pwd(String stu_pwd) {
		this.stu_pwd = stu_pwd;
	}
	public student(String stu_id, String stu_pwd, String stu_name, String stu_sex, String faculites, String limit,
			String stu_number) {
		super();
		this.stu_id = stu_id;
		this.stu_pwd = stu_pwd;
		this.stu_name = stu_name;
		this.stu_sex = stu_sex;
		this.faculites = faculites;
		this.limit = limit;
		this.stu_number = stu_number;
	}
	private String limit;			//0-n  数字越高 权限越高
	private String stu_number;		//借书书籍数目
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getStu_sex() {
		return stu_sex;
	}
	public void setStu_sex(String stu_sex) {
		this.stu_sex = stu_sex;
	}
	public student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public student(String stu_id, String stu_name, String stu_sex, String faculites, String limit, String stu_number) {
		super();
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.stu_sex = stu_sex;
		this.faculites = faculites;
		this.limit = limit;
		this.stu_number = stu_number;
	}
	public String getFaculites() {
		return faculites;
	}
	public void setFaculites(String faculites) {
		this.faculites = faculites;
	}
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
	public String getStu_number() {
		return stu_number;
	}
	public void setStu_number(String stu_number) {
		this.stu_number = stu_number;
	}
	
	
	
}