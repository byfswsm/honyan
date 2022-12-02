package com.qcby.hongyanchat.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qcby.hongyanchat.model.Friend;
import com.qcby.hongyanchat.dao.FriendDao;
import com.qcby.hongyanchat.service.FriendService;
import org.springframework.stereotype.Service;

@Service
public class FriendServiceImpl extends ServiceImpl<FriendDao, Friend> implements FriendService{
}
