package com.hailong.service;

import java.util.List;

import com.hailong.domain.OrderBook;
import com.hailong.po.PayMoneyImage;



public interface ReportFinanceDepartmentService {
	
	public List<OrderBook> getAllOrderTask();

	public OrderBook updateFinancialDepartment(OrderBook ob);
	
	public List<OrderBook> getAllOrderTaskPassed();
	
	public List<OrderBook> findByIds(String bookIds[]);

	public void updateByIds(String[] bookIds);

	public List<OrderBook> findByStatus();

	public PayMoneyImage getTotalMoney(String[] bookIds);

}
