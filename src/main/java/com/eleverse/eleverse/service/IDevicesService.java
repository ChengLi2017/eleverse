package com.eleverse.eleverse.service;

import java.util.ArrayList;
import java.util.HashMap;

public interface IDevicesService {

    /*
    *检索用户关联的公司下冷冻设备
    */
    ArrayList<HashMap> selectDevicesByCoporationUsename(String username);


}
