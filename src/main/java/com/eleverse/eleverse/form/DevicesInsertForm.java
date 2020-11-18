package com.eleverse.eleverse.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class DevicesInsertForm {

    @NotBlank
    private String deviceuid;

    private Integer capacity;

    private Integer occupied;

    @NotBlank
    private String corporation;

    private Date createTime;

}
