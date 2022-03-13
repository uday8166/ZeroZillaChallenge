package com.zz.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.zz.task")
@EnableJpaRepositories(basePackages = {"com.zz.task"})
public class JavaTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaTaskApplication.class, args);
	}

}
