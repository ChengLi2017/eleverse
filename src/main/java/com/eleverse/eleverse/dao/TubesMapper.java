package com.eleverse.eleverse.dao;

import com.eleverse.eleverse.pojo.Tubes;

public interface TubesMapper {
    int deleteByPrimaryKey(Tubes tubes);

    int insert(Tubes record);

    int insertSelective(Tubes record);

    Tubes selectByPrimaryKey(Tubes tubes);

    int updateByPrimaryKeySelective(Tubes record);

    Tubes updateByPrimaryKey(Tubes record);

    Tubes selectByTubeID(Tubes tubes);

    Tubes selectByPersonName(Tubes tubes);

    int selectCountByPrimaryKey(String tubeuid);

    Integer selectCapacity(String boxuid);

    int countUpdateBoxes(String boxuid);

    void countUpdateBoxesDelete(String boxuid);

    int selectCountByTubeUID(Tubes tube);

    int selectCountByTubeID(Tubes tube);
}