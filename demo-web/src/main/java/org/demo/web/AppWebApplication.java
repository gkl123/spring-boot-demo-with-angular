package org.demo.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * spring boot starter
 *
 */
@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = {"org.demo.service", "org.demo.web", "org.demo.dao"})
@MapperScan(basePackages={"org.demo.dao.mapper"})
public class AppWebApplication{

	public static void main(String[] args) {

		SpringApplication.run(AppWebApplication.class, args);
	}

}
