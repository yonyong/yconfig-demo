package com.example.demo.api;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.yonyong.yconfig.config.Config;
import top.yonyong.yconfig.config.DefaultYConfigHandlerFactory;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yonyong
 */

@Configuration
@ConditionalOnClass(DefaultYConfigHandlerFactory.class)
public class InitContainerDemo {

    /**
     * Initialization container example (initialization can only be done once)
     */

    @Resource
    private DefaultYConfigHandlerFactory defaultYConfigHandlerFactory;

    @Bean
    @ConditionalOnMissingBean(DefaultYConfigHandlerFactory.class)
    public void initConfig(){

        /**
         * 1. Query the configuration information, in dB or other ways at will. Save to list < config >
         */
        List<Config> list = new ArrayList<>();
        Config config = Config.builder().keyName("opcl.url").keyValue("localhost:8080/opcl2.0").build();
        Config config2 = Config.builder().keyName("3A.url").keyValue("localhost//3A.url").build();
        Config config3 = Config.builder().keyName("MDM.url").keyValue("localhost:8888/MDM").build();
        list.add(config);
        list.add(config2);
        list.add(config3);

        /**
         * 2. Put into the container
         */
        // For normal config
        //Way1.
        defaultYConfigHandlerFactory.setVals(list);

        //Way2.
        //defaultYConfigHandlerFactory.setV(list);
        //defaultYConfigHandlerFactory.commit();

        // For group
        defaultYConfigHandlerFactory.setGroup("TEST_ENV");
    }

}
