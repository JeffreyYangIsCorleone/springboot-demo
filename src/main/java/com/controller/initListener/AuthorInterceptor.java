package com.controller.initListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(AuthorInterceptor.class);

    private NamedThreadLocal<Long> startTimeThreadLocal=new NamedThreadLocal<Long>("StartTime-EndTime");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        try {
            //记录开始时间
            startTimeThreadLocal.set(System.currentTimeMillis());
            String uri = request.getRequestURI();
            logger.info("uri : {} ,param : {}", uri,request.getParameterMap().toString());
            return true;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

}
