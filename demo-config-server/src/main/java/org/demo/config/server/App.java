package org.demo.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;

/**
 * spring cloud config center
 *
 */
@Configuration
@EnableAutoConfiguration
//@EnableDiscoveryClient
@EnableConfigServer
public class App {
    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }
}
