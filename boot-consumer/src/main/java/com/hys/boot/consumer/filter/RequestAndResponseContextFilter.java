package com.hys.boot.consumer.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hys.boot.consumer.servlet.RequestAndResponseContextHolder;

@WebFilter(urlPatterns = "/*", filterName = "RequestAndResponseFilter")
public class RequestAndResponseContextFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		RequestAndResponseContextHolder.setRequest((HttpServletRequest)arg0);
        RequestAndResponseContextHolder.setResponse((HttpServletResponse) arg1);
        arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
