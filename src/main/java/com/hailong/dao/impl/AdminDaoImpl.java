package com.hailong.dao.impl;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hailong.dao.AdminDao;
import com.hailong.domain.OrderBook;
import com.hailong.utils.DateUtils;

@Repository
public class AdminDaoImpl extends BaseDaoImpl implements AdminDao {


	
	/**
	 * 查询所有管理员的审核为null和支付状态为1的订单数据
	 */
	@Override
	public List<OrderBook> getAllAdminOptionIsNull() {
		Collection<OrderBook> or=userMaps.values();
		List<OrderBook> list=new ArrayList<OrderBook>(or);
		List<OrderBook> adminList=new ArrayList<OrderBook>();
		for(OrderBook ob:list){
			//String adminOption=ob.getAdminOpinion();
			//String payStauts=ob.getPayStatus();
			//得到当前订单所处的状态
			String status=ob.getStatus();
			//1表示已经支付的订单
			//0表示没有支付的订单
			//TODO 加上这个进行操作payStauts!=null&&"0".equals(payStauts)
			if(status!=null&&"1".equals(status)){
				adminList.add(ob);
			}
			
		}
		return adminList;
	}
	
	//删除图书订单数据
	public OrderBook deleteOrderBook(String bookId) {
		if(bookId!=null){
			return this.userMaps.remove(bookId);//17102252-8e52-44ab-b6c2-c646c8bf179a
		}else{
			return null;
		}
		
	}

	@Override
	public OrderBook updateAdminOpton(OrderBook ob) {
		String bookId=ob.getBookId();
		deleteOrderBook(bookId);
		this.userMaps.put(bookId,ob);
		return ob;
	}

	//进行汇总已经给了钱了订单数据
	@Override
	public List<OrderBook> getAllAdminOptionIsNotNull() {
		
		Collection<OrderBook> or=userMaps.values();
		List<OrderBook> list=new ArrayList<OrderBook>(or);
		List<OrderBook> adminList=new ArrayList<OrderBook>();
		for(OrderBook ob:list){
			String adminOption=ob.getAdminOpinion();
			Integer currentDate=DateUtils.formDateToInteger(new Date());//当前日期
			Integer srcDate=DateUtils.formDateToInteger(ob.getOrderTime());//下单日期
			boolean b=(currentDate-srcDate)>7;
			//System.out.println(b);
			//还有支付状态
			String status=ob.getStatus();
			if(adminOption ==null||!"通过".equals(adminOption)||currentDate>(srcDate+7)||status==null||!"2".equals(status)){ //currentDate>(srcDate+7) 表示不在一周之内
				continue;
			}
			adminList.add(ob);
		}
		return adminList;
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



}
