package com.hailong.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hailong.domain.User;
import com.hailong.service.LoginService;

@Controller
public class LoginController {
	
	
	
	//注入用户Service层的对象
	@Autowired
	private LoginService loginService;
	
	//根路径下匹配到登录页面
	@RequestMapping("/")
	public String root(){
		return "login";
	}
	
	@RequestMapping("/loginIn.action")
	public String loginIn(){
		return "login";
	}
	
	
	
	@RequestMapping("/login.action")
	public ModelAndView login(User user,Model model,HttpServletRequest request){
		User u=loginService.login(user,request);
		if(u!=null){
			model.addAttribute("success",true);
			model.addAttribute("obj",u);
			//则中转到首页
			return new ModelAndView("redirect:/index.action","",model);
		}else{
			model.addAttribute("success",false);
			//给用户提示，让他停在登录页
			return new ModelAndView("login","",model);
		}
	}
	
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("/index.action")
	public String index(){
		return "page/index";
	}
	
	
}
