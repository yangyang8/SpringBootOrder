package com.hailong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hailong.domain.PurchaseOrder;
import com.hailong.service.ExportPurchasingDepartmentService;

@RestController
@RequestMapping("/purchaseDepartment")
public class ExportPurchasingDepartmentController {
	
	@Autowired
	private ExportPurchasingDepartmentService exportPurchaingDepartment;
	
	//生成采购清单
	@RequestMapping("/exportPurchasingDepartment.action")
	public ModelAndView exportPurchasingDepartment(String[] bookIds){
		
		if(bookIds!=null&&bookIds.length>0){
			//先查询数据，后增加
			exportPurchaingDepartment.addPurchaseOrder(bookIds);
		}
		
		return new ModelAndView("redirect:exportPurchasePageAll.action");
	}
	
	
	@RequestMapping("/exportPurchasePageAll.action")
	public ModelAndView exportPurchase(Model model){
		//查询所有的订单数据
		List<PurchaseOrder> list=exportPurchaingDepartment.getAllPageList();
		if(list!=null&&list.size()>0){
			model.addAttribute("dataList",list);
		}
		return new ModelAndView("page/PurchaingDepartment","",model);
	}
	
	//完成订单数据数据           
	@RequestMapping("/finishPurchased.action")
	public ModelAndView finishPurchased(String ids[]){
		if(ids!=null&&ids.length>0){
			exportPurchaingDepartment.updatePurStatusById(ids);
		}
		return new ModelAndView("redirect:exportPurchasePageAll.action");
	}
	
	//查询购卖记录               
	@RequestMapping("/findPurchasedRecord.action")
	public ModelAndView findPurchasedRecord(Model model){
		List<PurchaseOrder> list=exportPurchaingDepartment.findPurchasedRecord();
		if(list!=null&&list.size()>0){
			model.addAttribute("dataList",list);
		}
		return new ModelAndView("page/PurchasedRecord","",model);
	}

}
