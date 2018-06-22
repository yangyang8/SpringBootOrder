package com.hailong.dao.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hailong.dao.PurDepartmentDao;
import com.hailong.domain.OrderBook;
import com.hailong.domain.PurchaseOrder;

@Repository
public class PurDepartmentDaoImpl implements PurDepartmentDao {

	protected static Map<String,PurchaseOrder> purMap=new HashMap<String,PurchaseOrder>();
	
	@Override
	public void addPurchaseOrder(OrderBook ob) {
		if(ob!=null){
			PurchaseOrder purchase=new PurchaseOrder();
			purchase.setId(UUID.randomUUID().toString());
			purchase.setBookName(ob.getBookName());
			purchase.setUserName(ob.getUserName());
			purchase.setNumber(ob.getNumber());
			purchase.setPrice(ob.getPrice());
			purchase.setTotalPrice(ob.getTotalNumber());
			purchase.setOrderTime(ob.getOrderTime());
			purchase.setBarcode(ob.getBarcode());
			purMap.put(purchase.getId(),purchase);
		}
	}

	@Override
	public List<PurchaseOrder> findAll() {
		List<PurchaseOrder> list=new ArrayList<PurchaseOrder>(purMap.values());
		
		List<PurchaseOrder> tarList=new ArrayList<PurchaseOrder>();
		for(PurchaseOrder po:list){
			String status=po.getPurStatus();
			if(status!=null&&status.equals("0")){
				tarList.add(po);
			}
		}
		return new ArrayList<PurchaseOrder>(tarList);
	}

	@Override
	public PurchaseOrder findOne(PurchaseOrder entity) {
		return null;
	}
	
	public PurchaseOrder findOne(String id){
		if(id!=null&&!"".equals(id)){
			return this.purMap.get(id);
		}
		return null;
	}

	@Override
	public void deletePurchaseOrderById(String id) {
		if(id!=null){
			this.purMap.remove(id);//17102252-8e52-44ab-b6c2-c646c8bf179a
		}
		
	}

	@Override
	public void addPurchaseOrder(PurchaseOrder po) {
		if(po!=null&&po.getId()!=null&&!"".equals(po.getId())){
			 this.purMap.put(po.getId(),po);
		}

	}

	@Override
	public List<PurchaseOrder> findAllPured(String purCh) {
		List<PurchaseOrder> purList=new ArrayList<PurchaseOrder>(purMap.values());
		List<PurchaseOrder> tarList=new ArrayList<PurchaseOrder>();
		if(purCh!=null&&!"".equals(purCh)){
			if(purList!=null&&purList.size()>0){
				for(PurchaseOrder p:purList){
					String purStatus=p.getPurStatus();
					if(purStatus!=null&&"1".equals(purStatus)){
						tarList.add(p);
					}
				}
			}
		}
		return tarList;
	}

	@Override
	public void updateStatus(String bookId, String status) {
		
	}
	
}
