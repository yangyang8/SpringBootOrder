package com.hailong.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.hailong.dao.BaseDao;
import com.hailong.domain.OrderBook;
import com.hailong.utils.DateUtils;

public class BaseDaoImpl implements BaseDao<OrderBook> {
	//private static DateUtils dateUtils=new DateUtils();
	
	protected static Map<String,OrderBook> userMaps=null;
	static{
		userMaps=new HashMap<String,OrderBook>();
		String bookId=UUID.randomUUID().toString();
		userMaps.put(bookId,new OrderBook(bookId,"软件工程","杨海龙","李代平","清华大学出版社","../img/ean1.png",5,65.9,"1","1"));
		bookId=UUID.randomUUID().toString();
		userMaps.put(bookId,new OrderBook(bookId,"Spring boot实战","杨海龙","汪云","电子工业出版社","../img/ean2.png",5,46.9,"0","0"));
		bookId=UUID.randomUUID().toString();
		userMaps.put(bookId,new OrderBook(bookId,"Vue.js实战","杨海龙","说说","清华大学出版社","../img/ean3.png",3,53.9,"1","1"));
		bookId=UUID.randomUUID().toString();
		userMaps.put(bookId,new OrderBook(bookId,"Spark机器学习","杨海龙","Nick Pentreath","清华大学出版社","../img/ean4.png",20,66.9,"0","0"));
		bookId=UUID.randomUUID().toString();
		userMaps.put(bookId,new OrderBook(bookId,"Netty权威指南","杨海龙","李林锋","电子工业出版社","../img/ean5.png",8,73.9,"0","0"));
		bookId=UUID.randomUUID().toString();
		userMaps.put(bookId,new OrderBook(bookId,"Hadoop权威指南","余永康","李天锋","电子工业出版社","../img/ean5.png",73.9,6,DateUtils.formStringToDate("2018-4-16"),"1","1"));
		
		bookId=UUID.randomUUID().toString();
		userMaps.put(bookId,new OrderBook(bookId,"Hbase权威指南","admin","李工锋","电子工业出版社","../img/ean5.png",73.9,2,DateUtils.formStringToDate("2018-4-16"),"1","1"));
		
		bookId=UUID.randomUUID().toString();
		userMaps.put(bookId,new OrderBook(bookId,"Hive权威指南","余永康","李大锋","电子工业出版社","../img/ean5.png",73.9,7,DateUtils.formStringToDate("2018-4-16"),"1","1"));
		
		bookId=UUID.randomUUID().toString();
		userMaps.put(bookId,new OrderBook(bookId,"kafka权威指南","罗家林","李小锋","电子工业出版社","../img/ean5.png",73.9,8,DateUtils.formStringToDate("2018-4-16"),"1","1"));
		
		bookId=UUID.randomUUID().toString();
		userMaps.put(bookId,new OrderBook(bookId,"tomcat权威指南","吴国聪","李小林","电子工业出版社","../img/ean5.png",73.9,8,DateUtils.formStringToDate("2018-4-16"),"1","1"));
		
		
	}

	public List<OrderBook> findAll() {
		//根据支付状态来查询数据
		return new ArrayList<OrderBook>(this.userMaps.values());
	}


	@Override
	public OrderBook findOne(OrderBook entity) {
		if(entity!=null){
			String bookId=entity.getBookId();
			if(bookId!=null&&bookId.equals("")){
				//进行进行查询这个图书
				OrderBook ob=this.userMaps.get(bookId);
				if(ob!=null){
					return ob;
				}
				return null;
			}
		}
		return null;
	}
	
	
	//更新订单状态情况
	public void updateStatus(String bookId,String status){
		if(bookId!=null&&!bookId.equals("")&&status!=null&&!status.equals("")){
			OrderBook ob=this.userMaps.get(bookId);
			if(ob!=null){
				this.userMaps.remove(bookId);
				ob.setStatus(status);
				//插入数据
				this.userMaps.put(bookId,ob);
			}
			
		}
	}


}
