package com.����demo.model;

/*
 *  
 * ͼ����
 * 
 * �鼮����ţ�ISBN�����鼮��ţ�book_id��,
 * ����(title),����(type),����(author) 
 *,������(press),����ʱ��(press_time)
 *,�۸�(price)���洢��(count)
 * 
 * CREATE TABLE `book` (
  `ISBN` VARCHAR(100) NOT NULL,
  `book_id` VARCHAR(20) NOT NULL,
  `title`  VARCHAR(20) NOT NULL,
  `type` VARCHAR(100) NOT NULL,
  `author` varchar(100) NOT NULL,
  `press`  varchar(100) NOT NULL,
  `press_time` varchar(100) NOT NULL,
  `price` varchar(100) NOT NULL,
  `count` varchar(100) NOT NULL,
  PRIMARY KEY (`book_id`)
    )CHARSET=utf8;
    
INSERT INTO `book` VALUES ('123', '0', '���򹤳̺���ԭ��', '��Ϣ��ȫ������', '���Զ','�����ʵ������','2014-5','109','5');

    
   
 * 
 * */

public class book
{
	private String ISBN;
	private String book_id;
	private String title;
	private String type;
	public void setType(String type) {
		this.type = type;
	}
	private String author;
	private String press;
	private String press_time;
	private String price;
	private String count;
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}

	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getPress_time() {
		return press_time;
	}
	public void setPress_time(String press_time) {
		this.press_time = press_time;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}

}