package com.service.impl;

import com.jpa.UserJPA;
import com.pojo.JefUser;
import com.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    UserJPA userDao;

    @Override
    public Map<String, Object> checkUserAccount(String account, String password) {
        Map<String, Object> returnMap = new HashMap<>();
        JefUser user =  userDao.findJefUserByAccount(account,password);
        returnMap.put("user",user);
        return returnMap;
    }
}
