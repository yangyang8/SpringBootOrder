package com.hailong.domain;

public class User {
	
	private String cardId; //图书管理系统卡号
	private String username;//用户名
	private String password;//密码
	private String classes;//年级
	
	public User(){
		
	}
	
	public User(String cardId, String username, String password, String classes) {
		super();
		this.cardId = cardId;
		this.username = username;
		this.password = password;
		this.classes = classes;
	}




	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	
}
