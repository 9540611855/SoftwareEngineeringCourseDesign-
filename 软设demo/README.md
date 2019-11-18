# SoftwareEngineeringCourseDesign-
3天用java 实现的图书管理系统   写的非常粗糙
可能会更新这个课设。。
大牛请绕道， 小白作品
Server version 5.7.26 MySQL Community Server (GPL)

mysql show tables;
+-----------------------+
 Tables_in_bookmanager 
+-----------------------+
 admin                 
 book                  
 student               
+-----------------------+
3 rows in set (0.00 sec)

mysql desc  admin
    - ;
+-----------+--------------+------+-----+---------+-------+
 Field      Type          Null  Key  Default  Extra 
+-----------+--------------+------+-----+---------+-------+
 ma_id      varchar(100)  NO    PRI  NULL           
 ma_name    varchar(20)   NO         NULL           
 ma_pwd     varchar(20)   NO         NULL           
 telnmuber  varchar(40)   NO         NULL           
 sex        varchar(2)    YES        NULL           
+-----------+--------------+------+-----+---------+-------+
5 rows in set (0.13 sec)

mysql desc  book;
+------------+--------------+------+-----+---------+-------+
 Field       Type          Null  Key  Default  Extra 
+------------+--------------+------+-----+---------+-------+
 ISBN        varchar(100)  NO         NULL           
 book_id     varchar(20)   NO    PRI  NULL           
 title       varchar(20)   NO         NULL           
 type        varchar(100)  NO         NULL           
 author      varchar(100)  NO         NULL           
 press       varchar(100)  NO         NULL           
 press_time  varchar(100)  NO         NULL           
 price       varchar(100)  NO         NULL           
 count       varchar(100)  NO         NULL           
+------------+--------------+------+-----+---------+-------+
9 rows in set (0.14 sec)

mysql desc  student;
+------------+--------------+------+-----+---------+-------+
 Field       Type          Null  Key  Default  Extra 
+------------+--------------+------+-----+---------+-------+
 stu_id      varchar(100)  NO    PRI  NULL           
 stu_pwd     varchar(20)   NO         NULL           
 stu_name    varchar(20)   NO         NULL           
 stu_sex     varchar(20)   NO         NULL           
 faculites   varchar(40)   NO         NULL           
 limit       varchar(10)   NO         NULL           
 stu_number  varchar(40)   NO         NULL           
+------------+--------------+------+-----+---------+-------+
7 rows in set (0.15 sec

java version 1.8.0_201
