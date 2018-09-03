package com.controller.ApiController;

import com.alibaba.druid.util.StringUtils;
import com.commons.exception.BusiException;
import com.commons.model.Code;
import com.service.ILoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@RequestMapping("/login")
@Controller
public class ApiLoginController {

    private Logger logger = LoggerFactory.getLogger(ApiLoginController.class);

    @Autowired
    ILoginService loginService;

    @RequestMapping("/check_login")
    @ResponseBody
    public void checkUserAccount(HttpServletResponse resp) throws IOException {
        resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.write("{\"status\":\"error\",\"msg\":\"尚未登录，请登录!\"}");
        out.flush();
        out.close();
    }

    @RequestMapping("/login")
    @ResponseBody
    public Map<String, Object> login(String account,String password){
        if( StringUtils.isEmpty(account) || StringUtils.isEmpty(password)){
            throw new BusiException(Code.PARAMS_ERROR,"参数为空");
        }
        return loginService.checkUserAccount(account,password);
    }

    @RequestMapping("/without_login")
    @ResponseBody
    public Map<String, Object> withoutLogin(){
        logger.info("拦截到用户没有登陆...");
        throw new BusiException(Code.WITHOUT_LOGIN,"请登陆");
    }
}
