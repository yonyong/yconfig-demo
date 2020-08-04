package com.example.demo.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yonyong.yconfig.config.ConfigContext;
import top.yonyong.yconfig.config.aop.MyConfig;

import javax.annotation.Resource;

/**
 * @author  yonyong
 **/
@RestController
@RequestMapping("/test")
@Data
public class TestController {

    @Resource
    ConfigContext applicationConfigContext;


    @MyConfig("opcl.url")
    String url;

    @GetMapping("/111")
    public Object get111(){
        return "suc";
    }

    @MyConfig(clazz = TestController.class)
    @GetMapping("1")
    public Object test(){
        return "val:" + url;
    }

    @GetMapping("set")
    public Object set(){
        return "SUC";
    }

    @GetMapping("get")
    public Object get(){
        final String group = applicationConfigContext.getGroup();
        return group;
    }

    @GetMapping("getval/{val}")
    public Object getVal(@PathVariable String val){
        final String group = applicationConfigContext.getValue(val);
        return group;
    }
}
