package com.github.xuqplus2.springsessiondemooauthclient2.config;

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
            .anyRequest().authenticated()
            .and().logout().permitAll()
            .and().csrf().disable();
  }
}
