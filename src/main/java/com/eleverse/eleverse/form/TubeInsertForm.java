package com.eleverse.eleverse.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class TubeInsertForm {

    @NotBlank
    private String tubeuid;

    @NotBlank
    private String boxuid;

    @NotBlank
    private String tubeid;

    private Integer location;

    private String sampletype;

    private String sampletemperature;

    @NotBlank
    private String corporation;

    @NotBlank
    private String personname;

    private Date createTime;

    private Date updateTime;

}
