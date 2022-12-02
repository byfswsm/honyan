package com.qcby.hongyansystemmanagement.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qcby.hongyansystemmanagement.entity.Power ;
import com.qcby.hongyansystemmanagement.mapper.PowerMapper;
import com.qcby.hongyansystemmanagement.service.PowerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Mi
 * @version 1.0
 * @description: TODO
 * @date 2022/1/10 20:54
 */
@Service
public class PowerServiceImpl extends ServiceImpl<PowerMapper, Power> implements PowerService {
    @Resource
    private PowerMapper powerMapper;


    @Override
    public Object delete(Long pid) {

        return powerMapper.delete(pid);
    }

    @Override
    public void update(Long pid, String powername) {

         powerMapper.update(pid,powername);
    }
}
