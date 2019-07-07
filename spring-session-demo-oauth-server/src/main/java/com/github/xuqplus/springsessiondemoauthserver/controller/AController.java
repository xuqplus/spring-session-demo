package com.github.xuqplus.springsessiondemoauthserver.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class AController {

  @GetMapping({"oauth/userInfo", "oauth/user_info"})
  public Map<String, String> user(HttpServletRequest request, Principal principal) {
    Map<String, String> map = new LinkedHashMap<>();

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    map.put("name", principal.getName());
    return map;
  }
}
