package com.bjsxt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjsxt.pojo.Users;

@Controller
public class DemoController {
	//下面的写法不灵活：如果page下有多个页面，controller就需要写多个方法
//	@RequestMapping("main1")
//	public String main1(){
//		// 如果 springmvc.xml里没有定义 InternalResourceViewResolver，
//		// 这里应该： return "/WEB-INF/page/main1.jsp"
//		return "main1";
//	}
	//通过restful风格，这样不管page下有多少个页面，controller的方法只需要一个
	// 这个方法，如果浏览器客户端访问，会访问到 /WEB-INF/page/ 目录下对应页面
	// 这不满足先登录要求，为了实现登录后再访问，需要定义一个LoginInterceptor
	// 判断用户登录状态，如果为已登录再走到这里
	@RequestMapping("{page}")
	public String main(@PathVariable String page){
		System.out.println("restful");
		return page; //没有加redirect:/forward:前缀，所以这里会走视图解析器，访问 WEB-INF/page/目录下的页面
	}
	@RequestMapping("login")
	public String login(Users users,HttpSession session){
		if(users.getUsername().equals("admin")&&users.getPassword().equals("123")){
			session.setAttribute("users", users);
			return "main"; //没有加redirect:/forward:前缀，所以这里会走视图解析器，访问 WEB-INF/page/main.jsp
			               // 如果return "redirect:/main" 会走控制器
		}else{
			return "redirect:/login.jsp"; // 这里不走视图解析器，所以路径要写全
		}
	}
}
