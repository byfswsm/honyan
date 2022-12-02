package com.qcby.hongyanfriendcircle.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qcby.hongyanfriendcircle.common.web.ResultJson;
import com.qcby.hongyanfriendcircle.entity.RefFabulous;

import java.util.List;

/**
 * @ProjectName: ppq
 * @Package: com.bwfw.ppq.service.impl
 * @ClassName: LoginService
 * @Author: zxh
 * @Description: 登录Service
 * @Date: 2021/12/28 22:44
 * @Version: 1.0
 */
public interface RefFabulousService extends IService<RefFabulous> {
    boolean delectFabulous(long userId,long momentsId);

    ResultJson addFabulous(Long momentsId);

    List<RefFabulous> selectFabulous(RefFabulous refFabulous);
}
