package com.hailong.dao.impl;

import org.springframework.stereotype.Repository;

import com.hailong.dao.OrderBookDao;
import com.hailong.domain.OrderBook;

@Repository
public class OrderBookDaoImpl extends BaseDaoImpl implements OrderBookDao<OrderBook>{

	
	public OrderBook findOne(String bookId){
		if(bookId!=null&&!bookId.equals("")){
			//进行查询
			return this.userMaps.get(bookId);
		}else{
			return null;
		}
	}


	//增加图书订单
	@Override
	public OrderBook addOrderBook(OrderBook ob) {
		return this.userMaps.put(ob.getBookId(),ob);
	}

	
	//删除图书订单数据
	@Override
	public OrderBook deleteOrderBook(String bookId) {
		if(bookId!=null){
			return this.userMaps.remove(bookId);//17102252-8e52-44ab-b6c2-c646c8bf179a
		}else{
			return null;
		}
		
	}
	


	
	//先删除原来的数据，再删除这次的数据
	@Override
	public OrderBook updateOrderBook(OrderBook ob) {
		deleteOrderBook(ob.getBookId());
		this.userMaps.put(ob.getBookId(),ob);
		return ob;
	}


}
