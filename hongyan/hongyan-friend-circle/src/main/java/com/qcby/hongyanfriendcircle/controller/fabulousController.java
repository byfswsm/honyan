package com.qcby.hongyanfriendcircle.controller;
import com.qcby.hongyanfriendcircle.util.JwtUtil;
import com.qcby.hongyanfriendcircle.common.web.ResultJson;
import com.qcby.hongyanfriendcircle.entity.RefFabulous;
import com.qcby.hongyanfriendcircle.entity.User;
import com.qcby.hongyanfriendcircle.service.RefFabulousService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("fabulous")
@Slf4j
public class fabulousController {


    @Resource
    private RefFabulousService refFabulousService;

    private HttpServletRequest request;

    @Autowired
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    @RequestMapping("addFabulous")
    @ResponseBody
    public ResultJson addFabulous(@RequestBody Long momentsId){
        return refFabulousService.addFabulous(momentsId);
    }

    @RequestMapping("delectFabulous")
    @ResponseBody
    public ResultJson delectFabulous(@RequestBody Long momentsId){

        String token = request.getHeader("token");
        User user = JwtUtil.getUser(token);
        boolean re =  refFabulousService.delectFabulous(user.getId(),momentsId);
        return ResultJson.ok(re);

    }

    @RequestMapping("selectFabulous")
    @ResponseBody
    public ResultJson selectFabulous(@RequestBody Long momentsId){
        String token = request.getHeader("token");
        User user = JwtUtil.getUser(token);
        RefFabulous fabulous = new RefFabulous();
        fabulous.setUserId(user.getId());
        fabulous.setMomentsId(momentsId);
        List<RefFabulous> re = refFabulousService.selectFabulous(fabulous);
        return ResultJson.ok(re);
    }



}
