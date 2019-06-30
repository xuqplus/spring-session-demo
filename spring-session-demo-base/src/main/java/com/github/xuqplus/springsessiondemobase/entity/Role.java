package com.github.xuqplus.springsessiondemobase.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Role extends BaseEntity {

  @Column(unique = true)
  public String name;

  public Role() {
  }

  public Role(String name) {
    this.name = name;
  }
}
