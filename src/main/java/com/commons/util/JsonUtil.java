package com.commons.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

public class JsonUtil {

    private static final ObjectMapper mapper = new ObjectMapper();

    static{
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public static String toJson(Object bean){
        String json = null;
        JsonGenerator gen = null;
        StringWriter sw = new StringWriter();
        try{
            gen = new JsonFactory().createGenerator(sw);
            mapper.writeValue(gen,bean);
            json = sw.toString();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (gen != null) {
                    gen.close();
                }
                if (sw != null) {
                    sw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return json;
    }
}
