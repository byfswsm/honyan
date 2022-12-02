package com.qcby.hongyanfriendcircle.controller;

import com.qcby.hongyanfriendcircle.service.NoticeService;
import com.qcby.hongyanfriendcircle.util.PageList;
import com.qcby.hongyanfriendcircle.common.web.ResultJson;
import com.qcby.hongyanfriendcircle.entity.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("notice")
public class noticeController {

    private NoticeService noticeService;

    @Autowired
    public void setNoticeService(NoticeService noticeService) {
        this.noticeService = noticeService;
    }


    @RequestMapping("noticeList")
    public ResultJson noticeList(@RequestBody PageList<Notice> pageList){
        return ResultJson.ok(noticeService.noticeList(pageList));
    }

    @RequestMapping("selectNotice")
    public ResultJson selectNotice(@RequestBody PageList<Notice> pageList){
        return ResultJson.ok(noticeService.selectNotice(pageList));
    }

}
