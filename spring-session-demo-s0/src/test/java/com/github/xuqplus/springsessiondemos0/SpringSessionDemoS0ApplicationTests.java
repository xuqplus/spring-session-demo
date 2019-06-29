package com.github.xuqplus.springsessiondemos0;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringSessionDemoS0ApplicationTests {

  protected Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  ApplicationContext context;

  @Test
  public void contextLoads() {
    logger.info("");
  }
}
