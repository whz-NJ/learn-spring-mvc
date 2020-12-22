package com.bjsxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class DemoController {
	// 使用原生Servlet的使用作用域传值，是要跳转的，所以不能加 @ResponseBody 修饰，负责直接返回客户端浏览器
	// 作用域设置的值不会被JSP网页接收到。
	@RequestMapping("demo1")
	public String demo1(HttpServletRequest abc, HttpSession sessionParam){
    // request 作用域
		abc.setAttribute("req", "req的值");
		//session作用域
		HttpSession session = abc.getSession();
		session.setAttribute("session", "session的值");
		sessionParam.setAttribute("sessionParam", "sessionParam");
		//application作用域
		ServletContext application = abc.getServletContext();
		application.setAttribute("application", "application的值");
		return "/index.jsp";
	}

	@RequestMapping("demo2")
	public String demo2(HttpSession session0){
		// 可以获取到demo1方法设置的session参数值
		// 在 spring-4.3.x 版本里有注解 @SessionAttribute ，修饰HandlerMethod入参，
		// 可以方便绑定获取到session作用域里同名的属性
		Object obj = session0.getAttribute("session");
		System.out.println(obj);
		return "/index.jsp";
	}
  // 把 map 中内容放在 request 作用域中
	// Spring 会对 map 集合通过 BindingAwareModelMap 进行实例化
	@RequestMapping("demo3")
	public String demo3(Map<String, Object> map){
		map.put("map", "map的值");
		return "/index.jsp";
	}

	// 使用SpringMVC 中Model 接口
	//把内容最终放入到request 作用域中.
	@RequestMapping("demo4")
	public String demo4(Model model){
		model.addAttribute("model", "model的值"); //不使用原生Servlet API设置值了，放在request作用域下
		return "/index.jsp";
	}

	// 使用SpringMVC 中 ModelAndView 接口
	//把内容最终放入到 request 作用域中.
	@RequestMapping("demo5")
	public ModelAndView demo5(){
		ModelAndView mav = new ModelAndView(("/index.jsp"));
		mav.addObject("mav", "mav的值");
		return mav;
	}

	// 错误示例：ServletContext 无法通过HandlerMethod入参获取
	@RequestMapping("demo9")
	public String demo9(HttpServletRequest abc, HttpSession sessionParam, ServletContext app){
		// request 作用域
		abc.setAttribute("req", "req的值");
		HttpSession session = abc.getSession();
		session.setAttribute("session", "session的值");
		sessionParam.setAttribute("sessionParam", "sessionParam");
		ServletContext application = abc.getServletContext();
		application.setAttribute("application", "application的值");
		app.setAttribute("app", "app");
		return "/index.jsp";
	}
}
