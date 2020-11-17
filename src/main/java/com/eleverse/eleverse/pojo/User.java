package com.eleverse.eleverse.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class User {
    private String userid;

    private String dataid;

    private String username;

    private String password;

    private Integer version;

    private String ylzd;

    private Date createTime;

    private Date updateTime;

}