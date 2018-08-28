package com.commons.util;

import java.io.*;
import java.net.URL;
import java.util.*;

public class PropertyUtil {

    private Properties properties = new ContextProperties();

    static class ContextProperties extends Properties{
        private static final long serialVersionUID = 7868044836445180895L;
        private final LinkedHashSet<Object> keys = new LinkedHashSet<Object>();

        public Enumeration<Object> keys() {
            return Collections.<Object>enumeration(keys);
        }

        public Object put(Object key, Object value) {
            keys.add(key);
            return super.put(key, value);
        }

        public Set<Object> keySet() {
            return keys;
        }

        public Set<String> stringPropertyNames() {
            Set<String> set = new LinkedHashSet<String>();
            for (Object key : this.keys) {
                set.add((String) key);
            }
            return set;
        }
    }

    public Set<Object> getKeysByFileName(String fileName){
        FileInputStream in = null;
        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader = null;
        try{
            URL basePath = PropertyUtil.class.getClassLoader().getResource("");
            String parentPath = new File(basePath.getPath()).getParent();
            System.out.println(parentPath + "/classes/" + fileName);
            in = new FileInputStream(parentPath + "/classes/" + fileName);
            inputStreamReader = new InputStreamReader(in,"GBK");
            bufferedReader = new BufferedReader(inputStreamReader);
            properties.load(bufferedReader);
            return properties.keySet();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("properties file read error...");
            return null;
        }finally {
            if( in != null ){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if( bufferedReader != null ){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if( inputStreamReader != null ){
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
