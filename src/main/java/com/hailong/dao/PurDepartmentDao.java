package com.hailong.dao;


import java.util.List;

import com.hailong.domain.OrderBook;
import com.hailong.domain.PurchaseOrder;

public interface PurDepartmentDao extends BaseDao<PurchaseOrder> {
	
	//查询所有adminOpinion为""的数据
	/*public List<PurchaseOrder> getAllFinancialDepartmentIsNull();
	
	//修改adminOpinion状态的数据
	public PurchaseOrder updateFinancialDepartment(PurchaseOrder ob);

	public List<PurchaseOrder> getAllFinancialDepartmentIsNotNull();

	public PurchaseOrder findOne(String bookId);
	
	public PurchaseOrder deleteOrderBook(String bookId);

	public List<PurchaseOrder> findAllByStatus(String string);*/
	
	//增加数据
	public void addPurchaseOrder(OrderBook ob);
	
	public PurchaseOrder findOne(String id);
	
	public void deletePurchaseOrderById(String id);
	
	public void addPurchaseOrder(PurchaseOrder po);

	public List<PurchaseOrder> findAllPured(String string);

}
