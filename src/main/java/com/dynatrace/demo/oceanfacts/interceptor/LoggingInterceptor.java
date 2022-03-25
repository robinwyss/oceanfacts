package com.dynatrace.demo.oceanfacts.interceptor;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest requestServlet, HttpServletResponse responseServlet, Object handler) {
        String clientIp = requestServlet.getHeader("X-Real-Ip");
        if(clientIp == null) {
            clientIp = requestServlet.getRemoteAddr();
        }
        ThreadContext.put("clientIp", clientIp);//${::-${ctx:test}}
        return true;
    }
}
