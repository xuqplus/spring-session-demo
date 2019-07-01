package com.github.xuqplus.springsessiondemooauthresourceserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

  @Bean
  @Primary
  public RemoteTokenServices tokenServices() {
    String secret = "secret";
    String noop = String.format("{noop}%s", secret);

    final RemoteTokenServices tokenService = new RemoteTokenServices();
    tokenService.setCheckTokenEndpointUrl("http://localhost:20010/oauth/check_token");
    tokenService.setClientId("client");
    tokenService.setClientSecret(secret);
    return tokenService;
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
        .and()
        .authorizeRequests()
        .antMatchers("/aaa", "/aaa/")
        .hasRole("root") // role 检查, case sensitive 区分大小写
        .antMatchers("/bbb", "/bbb/")
        .access("#oauth2.hasScope('bbb') and hasRole('admin')") // scope 和 role 检查, case sensitive 区分大小写
        .antMatchers("/ccc", "/ccc/")
        .hasAuthority("ROLE_normal") // 授权检查, case sensitive 区分大小写
        .anyRequest()
        .authenticated();
  }

  @Override
  public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
    super.configure(resources);
    resources.resourceId("resourceId"); // 默认: oauth2-resource
  }
}
