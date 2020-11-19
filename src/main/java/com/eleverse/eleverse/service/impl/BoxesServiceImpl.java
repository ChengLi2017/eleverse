package com.eleverse.eleverse.service.impl;

import com.eleverse.eleverse.dao.BoxesMapper;
import com.eleverse.eleverse.enums.ResponseEnum;
import com.eleverse.eleverse.pojo.Boxes;
import com.eleverse.eleverse.pojo.Tubes;
import com.eleverse.eleverse.service.IBoxesService;
import com.eleverse.eleverse.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Slf4j
@Service("boxesService")
public class BoxesServiceImpl implements IBoxesService {

    @Autowired
    @Qualifier("boxesMapper")
    private BoxesMapper boxesMapper;

    /*
    * 检索并返回所有该盒内的管
    * */
    @Override
    public ResponseVo<ArrayList<Tubes>> queryTubesByboxesUID(String boxuid) {
        ArrayList<Tubes> list = boxesMapper.selectTubesByBoxUID(boxuid);
        log.info(list.toString());
        if(list.size()>0){
            return ResponseVo.success(list);
        }else{
            return ResponseVo.error(ResponseEnum.NONE_DATA);
        }
    }

    @Override
    @Transactional
    //insert box data
    public ResponseVo<Boxes> insertBoxes(Boxes boxes) {
        //判断同公司UID是否重复
        if(boxesMapper.selectCountByBoxUID(boxes) > 0){
            return ResponseVo.error(ResponseEnum.UID_ERROR);
        }
        //判断同公司ID是否重复
        if(boxesMapper.selectCountByBoxID(boxes) > 0){
            return ResponseVo.error(ResponseEnum.ID_ERROR);
        }
        //判断容量是否够用
        Integer integer = boxesMapper.selectCapacity(boxes.getDeviceuid());
        if(integer == null){
            return ResponseVo.error(ResponseEnum.NONDEVICEUID);
        }
        if(integer != null && integer <1){
                return ResponseVo.error(ResponseEnum.CAPACITY_ERROR);
        }
        int count = boxesMapper.insertSelective(boxes);
        if (count > 0 ){
            boxesMapper.countUpdateDevices(boxes.getDeviceuid());
            return ResponseVo.success(boxes);
        }else{
            return ResponseVo.error(ResponseEnum.ERROR);
        }
    }

    @Override
    @Transactional
    public ResponseVo<Boxes> deleteBoxesByBoxUID(Boxes boxes) {
        String boxuid = boxes.getBoxuid();
        //更新设备里的占用数量
        boxesMapper.delUpdateDevices(boxuid);
        //删除设备信息前更新设备占用量
            int count = boxesMapper.deleteByPrimaryKey(boxuid);
            if(count > 0 ){
                //删除设备盒子里的管
                boxesMapper.deleteTubesByBoxUID(boxuid);
                return ResponseVo.success();
            }else{
                return  ResponseVo.error(ResponseEnum.NONE_DATA);
            }
    }

    @Override
    public ResponseVo<Boxes> selectByBoxid(String boxid){
        Boxes boxes = boxesMapper.selectByBoxID(boxid);
        if (boxes != null){
            return ResponseVo.success(boxes);
        }else{
            return ResponseVo.error(ResponseEnum.NONE_DATA);
        }
    }

    @Override
    public ResponseVo<Boxes> selectByBoxuid(String boxuid) {
        Boxes boxes = boxesMapper.selectByBoxUID(boxuid);
        if (boxes != null){
            return ResponseVo.success(boxes);
        }else{
            return ResponseVo.error(ResponseEnum.NONE_DATA);
        }
    }

}
