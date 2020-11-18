package com.eleverse.eleverse.service;

import com.eleverse.eleverse.pojo.Boxes;
import com.eleverse.eleverse.pojo.Tubes;
import com.eleverse.eleverse.vo.ResponseVo;


import java.util.ArrayList;

public interface IBoxesService {

    ResponseVo<ArrayList<Tubes>> queryTubesByboxesUID(String boxuid);

    ResponseVo<Boxes> insertBoxes(Boxes boxes);

    ResponseVo<Boxes> deleteBoxesByBoxUID(Boxes boxes);

    ResponseVo<Boxes> selectByBoxid(String boxid);

    ResponseVo<Boxes> selectByBoxuid(String boxuid);

}
