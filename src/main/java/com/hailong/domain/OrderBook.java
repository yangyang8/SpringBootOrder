package com.hailong.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 购卖信息实体
 * @author Administrator
 *
 */
public class OrderBook {
	//包括书名、作者、出版社、条码号、定价等
	private String bookId;//图书编号
	private String bookName;//书名
	private String userName;//购卖人
	private String author;//作者
	private String publish;//出版社
	private String barcode;//条形码，使用UUID模板一下
	private double price;//定价
	
	private Integer number=1;
	
	private Double totalNumber;
	
	private String adminOpinion="";//管理员审核意见
	
	private String financialDepartment="";//财务部门审核意见
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:SS") //日期化
	private Date orderTime=new Date(); //当前的下订单的日期
	
	private String delTag="0";//1 表示已经删除，0表示未删除
	
	private String status="0";//上报状态  0 表示为未下单   1表示已下单  2表示管理员审核状态  3表示账务审核  4表示购卖状态 5表示已完成状态 
	
	private String payStatus="0";//支付状态,default为0
	
	public OrderBook(){
		
	}
	
	
	
	
	
	
	public OrderBook(String bookId, String bookName, String userName, String author, String publish, String barcode,
			double price, Integer number, Double totalNumber, String adminOpinion, String financialDepartment,
			Date orderTime, String payStatus) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.userName = userName;
		this.author = author;
		this.publish = publish;
		this.barcode = barcode;
		this.price = price;
		this.number = number;
		this.totalNumber = totalNumber;
		this.adminOpinion = adminOpinion;
		this.financialDepartment = financialDepartment;
		this.orderTime = orderTime;
		this.payStatus = payStatus;
	}
	
	public OrderBook(String bookId, String bookName, String userName, String author, String publish, String barcode,
			double price, Integer d,
			Date orderTime,String status,String payStatus) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.userName = userName;
		this.author = author;
		this.publish = publish;
		this.barcode = barcode;
		this.price = price;
		this.number = d;
		this.status=status;
		this.totalNumber = price*number;
		this.orderTime = orderTime;
		this.payStatus = payStatus;
	}






	public OrderBook(String bookId, String bookName, String userName, String author, String publish, String barcode,
			double price, String adminOpinion, String financialDepartment, String payStatus) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.userName = userName;
		this.author = author;
		this.publish = publish;
		this.barcode = barcode;
		this.price = price;
		this.adminOpinion = adminOpinion;
		this.financialDepartment = financialDepartment;
		this.payStatus = payStatus;
	}

	
	
	
	public OrderBook(String bookId, String bookName, String userName, String author, String publish, String barcode,
			Integer number,double price,String status ,String payStatus) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.userName = userName;
		this.author = author;
		this.publish = publish;
		this.barcode = barcode;
		this.price = price;
		this.payStatus = payStatus;
		this.number=number;
		this.totalNumber=number*price;
		this.status=status;
	}


	
	
	
	

	public Date getOrderTime() {
		return orderTime;
	}




	public void setOrderTime(Date orderTime) {
		/*SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
		String d=dateFormat.format(orderTime);*/
		this.orderTime = orderTime;
	}




	public void setTotalNumber(Double totalNumber) {
		this.totalNumber = totalNumber;
	}




	public Integer getNumber() {
		return number;
	}

	
	
	
	public String getDelTag() {
		return delTag;
	}






	public void setDelTag(String delTag) {
		this.delTag = delTag;
	}






	public String getStatus() {
		return status;
	}






	public void setStatus(String status) {
		this.status = status;
	}






	public void setNumber(Integer number) {
		this.number = number;
	}




	public Double getTotalNumber() {
		return totalNumber;
	}




	public void setTotalNumber() {
		this.totalNumber = this.number*this.price;
	}


	public String getAdminOpinion() {
		return adminOpinion;
	}



	public void setAdminOpinion(String adminOpinion) {
		this.adminOpinion = adminOpinion;
	}




	public String getFinancialDepartment() {
		return financialDepartment;
	}




	public void setFinancialDepartment(String financialDepartment) {
		this.financialDepartment = financialDepartment;
	}




	public String getPayStatus() {
		return payStatus;
	}



	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}



	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBookId() {
		return bookId;
	}


	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
