package com.github.xuqplus.springsessiondemooauthresourceserver.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AController {

  @RequestMapping("")
  public String a() {
    String principal =
        (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    return String.format("index %s", principal);
  }

  @RequestMapping("aaa")
  public String aaa() {
    return "aaa";
  }

  @RequestMapping("bbb")
  public String bbb() {
    return "bbb";
  }

  @RequestMapping("ccc")
  public String ccc() {
    return "ccc";
  }
}
