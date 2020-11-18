package com.eleverse.eleverse.controller;


import com.eleverse.eleverse.form.TubeInsertForm;
import com.eleverse.eleverse.form.TubeSelectForm;
import com.eleverse.eleverse.pojo.Tubes;
import com.eleverse.eleverse.service.ITubesService;
import com.eleverse.eleverse.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@Slf4j
public class TubesController {

    @Resource(name = "iTubesService")
    private ITubesService iTubesService;

    /*
    * 删除管
    * 更新所在盒占用情况
    * */
    @PostMapping("/DB/deleteTube")
    ResponseVo<Tubes> deleteByPrimaryKey(@Valid @RequestBody TubeSelectForm tubeSelectForm){
        Tubes tubes = new Tubes();
        BeanUtils.copyProperties(tubes,tubes);
        return iTubesService.deleteByPrimaryKey(tubes);
    }



      /*根据输入的信息，添加到数据库*/
    @PostMapping("/DB/addTube")
    ResponseVo<Tubes> insertSelective(@Valid @RequestBody TubeInsertForm record){
        Tubes tubes = new Tubes();
        BeanUtils.copyProperties(record,tubes);
        return iTubesService.insertSelective(tubes);
    }


    /*
    *  根据UID获取冻存管信息
    * */
    @PostMapping("/DB/getTubeByUID")
    ResponseVo<Tubes> selectByPrimaryKey(@Valid @RequestBody Tubes tubes){
        return iTubesService.selectByPrimaryKey(tubes);
    }


    /*
    * 根据内部ID获取信息
    * */
    @PostMapping("/DB/getTubeByInnerID")
    ResponseVo<Tubes> selectByTubeID(@Valid @RequestBody Tubes tubes){
        return  iTubesService.selectByTubeID(tubes);

    }

    /*
    *   根据姓名，获取其所在冻存管信息
    *
    * */
    @PostMapping("/DB/getSampleInfoByName")
    ResponseVo<Tubes> selectByPersonName(@Valid @RequestBody Tubes tubes){
        return iTubesService.selectByPersonName(tubes);

    }


}
