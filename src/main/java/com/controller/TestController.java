package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/demo/")
public class TestController {

    @RequestMapping("test")
    @ResponseBody
    public Map<String, Object> Method(){
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("success", true);
        return returnMap;
    }

    public static void main(String[] args) {
        URL resource = TestController.class.getClassLoader().getResource("");
        System.out.println(resource.getPath());
    }
}
