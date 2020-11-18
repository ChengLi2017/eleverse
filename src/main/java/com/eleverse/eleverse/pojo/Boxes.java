package com.eleverse.eleverse.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Boxes {

    private String boxuid;

    private String boxid;

    private String deviceuid;

    private String location;

    private Integer capacity;

    private Integer occupied;

    private Date createTime;

    private Date updateTime;

}