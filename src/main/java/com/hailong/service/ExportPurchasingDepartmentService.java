package com.hailong.service;

import java.util.List;

import com.hailong.domain.PurchaseOrder;

public interface ExportPurchasingDepartmentService {
	
	//增加采购清单的数据
	public void addPurchaseOrder(String bookIds[]);
	
	//查询所有的订单的数据
	public List<PurchaseOrder> getAllPageList();
	
	//查询一个订单的数据
	public PurchaseOrder findOne(String id);

	public void updatePurStatusById(String[] ids);

	public List<PurchaseOrder> findPurchasedRecord();
	
	//增加图书订单
/*	public void addPurchaseOrder(PurchaseOrder p);*/

}
