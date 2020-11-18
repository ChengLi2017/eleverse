package com.eleverse.eleverse.service.impl;

import com.eleverse.eleverse.dao.DevicesMapper;
import com.eleverse.eleverse.enums.ResponseEnum;
import com.eleverse.eleverse.pojo.Devices;
import com.eleverse.eleverse.service.IDevicesService;
import com.eleverse.eleverse.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public ResponseVo<Devices> insertDevices(Devices devices){

        int count = devicesMapper.selectUIDfromDevices(devices.getDeviceuid());
        if(count>0){
            return  ResponseVo.error(ResponseEnum.UID_ERROR);
        }
        int resultCount =  devicesMapper.insertSelective(devices);
        if (resultCount == 0) {
            return ResponseVo.error(ResponseEnum.ERROR);
        }
        return ResponseVo.success();

    }


    public Devices selectDevicesByUID(Devices devices){
            Devices result =  devicesMapper.selectByPrimaryKey(devices.getDeviceuid());
            return result;
        }

    @Override
    @Transactional
    //update/////////////////////////////////////////////////////////????
    public ResponseVo<Devices> deleteDevices(Devices devices) {
        //先查询设备下的所有盒子，盒子下的所有管，删除相应的管、盒子、设备
        String deviceuid = devices.getDeviceuid();
        if(devicesMapper.selectUIDfromDevices(deviceuid) > 0){
            ArrayList<String> boxes =  devicesMapper.selectBoxByDevicesUID(deviceuid);
            if(boxes.size()>0){//设备中有盒子
                for(String tmp:boxes) {
                    //查询盒子里的试管
                    int counttubes = devicesMapper.selectTubesByBoxUID(tmp);
                    if(counttubes>0){
                        //删除盒子里的所有试管
                        devicesMapper.deleteTubesByBoxUID(tmp);
                    }
                }
                devicesMapper.deleteBoxesByDeviceUID(deviceuid);
            }
            int deleteDevices = devicesMapper.deleteByPrimaryKey(deviceuid);
            if(deleteDevices > 0){
                return ResponseVo.success();
            }else{
                return ResponseVo.error(ResponseEnum.ERROR);
            }
        }else{
            return ResponseVo.error(ResponseEnum.UID_NOEXIST);
        }

    }

    @Override
    public ArrayList<HashMap> selectBoxesByUID(Devices devices) {
        return devicesMapper.selectBoxesByDevicesUID(devices.getDeviceuid());
    }



}
