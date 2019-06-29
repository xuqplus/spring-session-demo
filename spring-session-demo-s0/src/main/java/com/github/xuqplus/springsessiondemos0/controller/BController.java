package com.github.xuqplus.springsessiondemos0.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BController {
  @RequestMapping("login")
  public String login() {

    return "login";
  }
}
