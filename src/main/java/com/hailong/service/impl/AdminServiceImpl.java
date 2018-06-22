package com.hailong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hailong.dao.AdminDao;
import com.hailong.domain.OrderBook;
import com.hailong.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao adminDao;
	
	//查询所有已经下单的数据
	@Override
	public List<OrderBook> getAllOrderTask() {
		List<OrderBook>  list=adminDao.getAllAdminOptionIsNull();
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}
	
	//进行修改数据
	public OrderBook updateAdminOpton(OrderBook ob){
		if(ob!=null){
			String adminOption=ob.getAdminOpinion();
			String bookId=ob.getBookId();
			if(adminOption!=null&&!"".equals(adminOption)&&bookId!=null&&!bookId.equals("")){
				OrderBook orderBook=adminDao.findOne(bookId);
				adminDao.updateStatus(orderBook.getBookId(),"2");
				orderBook.setAdminOpinion(ob.getAdminOpinion());
				return adminDao.updateAdminOpton(orderBook);
			}
		}
		return null;
	}
	
	public List<OrderBook> getAllOrderTaskPassed() {
		List<OrderBook>  list=adminDao.getAllAdminOptionIsNotNull();
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}

}
