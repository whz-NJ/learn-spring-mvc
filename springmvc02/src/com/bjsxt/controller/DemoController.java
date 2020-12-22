package com.bjsxt.controller;

import com.bjsxt.pojo.Demo;
import com.bjsxt.pojo.Demo2;
import com.bjsxt.pojo.People;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DemoController {
	// @RequestMapping("demo")
	public String demo(){
		System.out.println("执行demo");
		return "main.jsp";
	}
	// @RequestMapping("demo")
	public String demo(String name, int age){
		System.out.println("执行demo"+name + "   " + age);
		return "main.jsp";
	}
	@RequestMapping("demo")
	public String demo(People people, @RequestParam(value="name1")String name, int age, HttpServletRequest req, HttpSession session){
		System.out.println("执行demo"+people + " " + name + " " + age);
		// req.getSession 和 session 变量相同
		req.setAttribute("demo123", "测试");
		return "main.jsp";
	}
	// @RequestMapping("demo2")
	public String demo2(){
		System.out.println("demo2");
		return "main1.jsp";
	}
	@RequestMapping("demo2")
	public String demo2(@RequestParam(required = true) String name){
		System.out.println("demo2");
		return "main1.jsp";
	}
	@RequestMapping("page")
	// 为了访问不带参数的page时不报错，可以把原子类型修改为封装类型
	// public String page(int pageSize, int pageNo) {
	// public String page(Integer pageSize, Integer pageNo) {
	// 也可以通过 @RequestParam 设置缺省值
	public String page(@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "1")int pageNo) {
		System.out.println("pageSize=" + pageSize + "pageNo=" + pageNo);
		return "main.jsp";
	}

	@RequestMapping("demo5")
	// public String demo2(String name, int age, List<String> hover){
	// public String demo2(String name, int age, ArrayList<String> hover){
	public String demo2(String name, int age, @RequestParam(value="hover") List<String> hover){
		System.out.println(name + " " + age + " " + hover);
		return "main.jsp";
	}
	@RequestMapping("demo6")
	// public String demo2(String name, int age, List<String> hover){
	// public String demo2(String name, int age, ArrayList<String> hover){
	public String demo6(Demo demo){
		System.out.println(demo);
		return "forward:main.jsp";
	}
	@RequestMapping("demo7")
	public String demo7(Demo2 demo){
		System.out.println(demo);
		return "main";
	}

	@RequestMapping("demo8/{age1}/{name1}")
	public String demo8(@PathVariable(value="name1") String name, @PathVariable int age1){
		System.out.println(name + " " + age1);
		return "main";
	}

	@RequestMapping("/demo9/{age1}/{name1}")
	public String demo9(){
		System.out.println("转发");
		return "redirect:/main.jsp";
	}

	@RequestMapping("/demo10")
	public String demo10(){
		// return "demo11"; // 会通过自定义视图解析器，认为是一个jsp文件（/demo11.jsp 文件不存在）
		return "forward:demo11";  // 此时不走自定义视图解析器，而是走系统默认视图解析器
	}
	@RequestMapping("/demo11")
	public String demo11(){
		return "main";
	}

	//纯servlet实现给客户端返回对象json字符串
	@RequestMapping("/demo12")
	public void demo12(HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		out.print("对象的json字符串");
		out.flush();
		out.close();
	}

	@RequestMapping("/demo13")
	@ResponseBody // 把返回值转换为json字符串，并把content-Type为application-json;charset=utf-8，并不跳转到某个静态网页
	// 想要该注解生效，需要导入jackson的三个jar包：jackson-annotations-2.4.0 jackson-core-2.4.1 jackson-databind-2.4.1
	public People demo13() {
		People p = new People();
		p.setName("张三");
		p.setAge(23);
		return p;
	}
	@RequestMapping(value = "/demo14", produces = "text/html;charset=utf-8")
	@ResponseBody // 如果返回值为原子类型，@ResponseBody会把Content-Type设置为text/html
	              // 由于没有指定字符集，会有中文乱码问题，可以在 @RequestMapping 中的produces指定Content-Type
	public String demo14() {
		return "张三";
	}
}
