package com.hailong.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hailong.domain.OrderBook;


public interface OrderBookService {
	//登录相关的方法
	public List<OrderBook> findAll();
	
	public OrderBook findOne(String bookId);

	public OrderBook addOrderBook(OrderBook ob,HttpServletRequest request);
	
	public OrderBook deleteOrderBook(String bookId);

	public OrderBook updateOrderBook(OrderBook ob);

	public boolean updatePay(String bookId);

	public boolean updateStatus(String bookId);
	
/*	//创建部著流程实例
	public Deployment DeploymentOrderProcess();
	
	//开启流程实例
	public ProcessInstance startProcessInstance();
	
	public void completeTask(String taskId);
	
	//查看具体的流程图
	public void WatchProcessImage(String deploymentId,String imageResourceName,HttpServletResponse response);

	//进行得到所有的没有完成的任务
	public void getAllNoCompleteTask();
	
	//查询个人任务
	public List<Task> getPersonTask();*/
	
}
