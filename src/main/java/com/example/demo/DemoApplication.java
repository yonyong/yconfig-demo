package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.yonyong.yconfig.config.EnableYConfigAopConfiguration;
import top.yonyong.yconfig.config.EnableYConfigConfiguration;

/**
 * @author yonyong
 */
@SpringBootApplication
@EnableYConfigAopConfiguration
@EnableYConfigConfiguration
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
