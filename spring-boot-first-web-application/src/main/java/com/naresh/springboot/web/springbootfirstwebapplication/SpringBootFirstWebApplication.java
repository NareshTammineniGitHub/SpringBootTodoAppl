package com.naresh.springboot.web.springbootfirstwebapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.naresh.springboot.web.controller"})
@ComponentScan(basePackages= {"com.naresh.springboot.web.service"})
@ComponentScan(basePackages= {"com.naresh.springboot.web.model"})
@ComponentScan(basePackages= {"com.naresh.springboot.web.security"})


public class SpringBootFirstWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFirstWebApplication.class, args);
		System.out.println("Run page................................");
	}
}
