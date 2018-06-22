package com.hailong.service;


import javax.servlet.http.HttpServletRequest;

import com.hailong.domain.User;

public interface LoginService {
	//登录相关的方法
	public User login(User user,HttpServletRequest request);
}
