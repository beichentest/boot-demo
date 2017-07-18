package com.hys.boot.provider.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement  //事务
@SpringBootApplication   
@EnableCaching                           //缓存
@MapperScan(basePackages = "com.hys.boot.provider.mapper")  
@ServletComponentScan(basePackages = "com.hys.boot.provider.filter")  //过滤器
@ComponentScan(basePackages = {"com.hys.boot.provider.conf","com.hys.boot.provider.serviceImpl"})
public class Application {

	public static void main(String[] args) {		
		SpringApplication.run(Application.class, args);
	}
}