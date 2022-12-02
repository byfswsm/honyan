package com.qcby.hongyanchat.service;


import com.qcby.hongyanchat.model.Request;
import com.baomidou.mybatisplus.extension.service.IService;

public interface RequestService extends IService<Request> {
    int reject(Request request);
    int accept(Request request);
}
