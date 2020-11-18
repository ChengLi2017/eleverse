package com.eleverse.eleverse.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class BoxesInsertForm {

    @NotBlank
    private String boxuid;

    @NotBlank
    private String deviceuid;

    @NotBlank
    private String boxid;

    private Integer occupied;

    @NotBlank
    private String location;

    private Integer capacity;

    private Date createTime;

    private Date updateTime;
}
