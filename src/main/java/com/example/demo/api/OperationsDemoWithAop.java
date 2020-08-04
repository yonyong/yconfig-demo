package com.example.demo.api;

import lombok.Data;
import org.springframework.stereotype.Component;
import top.yonyong.yconfig.config.aop.MyConfig;

/**
 * @author  yonyong
 **/
@Component
@Data
public class OperationsDemoWithAop {
    /**
     * use with aop，only for get. update,delete,add are same as use without aop
     */

    @MyConfig("opcl.url")
    private String url;

    @MyConfig(clazz = OperationsDemoWithAop.class)
    public void printUrl(){
        System.out.println(url);
    }
}
