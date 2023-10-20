package com.github.javabaz.springexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.github.javabaz.springexample.entity")
@EnableJpaRepositories(basePackages = {"com.github.javabaz.springexample.repository"})
@EntityScan(basePackages = {"com.github.javabaz.springexample.entity"})
@SpringBootApplication
public class SpringExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringExampleApplication.class, args);
    }

}
