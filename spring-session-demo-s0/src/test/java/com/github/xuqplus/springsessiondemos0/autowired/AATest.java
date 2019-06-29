package com.github.xuqplus.springsessiondemos0.autowired;

import com.github.xuqplus.springsessiondemos0.SpringSessionDemoS0ApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AATest extends SpringSessionDemoS0ApplicationTests {

  @Autowired
  AA aa;

  @Test
  public void aa() {
    logger.info("");
  }
}
