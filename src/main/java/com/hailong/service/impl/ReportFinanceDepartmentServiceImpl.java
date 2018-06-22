package com.hailong.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hailong.dao.AdminDao;
import com.hailong.dao.FinanceDepartmentDao;
import com.hailong.domain.OrderBook;
import com.hailong.po.PayMoneyImage;
import com.hailong.service.AdminService;
import com.hailong.service.ReportFinanceDepartmentService;
import com.hailong.utils.BarCodeUtils;

@Service
public class ReportFinanceDepartmentServiceImpl implements ReportFinanceDepartmentService {
	
	@Autowired
	private FinanceDepartmentDao financeDepartmentDao;
	
	@Override
	public List<OrderBook> getAllOrderTask() {
		List<OrderBook>  list=financeDepartmentDao.getAllFinancialDepartmentIsNull();
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}
	
	//进行修改数据
	public OrderBook updateFinancialDepartment(OrderBook ob){
		if(ob!=null){
			String financialDepartment=ob.getFinancialDepartment();
			String bookId=ob.getBookId();
			if(financialDepartment!=null&&!"".equals(financialDepartment)&&bookId!=null&&!bookId.equals("")){
				OrderBook orderBook=financeDepartmentDao.findOne(bookId);
				orderBook.setFinancialDepartment(financialDepartment);
				return financeDepartmentDao.updateFinancialDepartment(orderBook);
			}
		}
		return null;
	}
	
	public List<OrderBook> getAllOrderTaskPassed() {
		List<OrderBook>  list=financeDepartmentDao.getAllFinancialDepartmentIsNotNull();
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}
	

	//根据Id来查询多个图书对象
	public List<OrderBook> findByIds(String bookIds[]){
		List<OrderBook> orderList=new ArrayList<OrderBook>();
		for(String bookId:bookIds){
			OrderBook ob=financeDepartmentDao.findOne(bookId);
			if(ob!=null){
				orderList.add(ob);
			}
		}
		return orderList;
	}

	//更新上传的状态
	@Override
	public void updateByIds(String[] bookIds) {
		
		for(String bookId:bookIds){
			OrderBook ob=financeDepartmentDao.findOne(bookId);
			ob.setStatus("3");//3为财务审核
			financeDepartmentDao.updateFinancialDepartment(ob);
		}
	}

	//查询所有财务审核数据,是要先根据financeDepartment来查询数据
	@Override
	public List<OrderBook> findByStatus() {
		List<OrderBook> list=financeDepartmentDao.findAllByStatus("3");
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}

	@Override
	public PayMoneyImage getTotalMoney(String[] bookIds) {
		double totalMoney=0;
		for(String bookId:bookIds){
			OrderBook ob=financeDepartmentDao.findOne(bookId);
			totalMoney+=ob.getTotalNumber();
		}
		//然后生成二维码
		BarCodeUtils.makeQRCode(""+totalMoney);
		
		//创建一个图片路径对象
		PayMoneyImage img=new PayMoneyImage();
		img.setTotalMoney(totalMoney);
		img.setImgPath("../img/qr_"+totalMoney+".png");
		return img;
	}

}
