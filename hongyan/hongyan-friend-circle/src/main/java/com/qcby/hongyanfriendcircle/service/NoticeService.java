package com.qcby.hongyanfriendcircle.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qcby.hongyanfriendcircle.util.PageList;
import com.qcby.hongyanfriendcircle.entity.Notice;

/**
 * @ProjectName: ppq
 * @Package: com.bwfw.ppq.service.impl
 * @ClassName: LoginService
 * @Author: zxh
 * @Description: 登录Service
 * @Date: 2021/12/28 22:44
 * @Version: 1.0
 */
public interface NoticeService extends IService<Notice> {

    Page noticeList(PageList<Notice> pageList);

    Page selectNotice(PageList<Notice> pageList);

    Boolean addNotice(Notice notice);

}
