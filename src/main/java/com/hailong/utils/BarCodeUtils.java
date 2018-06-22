package com.hailong.utils;

import java.io.File;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

/**
 * 生成条形码和二维码的相关的工具
 * @author Administrator
 *
 */
public class BarCodeUtils {
	
	/**
	 * 根据图书的名字生成条形码
	 * @param name 图书名字
	 * @return 返回生成的图片的路径
	 */
	public static String makeBarCode(String name){
		try{
			 String path=BarCodeUtils.class.getClassLoader().getResource(".").getPath(); 
	         int width = 205;  
	         int height = 80;  
	        // 条形码的输入是13位的数字  
	        String text = "6923450657713";  
	        // 二维码的输入是字符串  
	        //String text = "testtesttest生成条形码图片";  
	        String format = "png";  
	        HashMap<EncodeHintType, String> hints = new HashMap<>();  
	        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");  
	        // 条形码的格式是 BarcodeFormat.EAN_13  
	        // 二维码的格式是BarcodeFormat.QR_CODE  
	        //BarcodeFormat.ITF;
	        BitMatrix bm = new MultiFormatWriter().encode(text,  
	        		 BarcodeFormat.EAN_13, width, height, hints);  
	  
	        //File out = new File("new.png");  
	         //生成条形码图片  
	         File out = new File(path+"/static/img/ean_"+name+".png");  
	  
	        WriteBitMatricToFile.writeBitMatricToFile(bm, format, out); 
	        return "../img/ean_"+name+".png";
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return null;
	
		
	}
	
	/**
	 * 根据路径来生成二编码
	 * @param name 用户名
	 * @return 返回生成的二维码的生成路径
	 */
	public static String makeQRCode(String name){
		String path=BarCodeUtils.class.getClassLoader().getResource(".").getPath();
		//System.out.println(path);
		try{
			int width = 300;  
	        int height = 300;  
	        // 条形码的输入是13位的数字  
	        //String text = "6923450657713";  
	        // 二维码的输入是字符串  
	        //String text = "testtesttest生成条形码图片";  
	        String format = "png";  
	        HashMap<EncodeHintType, String> hints = new HashMap<>();  
	        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");  
	        // 条形码的格式是 BarcodeFormat.EAN_13  
	        // 二维码的格式是BarcodeFormat.QR_CODE  
	        BitMatrix bm = new MultiFormatWriter().encode(name,  
	        		 BarcodeFormat.QR_CODE, width, height, hints);  
	        
	        
	        File out = new File(path+"/static/img/qr_"+name+".png");  
	         //生成条形码图片  
	         //File out = new File("qr_"+name+".png");  
	  
	        WriteBitMatricToFile.writeBitMatricToFile(bm, format, out); 
	        return "img/qr_"+name+".png";
		}catch(Exception e){
			
		}
		return null;
	}

}
