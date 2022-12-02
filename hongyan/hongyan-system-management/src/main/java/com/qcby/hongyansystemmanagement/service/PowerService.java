package com.qcby.hongyansystemmanagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qcby.hongyansystemmanagement.entity.Power;

public interface PowerService extends IService<Power> {
    Object delete(Long pid);
    void update(Long pid, String powername);
}
