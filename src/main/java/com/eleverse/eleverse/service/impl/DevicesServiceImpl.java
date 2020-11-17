package com.eleverse.eleverse.service.impl;

import com.eleverse.eleverse.dao.DevicesMapper;
import com.eleverse.eleverse.service.IDevicesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service("devicesService")
@Slf4j
public class DevicesServiceImpl implements IDevicesService {

    @Autowired
    @Qualifier(value = "devicesMapper")
    private DevicesMapper devicesMapper;
    @Override
    public ArrayList<HashMap> selectDevicesByCoporationUsename(String username) {

        return devicesMapper.selectDevicesByCoporationUsename(username);
    }
}
