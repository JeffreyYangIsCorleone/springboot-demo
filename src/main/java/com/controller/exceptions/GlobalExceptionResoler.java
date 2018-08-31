package com.controller.exceptions;

import com.commons.exception.BusiException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionResoler {

    @ExceptionHandler(value = BusiException.class)
    @ResponseBody
    public Map<String, Object> handleBusiExceptions(BusiException e){
        e.printStackTrace();
        Map<String, Object> returnMap = new HashMap<String, Object>();
        Integer code = e.getCode();
        String msg = e.getMsg();
        returnMap.put("code",code);
        returnMap.put("msg",msg);
        return returnMap;
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map<String, Object> handleSysExceptions(Exception e){
        e.printStackTrace();
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put("code",2);
        returnMap.put("msg","系统错误");
        return returnMap;
    }
}
