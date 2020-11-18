package com.eleverse.eleverse.service;

import com.eleverse.eleverse.pojo.Tubes;
import com.eleverse.eleverse.vo.ResponseVo;

public interface ITubesService {

    ResponseVo<Tubes> selectByPersonName(Tubes tubes);

    ResponseVo<Tubes>  deleteByPrimaryKey(Tubes tubes);

    ResponseVo<Tubes>  insertSelective(Tubes record);

    ResponseVo<Tubes> selectByPrimaryKey(Tubes tubes);

    ResponseVo<Tubes> selectByTubeID(Tubes tubes);

}
