package com.eleverse.eleverse.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String userid;

    private String username;

    private String corporation;

    private String password;

    private Date createTime;

    private Date updateTime;

}