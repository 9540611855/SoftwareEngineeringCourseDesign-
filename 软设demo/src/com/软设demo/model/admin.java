package com.软设demo.model;
/*
 * 
 * 管理员类
 * 
 * */
/*
 * 
 * 
 * 
 * CREATE TABLE `Admin` (
  `ma_id` VARCHAR(100) NOT NULL,
  `ma_name` VARCHAR(20) NOT NULL,
  `ma_pwd`  VARCHAR(20) NOT NULL,
  `telnmuber` VARCHAR(40) NOT NULL,
  `sex` varchar(2),
  PRIMARY KEY (`ma_id`)
	)CHARSET=utf8;
INSERT INTO `Admin` VALUES ('1', '小康康', '123456', '123456', '男'), ('2', '小可可', '234567', '88888', '女');

 */
public class admin
{
	public admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String ma_id;
	private String ma_name;
	private String ma_sex;
	private String telnmuber;
	private String ma_pwd;
	public String getMa_id() {
		return ma_id;
	}
	public void setMa_id(String ma_id) {
		this.ma_id = ma_id;
	}
	public String getMa_name() {
		return ma_name;
	}
	
	
	public admin(String ma_id, String ma_name, String ma_sex, String telnmuber, String ma_pwd) {
		super();
		this.ma_id = ma_id;
		this.ma_name = ma_name;
		this.ma_sex = ma_sex;
		this.telnmuber = telnmuber;
		this.ma_pwd = ma_pwd;
	}
	public admin(String ma_id, String ma_pwd) {
		super();
		this.ma_id = ma_id;
		this.ma_pwd = ma_pwd;
	}
	public String getMa_sex() {
		return ma_sex;
	}
	public void setMa_sex(String ma_sex) {
		this.ma_sex = ma_sex;
	}
	public String getMa_pwd() {
		return ma_pwd;
	}
	public void setMa_pwd(String ma_pwd) {
		this.ma_pwd = ma_pwd;
	}
	public void setMa_name(String ma_name) {
		this.ma_name = ma_name;
	}


	public String getTelnmuber() {
		return telnmuber;
	}
	public void setTelnmuber(String telnmuber) {
		this.telnmuber = telnmuber;
	}
	
	
}