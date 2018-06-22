package com.hailong.dao;

import com.hailong.domain.OrderBook;

public interface OrderBookDao<T> extends BaseDao<T>{
	
	//增加图书订单
	public OrderBook addOrderBook(OrderBook ob);
	
	//根据图书Id来删除图书订单
	
	public OrderBook deleteOrderBook(String bookId);
	
	//根据图书Id来查询图书订单
	public OrderBook findOne(String bookId);

	public OrderBook updateOrderBook(OrderBook ob);
}
