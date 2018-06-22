package com.hailong.dao.impl;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hailong.dao.AdminDao;
import com.hailong.dao.FinanceDepartmentDao;
import com.hailong.domain.OrderBook;
import com.hailong.utils.DateUtils;

@Repository
public class FinanceDepartmentImpl extends BaseDaoImpl implements FinanceDepartmentDao {



	public List<OrderBook> getAllFinancialDepartmentIsNull() {
		Collection<OrderBook> or=userMaps.values();
		List<OrderBook> list=new ArrayList<OrderBook>(or);
		List<OrderBook> financeList=new ArrayList<OrderBook>();
		for(OrderBook ob:list){
			String stauts=ob.getStatus();
			//1表示已经支付的订单
			//0表示没有支付的订单
			//TODO 加上这个进行操作payStauts!=null&&"0".equals(payStauts)
			if(!stauts.equals("3")){
				continue;
			}
			financeList.add(ob);
		}
		return financeList;
	}
	
	//删除图书订单数据
	public OrderBook deleteOrderBook(String bookId) {
		if(bookId!=null){
			return this.userMaps.remove(bookId);//17102252-8e52-44ab-b6c2-c646c8bf179a
		}else{
			return null;
		}
		
	}

	public OrderBook updateFinancialDepartment(OrderBook ob) {
		String bookId=ob.getBookId();
		deleteOrderBook(bookId);
		this.userMaps.put(bookId,ob);
		return ob;
	}

	//进行汇总已经给了钱了订单数据
	//不等于3则不能显示这条数据了
	public List<OrderBook> getAllFinancialDepartmentIsNotNull() {
		
		Collection<OrderBook> or=userMaps.values();
		List<OrderBook> list=new ArrayList<OrderBook>(or);
		List<OrderBook> financeList=new ArrayList<OrderBook>();
		for(OrderBook ob:list){
			String financialDepartment=ob.getFinancialDepartment();
			//String parStatu=ob.getPayStatus();
			String status=ob.getStatus();
			
			//System.out.println(b);
			if(financialDepartment ==null||!"通过".equals(financialDepartment)||(status!=null&&!status.equals("3"))){ //currentDate>(srcDate+7) 表示不在一周之内
				continue;
			}
			financeList.add(ob);
		}
		return financeList;
	}

	@Override
	public OrderBook findOne(String bookId) {

		if(bookId!=null&&!bookId.equals("")){
			//进行查询
			return this.userMaps.get(bookId);
		}else{
			return null;
		}

	}

	@Override
	public List<OrderBook> findAllByStatus(String status) {
		Collection<OrderBook> or=userMaps.values();
		List<OrderBook> list=new ArrayList<OrderBook>(or);
		List<OrderBook> financeList=new ArrayList<OrderBook>();
		for(OrderBook ob:list){
			String stauts=ob.getStatus();
			
			//找到所有的没有被审核的数据
			String financialDepartment=ob.getFinancialDepartment();
			/*if(financialDepartment!=null&&!financialDepartment.equals("")){
				//过滤掉这个数据
			}*/
			//1表示已经支付的订单
			//0表示没有支付的订单
			//TODO 加上这个进行操作payStauts!=null&&"0".equals(payStauts)
			if(!stauts.equals(status)||(financialDepartment!=null&&!financialDepartment.equals(""))){
				continue;
			}
			financeList.add(ob);
		}
		return financeList;
	}

}
