package com.july.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
@MapperScan("com.july.admin.dao")
public class ReactAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactAdminServerApplication.class, args);
	}

}
