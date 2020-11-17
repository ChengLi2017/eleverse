package com.eleverse.eleverse.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Devices {
    private String deviceuid;

    private Integer capacity;

    private String corporation;

    private Date createTime;

    private Date updateTime;

}