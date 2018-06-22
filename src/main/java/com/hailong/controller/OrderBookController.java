package com.hailong.controller;


import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.hailong.domain.OrderBook;
import com.hailong.service.OrderBookService;


/**
 * 处理我们的图书订购相关的控件器
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/OrderBook")
public class OrderBookController {
	
	@Autowired
	private OrderBookService orderBookService;
	

	
	//查询所有
	@RequestMapping("/pageList.action")
	public ModelAndView pageList(Model model){
		List<OrderBook> list=orderBookService.findAll();
		model.addAttribute("dataList",list);
		return new ModelAndView("page/OrderBookList","",model);
	}
	
	//查询单个
	@RequestMapping("/pageOne.action")
	public ModelAndView pageOne(String bookId,Model model){
		
		OrderBook orderBook=orderBookService.findOne(bookId);
		if(orderBook!=null){
			model.addAttribute("obj",orderBook);
			return new ModelAndView("page/OrderBookList","",model);
		}
		
		return new ModelAndView("page/OrderBookList");//没有数据
	}
	
	//增加图书订单
	@RequestMapping("/addOrderBook.action")
	public ModelAndView addOrderBook(OrderBook ob,HttpServletRequest request){
		if(ob!=null){
			//增加数据
			OrderBook orderBook=orderBookService.addOrderBook(ob,request);
			if(orderBook!=null){
				//Deployment deployment=orderBookService.DeploymentOrderProcess();
			}else{
				//不成功
			}
		}
		return new ModelAndView("redirect:pageList.action");
	}
	
	@RequestMapping("delete.action")
	public ModelAndView deleteOrderBook(String bookId){
		OrderBook ob=orderBookService.deleteOrderBook(bookId);
		if(ob!=null){
			//成功
			
		}else{
			//失败
		}
		return new ModelAndView("redirect:pageList.action");
	}
	
	/**
	 * 根据Id来查询数据
	 * @param bookId
	 * @return
	 */
	@RequestMapping("/toView.action")
	public String toView(String bookId){
		
		OrderBook ob=orderBookService.findOne(bookId);
		if(ob!=null){
			String json=JSON.toJSONString(ob);
			return json;
		}else{
			return null;
		}
		
	}
	
	@RequestMapping("/orderBookStatus.action")
	public ModelAndView testModal(Model model){
		List<OrderBook> list=orderBookService.findAll();
		model.addAttribute("dataList",list);
		return new ModelAndView("page/OrderBookStatus","",model);
	}
	
	/**
	 * 更新订单详情当中的数据
	 * @param ob 订单详情的对象
	 * @return
	 */
	@RequestMapping("/update.action")
	public ModelAndView update(OrderBook ob){
		if(ob!=null){
			orderBookService.updateOrderBook(ob);
		}
		return new ModelAndView("redirect:pageList.action");

	}
	
	//数据一支付，那则流程就开启了
	@RequestMapping("/updatePay.action")
	public ModelAndView updatePay(String bookId){
		if(bookId!=null&&!"".equals(bookId)){
			if(orderBookService.updatePay(bookId)){
				//进行开启执行流程
				//ProcessInstance process=orderBookService.startProcessInstance();
				/*System.out.println(process.get);*/
				
				//进行修改订单的状态,这个代码也可以写在updatePay()当中
				orderBookService.updateStatus(bookId);
				System.out.println("支付成功b...");
				
			}else{
				//不成功
			}
		}
		return new ModelAndView("redirect:orderBookStatus.action");
	}
	/*
	//查询具体的流程图
	@RequestMapping("/WatchProcessImage.action")
	public void WatchProcessImage(String deploymentId,String imageResourceName,HttpServletResponse response){
		
		if(deploymentId!=null&&!"".equals(deploymentId)&&imageResourceName!=null&&!"".equals(imageResourceName)){
			orderBookService.WatchProcessImage(deploymentId, imageResourceName, response);
		}
	}
	
	//订单状态中转操作
	@RequestMapping("/OrderStatus.action")
	public ModelAndView OrderStatus(){
		return new ModelAndView("page/OrderStatus");
	}
	
	//获取所有的个人任务
    @RequestMapping("/AllPersonTask.action")
    public ModelAndView AllPersonTask(Model model){
    	List<Task> task=orderBookService.getPersonTask();
    	model.addAttribute("dataList",task);
    	return new ModelAndView("page/OrderStatus");
    }*/
}
