package com.controller.initListener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InitContainer implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

    }

    /**
     * 初始加载菜单文件
     * @param fileName
     * @param list
     */
    private void loadPropertiesByStrMap(String fileName, List<Object> list) {

    }
}
