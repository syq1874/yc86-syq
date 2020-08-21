package com.yc.S3SpringBoot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yc.S3SpringBoot.dao")
public class S3SpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(S3SpringBootApplication.class, args);
	}

}
