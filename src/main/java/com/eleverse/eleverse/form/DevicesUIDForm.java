package com.eleverse.eleverse.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class DevicesUIDForm {

    @NotBlank
    private String deviceuid;
}
