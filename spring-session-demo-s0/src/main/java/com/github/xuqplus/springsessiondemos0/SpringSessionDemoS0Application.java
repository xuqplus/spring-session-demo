package com.github.xuqplus.springsessiondemos0;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.github.xuqplus"})
@EnableJpaRepositories(basePackages = {"com.github.xuqplus"})
@EntityScan({"com.github.xuqplus"})
public class SpringSessionDemoS0Application {

  public static void main(String[] args) {
    SpringApplication.run(SpringSessionDemoS0Application.class, args);
  }
}
