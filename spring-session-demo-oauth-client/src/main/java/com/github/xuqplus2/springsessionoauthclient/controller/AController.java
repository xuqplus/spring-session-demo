package com.github.xuqplus2.springsessionoauthclient.controller;

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
    return "all";
  }

  @GetMapping("aaa")
  public String aaa(HttpServletRequest request) {
    logger.info("oauth2, access_token=>{}", ((DefaultOAuth2ClientContext) request.getSession().getAttribute("scopedTarget.oauth2ClientContext")).getAccessToken());
    return String.format("aaa %s", ((DefaultOAuth2ClientContext) request.getSession().getAttribute("scopedTarget.oauth2ClientContext")).getAccessToken());
  }

  @GetMapping("bbb")
  public String bbb(HttpServletRequest request) {
    logger.info("oauth2, access_token=>{}", ((DefaultOAuth2ClientContext) request.getSession().getAttribute("scopedTarget.oauth2ClientContext")).getAccessToken());
    return String.format("bbb %s", ((DefaultOAuth2ClientContext) request.getSession().getAttribute("scopedTarget.oauth2ClientContext")).getAccessToken());
  }

  @GetMapping("admin")
  public String admin(HttpServletRequest request) {
    logger.info("oauth2, access_token=>{}", ((DefaultOAuth2ClientContext) request.getSession().getAttribute("scopedTarget.oauth2ClientContext")).getAccessToken());
    return String.format("admin %s", ((DefaultOAuth2ClientContext) request.getSession().getAttribute("scopedTarget.oauth2ClientContext")).getAccessToken());
  }

  @GetMapping("root")
  public String root(HttpServletRequest request) {
    logger.info("oauth2, access_token=>{}", ((DefaultOAuth2ClientContext) request.getSession().getAttribute("scopedTarget.oauth2ClientContext")).getAccessToken());
    return String.format("root %s", ((DefaultOAuth2ClientContext) request.getSession().getAttribute("scopedTarget.oauth2ClientContext")).getAccessToken());
  }

  @GetMapping("fff")
  public String fff(HttpServletRequest request) {
    logger.info("oauth2, access_token=>{}", ((DefaultOAuth2ClientContext) request.getSession().getAttribute("scopedTarget.oauth2ClientContext")).getAccessToken());
    return String.format("fff %s", ((DefaultOAuth2ClientContext) request.getSession().getAttribute("scopedTarget.oauth2ClientContext")).getAccessToken());
  }

//  打断点用到
//    org.springframework.web.client.HttpClientErrorException;
//    org.springframework.web.client.HttpServerErrorException;
}
