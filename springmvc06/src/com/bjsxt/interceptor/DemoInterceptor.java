package com.bjsxt.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class DemoInterceptor implements HandlerInterceptor {
	//在进入控制器之前执行
	//如果返回值为false,阻止进入控制器
	//控制代码
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// arg2 为拦截的控制器Controller方法的Method对象
		System.out.println("arg2:"+arg2);
		System.out.println("preHandle");
		//如果要实现用户未登陆，不允许访问的功能，可以在这里判断用户登录状态，如果未登录，
		// 调用arg1.sendRedirect()，重定向到登录页面; 再返回false 即可，如果不调用sendRedirect
		// 而直接返回false，客户端浏览器看到的是大白空白页面（HTTP响应没有消息体）
		return true;
	}
	//控制器正常执行完成后（返回一个JSP网页）,进入到jsp之前执行.
	// 如果控制器抛异常，postHandle 方法不会被执行
	//方法可以实现的功能：日志记录（访问的JSP网页）、敏感词语过滤
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// 这里的ModelAndView 可以修改view（最好不要），也可以修改model里的变量值
		System.out.println("往"+arg3.getViewName()+"跳转");
		System.out.println("model的值"+arg3.getModel().get("model"));
		String word = arg3.getModel().get("model").toString();
		String newWord = word.replace("祖国", "**");
		arg3.getModel().put("model", newWord);
//		arg3.getModel().put("model", "修改后的内容");
		System.out.println("postHandle");
	}
	//jsp执行完成后执行
	//方法可以实现的功能：记录执行过程中出现的异常（包括控制器异常），无论执行时是否出现异常，都会调用该方法
	// 可以把异常记录到日志中，但这里捕获到的异常会返回给客户端浏览器（可以通过ExceptionHandler包装一下Exception再返回给客户端）
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("arg3:"+arg3);
		System.out.println("afterCompletion"+arg3.getMessage());
	}
}
