package org.demo.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Hello world!
 *
 */
@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)
@MapperScan(basePackages={"org.demo.goods.dao.mapper"})
public class App {
    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }
}
