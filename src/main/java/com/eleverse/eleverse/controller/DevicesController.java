package com.eleverse.eleverse.controller;

import com.eleverse.eleverse.form.DevicesSelectByCoporationUsename;
import com.eleverse.eleverse.service.IDevicesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
@Slf4j
public class DevicesController {

    @Resource(name = "devicesService")
    private IDevicesService iDevicesService;

    @PostMapping("/DB/queryDevices")
    public ArrayList<HashMap> selectDevicesByCoporationUsename(@Valid @RequestBody DevicesSelectByCoporationUsename dsbcu) {
        log.info("username= {}"+dsbcu.getUsername());
        return  iDevicesService.selectDevicesByCoporationUsename(dsbcu.getUsername());
    }

}
