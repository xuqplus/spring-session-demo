package com.github.xuqplus.springsessiondemoauthserver.controller.oauth.callback;

import com.alibaba.fastjson.JSON;
import com.github.xuqplus.springsessiondemoauthserver.config.OAuthApp;
import com.github.xuqplus.springsessiondemoauthserver.controller.oauth.token.GithubAccessToken;
import com.github.xuqplus.springsessiondemoauthserver.domain.GithubUserInfo;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.jaas.JaasAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collections;

@RestController
@RequestMapping("oauth/callback")
@Slf4j
public class OAuthCallbackController {

  @Autowired OAuthApp.GithubApp githubApp;

  @Autowired AuthenticationManager authenticationManager;

  private static final String TEMPLATE_OAUTH_ACCESS_TOKEN_URI_GITHUB =
      "https://github.com/login/oauth/access_token?client_id=%s&client_secret=%s&code=%s";
  private static final String TEMPLATE_OAUTH_USER_INFO_URI_GITHUB =
      "https://api.github.com/user?access_token=%s";

  @GetMapping("github")
  public String github(String code, String state, HttpServletRequest request) throws IOException {
    log.info("code=>{}, state=>{}", code, state);
    OkHttpClient okHttpClient = new OkHttpClient();
    Response response =
        okHttpClient
            .newCall(
                new Request.Builder()
                    .url(
                        String.format(
                            TEMPLATE_OAUTH_ACCESS_TOKEN_URI_GITHUB,
                            githubApp.getClientId(),
                            githubApp.getClientSecret(),
                            code))
                    .addHeader("accept", "application/json")
                    .build())
            .execute();
    GithubAccessToken githubAccessToken =
        JSON.parseObject(response.body().string(), GithubAccessToken.class);
    log.info("githubAccessToken=>{}", githubAccessToken);

    Response response1 =
        okHttpClient
            .newCall(
                new Request.Builder()
                    .url(
                        String.format(
                            TEMPLATE_OAUTH_USER_INFO_URI_GITHUB,
                            githubAccessToken.getAccess_token()))
                    .addHeader("accept", "application/json")
                    .build())
            .execute();
    GithubUserInfo githubUserInfo =
        JSON.parseObject(response1.body().string(), GithubUserInfo.class);
    log.info("githubUserInfo=>{}", githubUserInfo);

    /* 手动调用登录认证 */
    //    Authentication admin =
    //        authenticationManager.authenticate(
    //            new UsernamePasswordAuthenticationToken("admin", "123456"));
    //        SecurityContextHolder.getContext().setAuthentication(admin);

    /* 手动设置登录状态 */
    //    SimpleGrantedAuthority aaa = new SimpleGrantedAuthority("aaa");
    //    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
    //    authorities.add(aaa);
    //    SecurityContextHolder.getContext().setAuthentication(new
    //     UsernamePasswordAuthenticationToken("aaa", "aaa", authorities));

    /* 手动设置登录状态 jaas */
    JaasAuthenticationToken jaasAuthenticationToken =
        new JaasAuthenticationToken("aaa", "aaa", Collections.EMPTY_LIST, null);
    SecurityContextHolder.getContext().setAuthentication(jaasAuthenticationToken);

    /* 手动拿 WebApplicationContext */
    //    WebApplicationContext applicationContext =
    // WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
    return githubUserInfo.toString();
  }
}
