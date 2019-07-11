package com.github.xuqplus.springsessiondemoauthserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class OAuthApp {

  /**
   * github oauth app
   */
  @Data
  @Component
  @ConfigurationProperties(prefix = "project.oauth.github")
  public static class GithubApp {
    private String clientId;
    private String clientSecret;
    private String redirectUri;
    private String scope;
  }
}
