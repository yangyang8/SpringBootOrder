package com.hailong.dao;

import java.util.List;

import com.hailong.domain.OrderBook;

public interface AdminDao extends BaseDao<OrderBook> {
	
	//查询所有adminOpinion为""的数据
	public List<OrderBook> getAllAdminOptionIsNull();
	
	//修改adminOpinion状态的数据
	public OrderBook updateAdminOpton(OrderBook ob);

	public List<OrderBook> getAllAdminOptionIsNotNull();

	public OrderBook findOne(String bookId);

}
