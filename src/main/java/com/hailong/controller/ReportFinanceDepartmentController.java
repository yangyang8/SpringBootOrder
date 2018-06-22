package com.hailong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.hailong.domain.OrderBook;
import com.hailong.po.PayMoneyImage;
import com.hailong.service.ReportFinanceDepartmentService;

@RestController
@RequestMapping("/OrderBook")
public class ReportFinanceDepartmentController {
	
	@Autowired
	private ReportFinanceDepartmentService reportFinanceDepartmentService;
	
	//上传财务部门的相关操作,也就是他的更新操作
	@RequestMapping("/ReportFinanceDepartment.action")
	public ModelAndView reportFinanceDepartment(String bookIds[]){
		
		if(bookIds!=null&&bookIds.length>0){
			//把相关的当前的这个订单的状态更改为财务部门审核的状态
			
			//根据Id来查多个
			reportFinanceDepartmentService.updateByIds(bookIds);
			
		}
		
		return new ModelAndView("redirect:financeDepartmentPageList.action");
	}
	
	//查询所有已经在财务审核的数据
	@RequestMapping("/financeDepartmentPageList.action")
	public ModelAndView pageList(Model model){
		List<OrderBook> orderList=reportFinanceDepartmentService.findByStatus();
		model.addAttribute("dataList",orderList);
		return new ModelAndView("page/FinanceDepartment","",model);
	}
	
	//更新之后就可以进行财务区总的相关操作了
	@RequestMapping("/updateFinanceDepartment.action")
	public ModelAndView updateFinanceDepartment(OrderBook ob){
		reportFinanceDepartmentService.updateFinancialDepartment(ob);
		return new ModelAndView("redirect:financeSummary.action");
	}
	
	//财务区总的相关操作了
	@RequestMapping("/financeSummary.action")
	public ModelAndView financeSummary(Model model){
		List<OrderBook> orderList=reportFinanceDepartmentService.getAllOrderTaskPassed();
		//TODO 这个可以使用一个图表来表示这些区总的信息
		
		model.addAttribute("dataList",orderList);
		return new ModelAndView("page/financeSummary","",model);
	}
	
	@RequestMapping("/getTotalMoney.action")
	public String getTotalMoney(String bookIds[]){
		if(bookIds!=null&&bookIds.length>0){
			PayMoneyImage img=reportFinanceDepartmentService.getTotalMoney(bookIds);
			//进行围成json格式的数据
			String json=JSON.toJSONString(img);
			return json;
		}
		return null;
	}

}
