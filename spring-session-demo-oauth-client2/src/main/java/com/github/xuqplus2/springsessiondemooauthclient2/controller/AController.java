package com.github.xuqplus2.springsessiondemooauthclient2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AController {

  private final Logger logger = LoggerFactory.getLogger(AController.class);

  @GetMapping("all")
  public String all() {
    return "client2 all";
  }

  @GetMapping("aaa")
  public String aaa(HttpServletRequest request) {
    logger.info("oauth2, access_token=>{}", ((DefaultOAuth2ClientContext) request.getSession().getAttribute("scopedTarget.oauth2ClientContext")).getAccessToken());
    return String.format("client2 aaa %s", ((DefaultOAuth2ClientContext) request.getSession().getAttribute("scopedTarget.oauth2ClientContext")).getAccessToken());
  }

  @GetMapping("bbb")
  public String bbb(HttpServletRequest request) {
    logger.info("oauth2, access_token=>{}", ((DefaultOAuth2ClientContext) request.getSession().getAttribute("scopedTarget.oauth2ClientContext")).getAccessToken());
    return String.format("client2 bbb %s", ((DefaultOAuth2ClientContext) request.getSession().getAttribute("scopedTarget.oauth2ClientContext")).getAccessToken());
  }
}
