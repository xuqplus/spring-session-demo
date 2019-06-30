//package com.github.xuqplus.springsessiondemosso.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//
//@Configuration
//@EnableResourceServer
//public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
//
//  @Autowired
//  TokenStore tokenStore;
//
//  @Override
//  public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//    resources
//            .tokenStore(tokenStore)
//            .resourceId("resourceId");
//  }
//
//  @Override
//  public void configure(HttpSecurity http) throws Exception {
//    http
//            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//            .and()
//            .requestMatchers()
//            .antMatchers("/user", "/res/**")
//            .and()
//            .authorizeRequests()
//            .antMatchers("/user", "/res/**")
//            .authenticated();
//  }
//}
