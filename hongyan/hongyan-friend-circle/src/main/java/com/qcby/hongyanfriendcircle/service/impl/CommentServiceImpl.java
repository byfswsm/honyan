package com.qcby.hongyanfriendcircle.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qcby.hongyanfriendcircle.common.constant.GlobalConstant;
import com.qcby.hongyanfriendcircle.entity.Comment;
import com.qcby.hongyanfriendcircle.entity.Notice;
import com.qcby.hongyanfriendcircle.mapper.CommentMapper;
import com.qcby.hongyanfriendcircle.service.CommentService;
import com.qcby.hongyanfriendcircle.service.NoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * @ProjectName: ppq
 * @Package: com.bwfw.ppq.service.impl
 * @ClassName: LoginServiceImpl
 * @Author: zxh
 * @Description: 登录实现类
 * @Date: 2021/12/28 22:45
 * @Version: 1.0
 */
@Transactional
@Slf4j
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    NoticeService noticeService;


    @Override
    public boolean insertOne(Comment comment, Long id) {
        comment.setUserId(id);
        comment.setCreateTime(LocalDateTime.now());
        Notice notice=new Notice();
        notice.setContent(GlobalConstant.COMMENT);
        notice.setCreateTime(LocalDateTime.now());
        notice.setUserId(id);
        notice.setUserToId(comment.getToId());
        notice.setMomentsId(comment.getMomentsId());
        noticeService.addNotice(notice);
        boolean re= this.save(comment);
        return re;
    }
}
