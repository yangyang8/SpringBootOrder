package com.hailong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hailong.dao.FinanceDepartmentDao;
import com.hailong.dao.PurDepartmentDao;
import com.hailong.domain.OrderBook;
import com.hailong.domain.PurchaseOrder;
import com.hailong.service.ExportPurchasingDepartmentService;

@Service
public class ExportPurchasingDepartmentServiceImpl implements ExportPurchasingDepartmentService{
	
	@Autowired
	private PurDepartmentDao purDepartmentDao;
	
	@Autowired
	private FinanceDepartmentDao finanaceDao;

	public void addPurchaseOrder(String bookIds[]) {
		
		if(bookIds!=null&&bookIds.length>0){
			for(String bookId:bookIds){
				OrderBook ob=finanaceDao.findOne(bookId);
				ob.setStatus("4");//表示数据到PurDepartment
				finanaceDao.updateFinancialDepartment(ob);
				if(ob!=null){
					//进行增加
					purDepartmentDao.addPurchaseOrder(ob);
				}
			}
			
		}
	}

	public List<PurchaseOrder> getAllPageList() {
		List<PurchaseOrder> list=purDepartmentDao.findAll();
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}

	public PurchaseOrder findOne(String id) {
		PurchaseOrder p=purDepartmentDao.findOne(id);
		if(p!=null){
			return p;
		}
		return null;
	}

	@Override
	public void updatePurStatusById(String[] ids) {
		for(String id:ids){
			PurchaseOrder p=findOne(id);
			purDepartmentDao.deletePurchaseOrderById(id);
			if(p!=null){
				p.setPurStatus("1");//已完成购卖
				purDepartmentDao.addPurchaseOrder(p);
			}
		}
	}

	@Override
	public List<PurchaseOrder> findPurchasedRecord() {
		List<PurchaseOrder> list=purDepartmentDao.findAllPured("1");
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}

}
