package com.hys.boot.provider.servlet;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取ServletRequest
 * @author Administrator
 *
 */
public class RequestHolder{
	// 委托给Spring实现
    public static HttpServletRequest getRequest() {
        return RequestAndResponseContextHolder.getRequest();
    }
}
