package com.eleverse.eleverse.service;

import com.eleverse.eleverse.pojo.Devices;
import com.eleverse.eleverse.vo.ResponseVo;

import java.util.ArrayList;
import java.util.HashMap;

public interface IDevicesService {

    /*
    *检索用户关联的公司下冷冻设备
    */
    ArrayList<HashMap> selectDevicesByCoporationUsename(String username);

    ResponseVo<Devices> insertDevices(Devices devices);

    Devices selectDevicesByUID(Devices devices);

    ResponseVo<Devices> deleteDevices(Devices devices);

    ArrayList<HashMap> selectBoxesByUID(Devices devices);

}
