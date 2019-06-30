package com.github.xuqplus.springsessiondemos1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BController {

  @RequestMapping("all")
  public String all() {
    return "all";
  }

  @RequestMapping("anonymous")
  public String anonymous() {
    return "anonymous";
  }

  @RequestMapping("normal")
  public String normal() {
    return "normal";
  }

  @RequestMapping("admin")
  public String admin() {
    return "admin";
  }

  @RequestMapping("root")
  public String root() {
    return "root";
  }
}
