package com.bjsxt.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class DemoController {
	@RequestMapping("upload")
	// CommonsMultipartResolver 将客户端上传的二进制文件流转换为 HandlerMethod的 MultipartFile 类型入参，入参名必须和jsp里
	// type为file的input元素的name属性相同。
	public String upload(MultipartFile file,String name) throws IOException{
		String fileName = file.getOriginalFilename();
		//不同浏览器，上传文件的文件名不同，有的是文件名（谷歌浏览器），有的还带上客户端本地路径（window浏览器）
		String suffix = fileName.substring(fileName.lastIndexOf(".")); //substring(a,b)包括a,但不包括b（包前不包后）
		//判断上传文件类型
		if(suffix.equalsIgnoreCase(".png")){
			String uuid = UUID.randomUUID().toString();
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File("E:/"+uuid+suffix));
			return "/index.jsp";
		}else{
			return "error.jsp";
		}
	}
}
