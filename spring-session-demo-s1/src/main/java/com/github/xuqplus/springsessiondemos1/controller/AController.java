package com.github.xuqplus.springsessiondemos1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AController {
  @GetMapping("")
  public String a() {
    return "ok, s1";
  }
}
