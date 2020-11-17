package com.eleverse.eleverse.dao;

import com.eleverse.eleverse.pojo.Devices;

import java.util.ArrayList;
import java.util.HashMap;

public interface DevicesMapper {
    int deleteByPrimaryKey(String deviceuid);

    int insert(Devices record);

    int insertSelective(Devices record);

    Devices selectByPrimaryKey(String deviceuid);

    int updateByPrimaryKeySelective(Devices record);

    int updateByPrimaryKey(Devices record);

    ArrayList<HashMap> selectDevicesByCoporationUsename(String username);
}