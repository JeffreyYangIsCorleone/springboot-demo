package com.controller.initListener;

import com.commons.model.StaticModel;
import com.commons.util.PropertyUtil;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class InitContainer implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadPropertiesByStrMap("system_menu.txt", StaticModel.menuList);
    }

    /**
     * 初始加载菜单文件
     * @param fileName
     * @param list
     */
    private void loadPropertiesByStrMap(String fileName, List<Object> list) {
        PropertyUtil prop = new PropertyUtil();
        Set<Object> keySet = prop.getKeysByFileName(fileName);
        for (Object str : keySet) {
            String key = str.toString();
            String[] arr = key.split(",");
            System.out.println(arr);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("code", arr[0]);
            map.put("name", arr[1]);
            if (arr.length == 4) {
                map.put("url", arr[2]);
                map.put("parent", arr[3].substring(2, arr[3].length()));
                list.add(map);
            } else if (arr.length == 3) {
                map.put("parent", arr[2].substring(2, arr[2].length()));
                list.add(map);
            } else {
                list.add(map);
                // map.put("sub", new ArrayList<Object>());
            }
        }
    }

    /*public static void main(String[] args) {
        loadPropertiesByStrMap("file/system_menu.txt", StaticModel.menuList);
    }*/
}
