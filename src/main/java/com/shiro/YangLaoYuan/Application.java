package com.shiro.YangLaoYuan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @desc: springboot入口
 * 
 * @author: jwy
 * @date: 2017/12/15
 */
@MapperScan("com.shiro.YangLaoYuan.mapper")
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
