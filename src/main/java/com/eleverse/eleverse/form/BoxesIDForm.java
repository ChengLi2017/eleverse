package com.eleverse.eleverse.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BoxesIDForm {

    @NotBlank
    private String boxid;
}
