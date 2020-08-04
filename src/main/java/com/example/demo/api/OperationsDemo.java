package com.example.demo.api;

import org.springframework.stereotype.Component;
import top.yonyong.yconfig.config.Config;
import top.yonyong.yconfig.config.ConfigContext;
import top.yonyong.yconfig.config.DefaultYConfigHandlerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author  yonyong
 **/
@Component
public class OperationsDemo {
    /**
     * use without aop
     */
    @Resource
    DefaultYConfigHandlerFactory defaultYConfigHandlerFactory;

    @Resource
    private ConfigContext applicationConfigContext;

    void get1(){
        //get all configs
        final List<Config> list = defaultYConfigHandlerFactory.get();

        //get group
        final String group = defaultYConfigHandlerFactory.getGroup();

        //get value by key
        final String value = defaultYConfigHandlerFactory.get("opcl.url");
    }

    void get2(){
        //get all configs
        final List<Config> vals = applicationConfigContext.getVals();

        //get group
        final String group = applicationConfigContext.getGroup();

        //get value by key
        final String value = applicationConfigContext.getValue("opcl.url");
    }

    void add(){
        // return key
        final String add = defaultYConfigHandlerFactory.add("opcl.url", "localhost:8080");
    }

    void delete(){
        // return key
        final String del = defaultYConfigHandlerFactory.del("opcl.url");
    }

    void update(){
        //return key
        final String set = defaultYConfigHandlerFactory.set("opcl.url", "localhost:8081");
    }
}
