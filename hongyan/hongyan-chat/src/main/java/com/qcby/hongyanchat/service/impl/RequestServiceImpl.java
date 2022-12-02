package com.qcby.hongyanchat.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qcby.hongyanchat.model.Friend;
import com.qcby.hongyanchat.model.Request;
import com.qcby.hongyanchat.dao.RequestDao;
import com.qcby.hongyanchat.service.FriendService;
import com.qcby.hongyanchat.service.RequestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RequestServiceImpl extends ServiceImpl<RequestDao, Request> implements RequestService {
    @Resource
    private RequestDao requestDao;

    @Resource
    private FriendService friendService;

    @Override
    public int reject(Request request) {
         return requestDao.deleteById(request.getId());
    }

    @Override
    public int accept(Request request) {
        int x = requestDao.deleteById(request.getId());
        boolean y = false;
        if(x == 1){
            Friend friend = new Friend(request.getUserId(), request.getRequestId());
            y = friendService.save(friend);
        }
        if(y) return 1;
        else return 0;
    }
}
