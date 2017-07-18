package com.hys.boot.provider.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @author apple
 */
public class RequestAndResponseContextHolder {
    
    public static final String RESPONSE_NAME_AT_ATTRIBUTES = ServletRequestAttributes.class.getName() + ".ATTRIBUTE_NAME";
    
    private static final ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<HttpServletRequest>();
    
    public static void setRequest(HttpServletRequest request) {
        requestHolder.set(request);
    }
    
    public static HttpServletResponse getResponse() {
        HttpServletRequest request = getRequest();
        if(request != null) 
            return (HttpServletResponse)request.getAttribute(RESPONSE_NAME_AT_ATTRIBUTES);
        return null;
    }
    
    public static HttpServletRequest getRequest() {
        return requestHolder.get();
    }
    
    public static void setResponse(HttpServletResponse response) {
        HttpServletRequest request = getRequest();
        if(request != null) 
            request.setAttribute(RESPONSE_NAME_AT_ATTRIBUTES, response);
    }
    
    public static void release() {
        requestHolder.remove();
    }

}
