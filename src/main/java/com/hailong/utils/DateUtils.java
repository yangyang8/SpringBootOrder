package com.hailong.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * @author Administrator
 *
 */
public class DateUtils {
	
	public static String fromDateToString(Date date){
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
		return format.format(date);
	}
	
	//字符串转整形
	public static Integer formStringToInteger(String date){
		return Integer.parseInt(date);
	}
	
	//日期转整形
	public static Integer formDateToInteger(Date date){
		String d=fromDateToString(date);
		return formStringToInteger(d);
	}
	
	//字符串围成Date
	public static Date formStringToDate(String date){
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		try {
			return format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
