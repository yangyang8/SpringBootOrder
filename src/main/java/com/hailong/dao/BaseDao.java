package com.hailong.dao;

import java.util.List;

import com.hailong.domain.OrderBook;

public interface BaseDao<T> {
	
	//得到所有用户
	public List<T> findAll();
	
	//查询单个用户
	public T findOne(T entity);
	
	public void updateStatus(String bookId,String status);

}
