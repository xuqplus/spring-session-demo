package com.github.xuqplus.springsessiondemos1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class AController {
  Logger logger = LoggerFactory.getLogger(AController.class);

  @GetMapping("")
  public String a(HttpSession session) {
    logger.info("session.getId()=>{}", session.getId());
    return "ok, s1";
  }

  @GetMapping("getSession")
  public String getSession(HttpSession session, String k) {
    logger.info("session.getId()=>{}", session.getId());
    Object v = session.getAttribute(k);
    logger.info("getSession, k=>{}, v=>{}", k, v);
    return String.format("ok, s1, getSession, k=%s, v=%s", k, v);
  }
}
