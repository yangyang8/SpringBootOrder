package com.hailong.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hailong.dao.UserDao;
import com.hailong.domain.User;
import com.hailong.utils.MD5Utils;

@Repository

public class UserDaoImpl implements UserDao<User>{

	private static Map<String,User> userMaps=null;
	static{
		userMaps=new HashMap<String,User>();
		userMaps.put("gd001",new User("gd001","杨海龙",MD5Utils.md5("123456"),"15计科7班"));
		userMaps.put("gd002",new User("gd002","余永康",MD5Utils.md5("123456"),"15计科7班"));
		userMaps.put("gd003",new User("gd003","罗家林",MD5Utils.md5("123456"),"15计科7班"));
		userMaps.put("gd004",new User("gd004","吴国聪",MD5Utils.md5("123456"),"15计科7班"));
		userMaps.put("gd005",new User("gd005","admin",MD5Utils.md5("admin"),"广东理工学院"));
	}
	
	public List<User> findAll() {
		return (List<User>)userMaps.values();
	}

	/**
	 * 进行判断一下用户是否存在
	 * @param user 登录用户数据
	 * @return 存在则返回数据库当中的对象，不成功则返回null
	 */
	public User findOne(User user) {
		if(user!=null){
			//则取出根据Id取出用户数据
			User u=userMaps.get(user.getCardId());
			if(u!=null){
				//则进行判断密码是否相等
				String pass=u.getPassword();
				if(pass.equals(user.getPassword())){
					return u;
				}
			}
		}
		return null;
	}

	@Override
	public void updateStatus(String bookId, String status) {
		// TODO Auto-generated method stub
		
	}


}
