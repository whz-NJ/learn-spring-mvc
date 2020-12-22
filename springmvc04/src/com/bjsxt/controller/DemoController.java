package com.bjsxt.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
	// 返回值为 void ，表示不跳转页面。
	@RequestMapping("download")
	public void download(String fileName,HttpServletResponse res,HttpServletRequest req) throws IOException{
		// res.setHeader("Content-Disposition", "inline");
		//设置响应流中文件进行下载
		res.setHeader("Content-Disposition", "attachment;filename="+fileName);
		// res.getWriter(); // 输出字符流，这里不能用
		//把二进制流放入到响应体中.
		ServletOutputStream os = res.getOutputStream();
		// getServletContext() 应用程序对象
		String path = req.getServletContext().getRealPath("files"); //固定从files目录下查找需要下载的源文件
		System.out.println(path);
		File file = new File(path, fileName);
		byte[] bytes = FileUtils.readFileToByteArray(file);
		os.write(bytes);
		os.flush();
		os.close();
	}
}
