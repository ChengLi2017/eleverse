package com.eleverse.eleverse.controller;

import com.eleverse.eleverse.form.BoxesIDForm;
import com.eleverse.eleverse.form.BoxesInsertForm;
import com.eleverse.eleverse.form.BoxesUIDForm;
import com.eleverse.eleverse.pojo.Boxes;
import com.eleverse.eleverse.pojo.Tubes;
import com.eleverse.eleverse.service.impl.BoxesServiceImpl;
import com.eleverse.eleverse.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;

@Slf4j
@RestController
public class BoxesController {

    @Resource(name = "boxesService")
    private BoxesServiceImpl boxesService;

    //根据盒的UID返回盒内的管
    @PostMapping("/DB/queryTubes")
    public ResponseVo<ArrayList<Tubes>> queryTubesByboxesUID(@Valid @RequestBody Boxes boxes){

        return boxesService.queryTubesByboxesUID(boxes.getBoxuid());

    }

    //insert box
    @PostMapping("/DB/addBox")
    public ResponseVo<Boxes> insertBoxes(@Valid @RequestBody BoxesInsertForm boxesInsertForm){
        Boxes boxes = new Boxes();
        BeanUtils.copyProperties(boxesInsertForm,boxes);
        return boxesService.insertBoxes(boxes);

    }

    // delete box
    @PostMapping("/DB/deleteBox")
    public ResponseVo<Boxes> deleteBoxes(@Valid @RequestBody Boxes boxes){

        return boxesService.deleteBoxesByBoxUID(boxes);

    }

    // select box根据盒ID获取冻存盒信息
    @PostMapping("/DB/getBoxByInnerID")
    public ResponseVo<Boxes> selectByBoxid(@Valid @RequestBody BoxesIDForm boxesIDForm){
        return boxesService.selectByBoxid(boxesIDForm.getBoxid());
    }
    //根据设备UID获取冻存盒信息
    @PostMapping("/DB/getBoxByUID")
    public ResponseVo<Boxes> getBoxByUID(@Valid @RequestBody BoxesUIDForm boxesUIDForm){
        return boxesService.selectByBoxuid(boxesUIDForm.getBoxuid());
    }

}
