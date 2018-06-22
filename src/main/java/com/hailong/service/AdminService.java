package com.hailong.service;

import java.util.List;

import com.hailong.domain.OrderBook;



public interface AdminService {
	
	public List<OrderBook> getAllOrderTask();

	public OrderBook updateAdminOpton(OrderBook ob);
	
	public List<OrderBook> getAllOrderTaskPassed();
}
