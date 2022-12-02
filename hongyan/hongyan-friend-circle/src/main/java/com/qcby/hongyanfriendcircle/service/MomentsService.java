package com.qcby.hongyanfriendcircle.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.qcby.hongyanfriendcircle.vo.InsertMomentsVo;
import com.qcby.hongyanfriendcircle.common.web.ResultJson;
import com.qcby.hongyanfriendcircle.util.PageList;
import com.qcby.hongyanfriendcircle.entity.Moments;


/**
 * @ProjectName: ppq
 * @Package: com.bwfw.ppq.service.impl
 * @ClassName: LoginService
 * @Author: zxh
 * @Description: 登录Service
 * @Date: 2021/12/28 22:44
 * @Version: 1.0
 */
public interface MomentsService extends IService<Moments> {

    ResultJson ownMoments(PageList<Moments> momentsPageList);

    ResultJson otherMoments(PageList<Long> momentsPageList);

    boolean deleteMoment(Long momentsId);

    ResultJson selectMoments(PageList<Moments> momentsPageList);

    ResultJson insertMoments(InsertMomentsVo insertMomentsVo);

    ResultJson changeMoments(Moments moments);

    ResultJson SearchMoments(String obj);
}
