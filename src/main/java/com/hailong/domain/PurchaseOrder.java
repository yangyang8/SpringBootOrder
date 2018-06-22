package com.hailong.domain;

import java.util.Date;

/**
 * 采购清单数据
 * @author Administrator
 *
 */
public class PurchaseOrder {
	
	private String id;
	private String bookName;
	private Double price;
	private Integer number;
	private Double totalPrice;
	private String userName;
	
	private String barcode;
	
	private Date orderTime=new Date();//下单日期
	
	private String purStatus="0";//采购状态  0表示采购 1表示已经完成
	
	public PurchaseOrder(){
		
	}

	
	
	public String getBarcode() {
		return barcode;
	}



	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}



	public PurchaseOrder(String id, String bookName, Double price, Integer number, Double totalPrice, Date orderTime,
			String purStatus) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.price = price;
		this.number = number;
		this.totalPrice = totalPrice;
		this.orderTime = orderTime;
		this.purStatus = purStatus;
	}

	
	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getPurStatus() {
		return purStatus;
	}

	public void setPurStatus(String purStatus) {
		this.purStatus = purStatus;
	}
	
}
