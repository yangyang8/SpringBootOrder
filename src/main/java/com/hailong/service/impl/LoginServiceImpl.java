package com.hailong.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hailong.dao.UserDao;
import com.hailong.domain.User;
import com.hailong.service.LoginService;
import com.hailong.utils.MD5Utils;

@Service
public class LoginServiceImpl implements LoginService{
	//注入Dao层的用户相关操作方法
	@Autowired
	private UserDao<User> userDao;
	
	/**
	 * 用户登录相关业务操作
	 * true表示登录成功
	 * false 表示登录失败
	 */
	public User login(User user,HttpServletRequest request) {
		if(user!=null&&user.getCardId()!=null&&!user.getCardId().equals("")){
			user.setPassword(MD5Utils.md5(user.getPassword()));//进行数据加密相关的操作
			User u=userDao.findOne(user);
			
			if(u!=null){//成功
				//把这个用户放入到Session当中
				request.getSession().setAttribute("currentUser",u);
				return u;
			}
			return null; //失败
		}
		return null;
	
	}
	
	

}
