package com.bjsxt.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	// 拦截器拦截的是控制器,不能拦截jsp的访问
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object arg2) throws Exception {
		String uri = req.getRequestURI();
		// 如果用户在客户端浏览器访问的页面就是 login，则放行，正常走视图解析器，显示login.jsp
		if(uri.equals("/springmvc08_Web_exploded/login")){
			return true;
		}else{
			Object obj = req.getSession().getAttribute("users");
			if(obj!=null){ //用户已经登录，则放行
				return true;
			}
			//重定向跳转时，/表示服务器根目录，而不是 WebContent 子目录
			res.sendRedirect("/springmvc08_Web_exploded/login.jsp");
			return false;
		}
	}

}
