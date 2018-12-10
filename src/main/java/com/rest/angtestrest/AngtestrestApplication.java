package com.rest.angtestrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ComponentScan(basePackages={"com.rest.angtestrest.controller"})
public class AngtestrestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AngtestrestApplication.class, args);
    }
}
