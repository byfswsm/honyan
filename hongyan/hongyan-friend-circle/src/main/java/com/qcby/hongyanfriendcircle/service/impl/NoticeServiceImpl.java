package com.qcby.hongyanfriendcircle.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qcby.hongyanfriendcircle.util.JwtUtil;
import com.qcby.hongyanfriendcircle.util.PageList;
import com.qcby.hongyanfriendcircle.common.constant.GlobalConstant;
import com.qcby.hongyanfriendcircle.entity.Notice;
import com.qcby.hongyanfriendcircle.mapper.NoticeMapper;
import com.qcby.hongyanfriendcircle.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashSet;
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
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {

    private HttpServletRequest request;

    @Autowired
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public Page noticeList(PageList<Notice> pageList) {
        Page<Notice> page = pageList.getPage();
        String token = request.getHeader("token");
        Long id = Long.parseLong(JwtUtil.getAudience(token));
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("to_id",id);
        return this.page(page,wrapper);
    }

    @Override
    @Transactional
    public Page selectNotice(PageList<Notice> pageList) {
        Page<Notice> page = pageList.getPage();
        String token = request.getHeader("token");
        Long id = Long.parseLong(JwtUtil.getAudience(token));
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("to_id",id);
        wrapper.eq("state", GlobalConstant.NOTVIEWED);
        Page res = this.page(page, wrapper);
        this.UpdateState(id);
        return res;
    }

    private boolean UpdateState(Long id) {
        UpdateWrapper<Notice> updateWrapper = new UpdateWrapper();
        updateWrapper.eq("to_id",id);
        updateWrapper.set("state",0);
        return this.update(updateWrapper);
    }

    @Override
    @Transactional
    public Boolean addNotice(Notice notice) {
        /*操作者和被操作者的共同好友，且这个好友给被操作者点赞*/
        QueryWrapper<Notice> wrapper = new QueryWrapper<>();
        Long momentsId = notice.getMomentsId();
        wrapper.eq("moments_id",momentsId);
        List<Notice> list = this.list(wrapper);
        HashSet<Long> set = new HashSet<>();
        for (Notice iter : list) {
            Long userId = iter.getUserId();
            Long toId = iter.getUserToId();
            set.add(userId);
            set.add(toId);
        }
        notice.setState(GlobalConstant.NOTVIEWED);
        notice.setCreateTime(LocalDateTime.now());
        for (Long iter : set) {
            notice.setToId(iter);
            this.save(notice);
        }
        return true;
    }
}
