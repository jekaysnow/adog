package vip.adog.config;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

public class CustomObjectMapper extends ObjectMapper {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public CustomObjectMapper() {

        this.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        // 设置输入时忽略JSON字符串中存在而Java对象实际没有的属性
        this.setConfig(this.getDeserializationConfig().without(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES));
        // 禁用空对象转换json校验
        this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        // 不转换未知参数
        this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 启用空字符串转为null对象
        // this.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT,true);
        // 设置不输出值为 null 的属性
        this.setSerializationInclusion(Include.NON_NULL);
        // 设置不输出值为 "" 的属性
        this.setSerializationInclusion(Include.NON_EMPTY);
    }
}