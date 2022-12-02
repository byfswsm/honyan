package com.qcby.hongyanfriendcircle.controller;

import com.qcby.hongyanfriendcircle.vo.InsertMomentsVo;
import com.qcby.hongyanfriendcircle.util.PageList;
import com.qcby.hongyanfriendcircle.common.web.ResultJson;
import com.qcby.hongyanfriendcircle.entity.Moments;
import com.qcby.hongyanfriendcircle.service.MomentsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("moments")
public class momentsController {

    @Resource
    private MomentsService momentsService;


    @RequestMapping("ownMoments")
    public ResultJson ownMoments(@RequestBody PageList<Moments> pageList){
        return momentsService.ownMoments(pageList);
    }

    @RequestMapping("otherMoments")
    public ResultJson otherMoments(@RequestBody PageList<Long> pageList){
        return momentsService.otherMoments(pageList);
    }
    @ResponseBody
    @RequestMapping("deleteMoment")
    public ResultJson deleteMoment(@RequestBody Long momentsId){
        return ResultJson.ok(momentsService.deleteMoment(momentsId));
    }

    @RequestMapping("selectMoment")
    public ResultJson selectMoment(@RequestBody PageList<Moments> momentsPageList){
        return ResultJson.ok(momentsService.selectMoments(momentsPageList));
    }

    @RequestMapping("insertMoments")
    public ResultJson insertMoments(@RequestBody InsertMomentsVo insertMomentsVo){
        return ResultJson.ok(momentsService.insertMoments(insertMomentsVo));
    }

    @RequestMapping("changeMoments")
    public ResultJson changeMoments(@RequestBody Moments moments){
        return momentsService.changeMoments(moments);
    }

    @RequestMapping("SearchMoments")
    public ResultJson SearchMoments(@RequestBody String obj){
        return momentsService.SearchMoments(obj);
    }
}
