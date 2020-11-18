package com.eleverse.eleverse.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Tubes {
    private String tubeuid;

    private String boxuid;

    private String tubeid;

    private Integer location;

    private String sampletype;

    private String sampletemperature;

    private String personname;

    private Date createTime;

    private Date updateTime;

}