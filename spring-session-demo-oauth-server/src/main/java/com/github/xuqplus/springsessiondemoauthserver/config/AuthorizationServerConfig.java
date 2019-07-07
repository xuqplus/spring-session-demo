package com.github.xuqplus.springsessiondemoauthserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * http://localhost:20010/oauth/authorize?client_id=client&response_type=code&redirect_uri=http://localhost:20008/
 *
 * <p>Basic Y2xpZW50OnNlY3JldA==
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    // 使用内存存储OAuth客户端信息
    String secret = "secret";
    String noop = String.format("{noop}%s", secret);
    //    String bcrypt = String.format("{bcrypt}%s", new BCryptPasswordEncoder().encode(secret));
    //    String scrypt = String.format("{scrypt}%s", new SCryptPasswordEncoder().encode(secret));
    clients
            .inMemory()
            /** client */
            .withClient("client") //
            .secret(noop) //
            // .authorizedGrantTypes("authorization_code", "implicit", "refresh_token") //
            .authorizedGrantTypes(
                    "password", "authorization_code", "implicit", "refresh_token") // 测试方便起见打开password模式
            .resourceIds("resourceId") //
            .redirectUris(
                    "http://192.168.0.107:20001/login",
                    "http://localhost:20001/login",
                    "http://aaa.local:20001/login",
                    "http://bbb.local:20001/login",
                    "http://192.168.0.107:20002/login",
                    "http://localhost:20002/login",
                    "http://aaa.local:20002/login",
                    "http://bbb.local:20002/login",
                    "http://localhost:20008/"
            ) //
            .scopes("aaa", "bbb", "ccc", "ddd")

            /** client2 */
            .and()
            .withClient("client2") //
            .secret(noop) //
            // .authorizedGrantTypes("authorization_code", "implicit", "refresh_token") //
            .authorizedGrantTypes(
                    "password", "authorization_code", "implicit", "refresh_token") // 测试方便起见打开password模式
            .resourceIds("resourceId") //
            .redirectUris(
                    "http://192.168.0.107:20001/login",
                    "http://localhost:20001/login",
                    "http://aaa.local:20001/login",
                    "http://bbb.local:20001/login",
                    "http://192.168.0.107:20002/login",
                    "http://localhost:20002/login",
                    "http://aaa.local:20002/login",
                    "http://bbb.local:20002/login",
                    "http://localhost:20008/"
            ) //
            .scopes("aaa", "bbb", "ccc", "ddd");
  }

  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
    endpoints
            .tokenStore(tokenStore)
            .approvalStore(approvalStore)
            .authenticationManager(authenticationManager)
            .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
  }

  @Override
  public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
    security
            .allowFormAuthenticationForClients()
            .tokenKeyAccess("permitAll()")
            .checkTokenAccess("isAuthenticated()");
  }

  @Bean
  public TokenStore tokenStore() {
    return new InMemoryTokenStore();
  }

  @Bean
  public ApprovalStore approvalStore() {
    TokenApprovalStore store = new TokenApprovalStore();
    store.setTokenStore(tokenStore);
    return store;
  }

  //  @Bean
  //  PasswordEncoder passwordEncoder() {
  //    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  //  }

  @Autowired
  TokenStore tokenStore;

  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  ApprovalStore approvalStore;
}
