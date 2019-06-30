package com.github.xuqplus.springsessiondemosso.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BController {

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

  @RequestMapping("all")
  public String all() {
    return "all";
  }

  @RequestMapping("/")
  public String a() {
    return "index";
  }
}
