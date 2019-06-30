package com.github.xuqplus.springsessiondemosso.config;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class WebSecurityConfigTest {

  @Test
  public void a() {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String encodedPassword = passwordEncoder.encode("123456".trim());
    System.out.println(encodedPassword);
  }
}