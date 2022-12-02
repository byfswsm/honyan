package com.qcby.hongyanchat.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qcby.hongyanchat.model.Shield;
import com.qcby.hongyanchat.dao.ShieldDao;
import com.qcby.hongyanchat.service.ShieldService;
import org.springframework.stereotype.Service;

@Service
public class ShieldServiceImpl extends ServiceImpl<ShieldDao, Shield> implements ShieldService {
}
