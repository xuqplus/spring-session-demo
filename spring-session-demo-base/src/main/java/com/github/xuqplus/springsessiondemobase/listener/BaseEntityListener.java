package com.github.xuqplus.springsessiondemobase.listener;

import com.github.xuqplus.springsessiondemobase.entity.BaseEntity;

import javax.persistence.PreUpdate;
import java.util.Date;

public class BaseEntityListener {

  @PreUpdate
  public void preUpdate(BaseEntity baseEntity) {
    baseEntity.modifyAt = new Date(System.currentTimeMillis());
  }
}
