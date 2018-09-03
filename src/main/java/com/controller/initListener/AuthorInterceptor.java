package com.controller.initListener;

import com.commons.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(AuthorInterceptor.class);

    private NamedThreadLocal<Long> startTimeThreadLocal=new NamedThreadLocal<Long>("StartTime-EndTime");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
//        response.setHeader("Access-Control-Allow-Origin","*");
//        response.setHeader("Access-Control-Allow-Methods", "*");
//        response.setHeader("Access-Control-Allow-Headers", "Content-Type,XFILENAME,XFILECATEGORY,XFILESIZE");
//        if (request.getMethod().equals("OPTIONS")) {
//            response.setStatus(200);
//            // hresp.setContentLength(0);
//            response.getWriter().write("OPTIONS returns OK");
//            return false;
//        }
        try {
            //记录开始时间
            startTimeThreadLocal.set(System.currentTimeMillis());
            String uri = request.getRequestURI();
            logger.info("uri : {} ,param : {}", uri, JsonUtil.toJson(request.getParameterMap()));
            return true;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

}
