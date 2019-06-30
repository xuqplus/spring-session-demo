package com.github.xuqplus.springsessiondemos1.config;

import com.github.xuqplus.springsessiondemobase.service.MyAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
            .authorizeRequests()
            .antMatchers("/all").permitAll() // 全部(认证/未认证)
            .antMatchers("/index.html", "/anonymous").anonymous() // 未认证
            .antMatchers("/normal").hasRole("normal") // normal
            .antMatchers("/admin").hasRole("admin") // admin/normal
            .antMatchers("/root").hasRole("root") // root/admin/normal
            .anyRequest().authenticated() // 认证
            .and()
            .formLogin()
            .loginProcessingUrl("/loginProcessingUrl").permitAll()
            .and()
            //logout默认url为"/logout", spring security实现了默认登出行为
            .logout().permitAll()
            .and()
            //新版本spring security中, csrf默认是开启的
            .csrf().disable();
  }

//  @Autowired
//  MyAuthenticationProvider provider;

//  @Override
//  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    super.configure(auth);
//    auth.authenticationProvider(provider);
//  }

  @Autowired
  public void setProvider(MyAuthenticationProvider provider, AuthenticationManagerBuilder builder) {
    builder.authenticationProvider(provider);
  }
}
