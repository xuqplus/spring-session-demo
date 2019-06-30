package com.github.xuqplus.springsessiondemobase.entity;

import com.github.xuqplus.springsessiondemobase.listener.BaseEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners(BaseEntityListener.class)
public abstract class BaseEntity implements Serializable {

  @Temporal(TemporalType.TIMESTAMP)
  public Date createAt = new Date(System.currentTimeMillis());
  @Temporal(TemporalType.TIMESTAMP)
  public Date modifyAt = new Date(System.currentTimeMillis());
  @Id
  @GeneratedValue
  public Long id;
  @Version
  public Integer version;
  public boolean isDeleted;
}
