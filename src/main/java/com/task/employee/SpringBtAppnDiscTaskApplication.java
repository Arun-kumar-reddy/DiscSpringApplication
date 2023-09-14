package com.task.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope

public class SpringBtAppnDiscTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBtAppnDiscTaskApplication.class, args);
	}

}
