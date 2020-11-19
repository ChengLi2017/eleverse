package com.eleverse.eleverse.dao;

import com.eleverse.eleverse.pojo.Boxes;
import com.eleverse.eleverse.pojo.Tubes;

import javax.swing.*;
import java.util.ArrayList;

public interface BoxesMapper {
    int deleteByPrimaryKey(String boxuid);

    int insert(Boxes record);

    int insertSelective(Boxes record);

    Boxes selectByPrimaryKey(String boxuid);

    int updateByPrimaryKeySelective(Boxes record);

    int updateByPrimaryKey(Boxes record);

    ArrayList<Tubes> selectTubesByBoxUID(String boxuid);

    int selectCountByBoxUID(Boxes boxes);

    int selectCountByBoxID(Boxes boxes);

    Integer selectCapacity(String deviceuid);

    int countUpdateDevices(String deviceuid);

    int delUpdateDevices(String deviceuid);

    int deleteTubesByBoxUID(String boxuid);

    Boxes selectByBoxID(String boxid);

    Boxes selectByBoxUID(String boxuid);
}