package com.hys.boot.consumer.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication   
@EnableCaching                           //缓存
@ServletComponentScan(basePackages = "com.hys.boot.consumer.filter")  //过滤器
@ComponentScan(basePackages = {"com.hys.boot.consumer"})
public class Application {

	public static void main(String[] args) {		
		SpringApplication.run(Application.class, args);
	}
}