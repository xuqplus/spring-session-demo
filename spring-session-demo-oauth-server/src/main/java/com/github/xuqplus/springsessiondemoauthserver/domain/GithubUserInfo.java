package com.github.xuqplus.springsessiondemoauthserver.domain;

import lombok.Data;

import java.util.Date;

@Data
public class GithubUserInfo {
  private String login;
  private Long id;
  private String node_id;
  private String type;
  private Boolean site_admin;
  private String name;
  private String company;
  private String blog;
  private String location;
  private String email;
  private String hireable;
  private String bio;
  private Integer public_repos;
  private Integer public_gists;
  private Integer followers;
  private Integer following;
  private Date created_at;
  private Date updated_at;
}
