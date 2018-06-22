package com.hailong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hailong.domain.OrderBook;
import com.hailong.service.AdminService;

/**
 * 管理员审查相关操作
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/OrderBook")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	//查询所有下单的订单数据
	@RequestMapping("/getAllOrder.action")
	public ModelAndView getAllOrder(Model model){
		List<OrderBook> adminCheck=adminService.getAllOrderTask();
		model.addAttribute("dataList",adminCheck);
		return new ModelAndView("page/AdminCheck","",model);
	}
	
	@RequestMapping("/updateAdminOpton.action")
	public ModelAndView updateAdminOpton(OrderBook ob){
		adminService.updateAdminOpton(ob);
		return new ModelAndView("redirect:getAllOrder.action");
	}
	
	//进行管理员统计总的订单进行汇总，然后上报给财务部门
	@RequestMapping("/adminSummary.action")
	public ModelAndView adminSummary(Model model){
		//TODO 下次要根据传入的日期进行数据的更新,然后再在这个时间内进行汇总，上传给财务部门
		
		List<OrderBook> adminCheck=adminService.getAllOrderTaskPassed();
		model.addAttribute("dataList",adminCheck);
		return new ModelAndView("page/adminSummary","",model);
	}
	

	
	//导出所有本次订单数据到本地 ，根据最新的一周的时间显示的所有的订单数据
	@RequestMapping("/exportOrderBook.action")
	public ModelAndView exportOrderBook(String bookIds[]){
		//TODO 下次开发
		
		return new ModelAndView("redirect:adminSummary.action");
	}

}
