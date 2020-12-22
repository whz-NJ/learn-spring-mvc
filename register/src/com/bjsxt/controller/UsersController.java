package com.bjsxt.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.bjsxt.pojo.Users;
import com.bjsxt.service.UsersService;

@Controller
public class UsersController {
	@Resource
	private UsersService usersServiceImpl;
	
	@RequestMapping("register")
	public String register(Users users,MultipartFile file,HttpServletRequest req){
		String fileName = UUID.randomUUID().toString()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		// req.getServletContext() 为application对象。
		String path = req.getServletContext().getRealPath("images")+"/"+fileName;
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path));
		} catch (IOException e) {
			e.printStackTrace();  // Service层的异常可以往Controller抛，但Controller层的异常不能再往外抛了
			                     // 否则用户会看到500错误了
		}
		//只能取到webapps文件夹内容(JSP代码能够访问的最外层目录）
		users.setPhoto(fileName);
		int index = usersServiceImpl.insRegister(users);
		if(index>0){
			// 此时无法往这个页面传值，只能通过Session作用域传值了，无法通过Request作用域传了
			req.getSession().setAttribute("user", users);
			//如果不用redirect，刷新后的页面网址没变。导致重复提交
			// 这里转向FilesController的show端点调用（二不是加载show.jsp）
			return "redirect:/show";
		}else{
			// 此时无法往这个页面传值，只能通过Session作用域传值了，无法通过Request作用域传了
			return "redirect:/register.jsp";
		}
	}
}
