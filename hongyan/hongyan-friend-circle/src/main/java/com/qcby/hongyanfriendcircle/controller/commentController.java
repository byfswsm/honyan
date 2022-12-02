package com.qcby.hongyanfriendcircle.controller;


import com.qcby.hongyanfriendcircle.util.JwtUtil;
import com.qcby.hongyanfriendcircle.common.web.ResultJson;
import com.qcby.hongyanfriendcircle.entity.Comment;
import com.qcby.hongyanfriendcircle.entity.User;
import com.qcby.hongyanfriendcircle.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("comment")
public class commentController {


    @Autowired
    HttpServletRequest httpServletRequest;

    @Autowired
    CommentService commentService;



    @RequestMapping("insertComment")
    public ResultJson insertComment(@RequestBody Comment comment){
        String token =httpServletRequest.getHeader("token");
        User user= JwtUtil.getUser(token);
        boolean re=commentService.insertOne(comment,user.getId());
        return ResultJson.r(re);
    }


    @RequestMapping("deleteComment")
    public ResultJson deleteComment(Long id){
        boolean re=commentService.removeById(id);
        return ResultJson.r(re);
    }
}
