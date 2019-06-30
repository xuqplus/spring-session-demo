package com.github.xuqplus.springsessiondemosso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.core.annotation.Order;

@SpringBootApplication
@Order(SecurityProperties.BASIC_AUTH_ORDER)
public class SpringSessionDemoOauthServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringSessionDemoOauthServerApplication.class, args);
  }
}
