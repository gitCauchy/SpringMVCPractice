package com.cauchy.ssm.exception;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomExceptionResolver implements HandlerExceptionResolver{
	
	public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response,
			Object handler,Exception ex) {
		// Handler就是处理器适配器执行Handler对象
		// 解析出异常类型：
		// 如果是系统自定义异常类型
		String message = null;
		if(ex instanceof CustomException) {
			message = ((CustomException)ex).getMessage();
		}else {
			// 不是系统自定义类型：
			message = "Undefined Exception";
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message",message);
		modelAndView.setViewName("error");
		return modelAndView;
	}


}
