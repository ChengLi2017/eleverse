package com.eleverse.eleverse.service.impl;

import com.eleverse.eleverse.dao.TubesMapper;
import com.eleverse.eleverse.enums.ResponseEnum;
import com.eleverse.eleverse.pojo.Tubes;
import com.eleverse.eleverse.service.ITubesService;
import com.eleverse.eleverse.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("iTubesService")
@Slf4j
public class TubesServiceImpl implements ITubesService {

    @Autowired()
    @Qualifier(value = "tubesMapper")
    private TubesMapper tubesMapper;

    @Override
    public ResponseVo<Tubes> selectByPersonName(Tubes tubes) {
        Tubes tube = tubesMapper.selectByPersonName(tubes);
        if(tube != null){
            return ResponseVo.success(tube);
        }else{
            return ResponseVo.error(ResponseEnum.NONE_DATA);
        }
    }

    @Override
    @Transactional
    public ResponseVo<Tubes> deleteByPrimaryKey(Tubes tubes) {
        int count = tubesMapper.deleteByPrimaryKey(tubes);
        if(count > 0 ){
            tubesMapper.countUpdateBoxesDelete(tubes.getBoxuid());
            return ResponseVo.success();
        }else{
            return ResponseVo.error(ResponseEnum.UID_NOEXIST);
        }
    }

    @Override
    @Transactional
    public ResponseVo<Tubes> insertSelective(Tubes tube) {
        //判断UID是否重复
        if(tubesMapper.selectCountByPrimaryKey(tube.getTubeuid()) > 0){
            return ResponseVo.error(ResponseEnum.UID_ERROR);
        }
        //判断盒子容量是否够用
        int i = tubesMapper.selectCapacity(tube.getBoxuid());
        log.info(i+"");
        if(i < 1 ){
            return ResponseVo.error(ResponseEnum.CAPACITY_ERROR);
        }

        int count = tubesMapper.insertSelective(tube);
        if (count > 0 ){
            tubesMapper.countUpdateBoxes(tube.getBoxuid());
            return ResponseVo.success(tube);
        }else{
            return ResponseVo.error(ResponseEnum.ERROR);
        }

    }

    @Override
    public ResponseVo<Tubes> selectByPrimaryKey(Tubes tubes) {
        Tubes tub = tubesMapper.selectByPrimaryKey(tubes);
        if(tub != null){
            return ResponseVo.success(tub);
        }else{
            return ResponseVo.error(ResponseEnum.NONE_DATA);
        }
    }

    @Override
    public ResponseVo<Tubes> selectByTubeID(Tubes tubes) {
        Tubes tub = tubesMapper.selectByTubeID(tubes);
        if(tub != null){
            return ResponseVo.success(tub);
        }else{
            return ResponseVo.error(ResponseEnum.NONE_DATA);
        }
    }
}
