package org.aousi.springboot.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class DemoApplication {

	@Configuration
	@MapperScan("org.aousi.springboot.demo.mapper")
	public class MyBatisConfig {
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
