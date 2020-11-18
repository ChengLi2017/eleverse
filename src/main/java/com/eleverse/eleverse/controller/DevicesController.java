package com.eleverse.eleverse.controller;

import com.eleverse.eleverse.form.DevicesInsertForm;
import com.eleverse.eleverse.form.DevicesSelectByCoporationUsename;
import com.eleverse.eleverse.form.DevicesUIDForm;
import com.eleverse.eleverse.pojo.Devices;
import com.eleverse.eleverse.service.IDevicesService;
import com.eleverse.eleverse.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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

    // 根据用户所在公司，检索并返回所有该公司的冷冻设备
    @PostMapping("/DB/queryDevices")
    public ArrayList<HashMap> selectDevicesByCoporationUsename(@Valid @RequestBody DevicesSelectByCoporationUsename dsbcu) {
        log.info("username= {}"+dsbcu.getUsername());
        return  iDevicesService.selectDevicesByCoporationUsename(dsbcu.getUsername());
    }

    //根据用户输入的冷冻设备信息，添加设备到数据库
    @PostMapping("/DB/addDevice")
    public ResponseVo<Devices> insertDevices(@Valid @RequestBody DevicesInsertForm devicesInsertForm){
        Devices devices = new Devices();
        BeanUtils.copyProperties(devicesInsertForm,devices);
        return  iDevicesService.insertDevices(devices);
    }

    //根据设备UID获取冻存盒信息
    @PostMapping("/DB/queryBoxes")
    public ArrayList<HashMap> selectDevicesByUID(@Valid @RequestBody DevicesUIDForm devicesUIDForm){
        Devices devices = new Devices();
        BeanUtils.copyProperties(devicesUIDForm,devices);
        return iDevicesService.selectBoxesByUID(devices);
    }


    //删除设备--删除设备的盒子和盒子里的试管
    @PostMapping("/DB/deleteDevice")
    public ResponseVo<Devices> deleteDevices(@Valid @RequestBody DevicesUIDForm devicesUIDForm){
            Devices devices = new Devices();
            BeanUtils.copyProperties(devicesUIDForm,devices);
            return iDevicesService.deleteDevices(devices);
    }

}
