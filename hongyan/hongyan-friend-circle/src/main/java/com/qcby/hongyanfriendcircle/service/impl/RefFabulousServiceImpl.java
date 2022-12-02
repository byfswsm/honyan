package com.qcby.hongyanfriendcircle.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qcby.hongyanfriendcircle.common.constant.GlobalConstant;
import com.qcby.hongyanfriendcircle.common.web.ResultJson;
import com.qcby.hongyanfriendcircle.service.NoticeService;
import com.qcby.hongyanfriendcircle.util.JwtUtil;
import com.qcby.hongyanfriendcircle.entity.Moments;
import com.qcby.hongyanfriendcircle.entity.Notice;
import com.qcby.hongyanfriendcircle.entity.RefFabulous;
import com.qcby.hongyanfriendcircle.entity.User;
import com.qcby.hongyanfriendcircle.mapper.RefFabulousMapper;
import com.qcby.hongyanfriendcircle.service.MomentsService;
import com.qcby.hongyanfriendcircle.service.RefFabulousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @ProjectName: ppq
 * @Package: com.bwfw.ppq.service.impl
 * @ClassName: LoginServiceImpl
 * @Author: zxh
 * @Description: 登录实现类
 * @Date: 2021/12/28 22:45
 * @Version: 1.0
 */
@Service
@Transactional
public class RefFabulousServiceImpl extends ServiceImpl<RefFabulousMapper, RefFabulous> implements RefFabulousService {

    @Resource
    RefFabulousMapper refFabulousMapper;

    @Resource
    @Lazy
    private MomentsService momentsService;

    @Resource
    private NoticeService noticeService;

    private HttpServletRequest request;

    @Autowired
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }


    @Override
    public boolean delectFabulous(long userId, long momentsId) {
        return refFabulousMapper.delectFabulous(userId,momentsId);
    }


    @Override
    public ResultJson addFabulous(Long momentsId) {

        String token = request.getHeader("token");
        User user = JwtUtil.getUser(token);
        RefFabulous fabulous = new RefFabulous();
        fabulous.setUserId(user.getId());
        fabulous.setMomentsId(momentsId);
        fabulous.setCreateTime(LocalDateTime.now());
        boolean re = this.refFabulousMapper.addFabulous(fabulous);
        Notice notice = new Notice();
        notice.setContent(GlobalConstant.FABULOUS);
        notice.setUserId(user.getId());
        notice.setMomentsId(momentsId);
        Moments moments = momentsService.getById(momentsId);
        notice.setUserToId(moments.getUserId());
        noticeService.addNotice(notice);
        return ResultJson.ok(re);
    }

    @Override
    public List<RefFabulous> selectFabulous(RefFabulous refFabulous) {
        return refFabulousMapper.selectFabulous(refFabulous);
    }
}
