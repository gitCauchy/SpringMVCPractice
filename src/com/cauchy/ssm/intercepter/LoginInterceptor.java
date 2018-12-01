package com.cauchy.ssm.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{
	
	// 进入Handler方法之前，用于身份认证和身份授权，如果身份认证不通过，表示当前用户没有权限，拦截，不再向下执行
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
				Object handler) throws Exception {
		// 获取请求的URL：
		String url = request.getRequestURI();
		// 判断是否是公开地址
		if(url.indexOf("/login.action") >= 0) {
			return true;
		}
		// 判断session
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		if(userName != null) {
			return true;
		}
		// 登录未通过，需要跳转到登录页面：
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
		return false;
	}
	// 进入Handler方法之后，返回ModelAndView之前，应用场景为从modelAndView 出发,将共用的数据从这里传到视图
	// 也可以从这里统一制定视图
	@Override
	public void postHandle(HttpServletRequest request, 
			HttpServletResponse response, 
				Object Handler, ModelAndView modelAndView)
			throws Exception {
	}
	// 执行Handler之后，统一的异常处理，还可以用于统一的日志处理
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, 
				Object handler, Exception ex)
			throws Exception {
	}
	

}
