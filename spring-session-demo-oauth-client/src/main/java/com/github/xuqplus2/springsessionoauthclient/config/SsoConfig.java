package com.github.xuqplus2.springsessionoauthclient.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableOAuth2Sso
public class SsoConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
            .antMatcher("/**")
            .authorizeRequests()
            .antMatchers("/",
                    "/all",
                    "/login",
                    "/login**").permitAll()
            .antMatchers("/admin").hasRole("admin")
            .antMatchers("/root").hasRole("root")
//            .antMatchers("/aaa").access("#oauth2.hasScope('aaa')")
            .antMatchers("/bbb")
//            .access("#oauth2.hasScope(\"bbb\")")
            .access("#oauth2.hasScope('bbb') and hasRole('admin')") // scope 和 role 检查, case sensitive 区分大小写
            .anyRequest().authenticated()
            .and().logout().permitAll()
            .and().csrf().disable();
  }
}
