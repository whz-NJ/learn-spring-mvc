package com.bjsxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
	@RequestMapping("demo4")
	public String demo( Model model){ //只使用model功能
		System.out.println("执行demo");
//		int i = 5/0;
		model.addAttribute("model", "我们都爱祖国.");
		return "index.jsp";  //view的功能：指定跳转到哪个jsp
	}
}
