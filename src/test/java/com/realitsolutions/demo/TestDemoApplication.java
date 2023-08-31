package com.realitsolutions.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.from(DemoApplication::main).with(TestDemoApplication.class).run(args);
	}

}
