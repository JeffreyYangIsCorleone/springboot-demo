package com.controller.ApiController;

import com.alibaba.druid.util.StringUtils;
import com.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@RequestMapping("/login")
@Controller
public class ApiLoginController {

    @Autowired
    ILoginService loginService;

    @RequestMapping("/check_login")
    @ResponseBody
    public Map<String, Object> checkUserAccount(String account, String password){
        if(StringUtils.isEmpty(account) || StringUtils.isEmpty(password)){

        }
        return loginService.checkUserAccount(account,password);
    }
}
