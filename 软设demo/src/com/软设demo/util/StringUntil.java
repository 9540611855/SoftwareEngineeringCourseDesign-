package com.软设demo.util;
/*
 *  字符串工具类
 *
*/

public class StringUntil {
 /*
  * 判断字符串是否为空
  * 
  * 
  * */
	public static boolean isEmpty(String str)
	{
		if(str==null ||"".equals(str.trim()))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
}
