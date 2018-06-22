package com.hailong.dao;

import java.util.List;

import com.hailong.domain.OrderBook;

public interface FinanceDepartmentDao extends BaseDao<OrderBook> {
	
	//查询所有adminOpinion为""的数据
	public List<OrderBook> getAllFinancialDepartmentIsNull();
	
	//修改adminOpinion状态的数据
	public OrderBook updateFinancialDepartment(OrderBook ob);

	public List<OrderBook> getAllFinancialDepartmentIsNotNull();

	public OrderBook findOne(String bookId);
	
	public OrderBook deleteOrderBook(String bookId);

	public List<OrderBook> findAllByStatus(String string);

}
