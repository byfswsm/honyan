package com.qcby.hongyanfriendcircle.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qcby.hongyanfriendcircle.vo.InsertMomentsVo;
import com.qcby.hongyanfriendcircle.vo.MomentParamVo;
import com.qcby.hongyanfriendcircle.vo.ReturnMoments;
import com.qcby.hongyanfriendcircle.service.*;
import com.qcby.hongyanfriendcircle.util.JwtUtil;
import com.qcby.hongyanfriendcircle.util.PageList;
import com.qcby.hongyanfriendcircle.common.constant.GlobalConstant;
import com.qcby.hongyanfriendcircle.common.web.ResultJson;
import com.qcby.hongyanfriendcircle.entity.Moments;
import com.qcby.hongyanfriendcircle.mapper.MomentsMapper;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * @ProjectName: ppq
 * @Package: com.bwfw.ppq.service.impl
 * @ClassName: LoginServiceImpl
 * @Author: zxh
 * @Description: 登录实现类
 * @Date: 2021/12/28 22:45
 * @Version: 1.0
 */
@Service
public class MomentsServiceImpl extends ServiceImpl<MomentsMapper, Moments> implements MomentsService {

    private HttpServletRequest request;

    @Autowired
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Resource
    @Lazy
    private RefFabulousService refFabulousService;

    @Resource
    private NoticeService noticeService;

    @Resource
    private CommentService commentService;

    @Resource
    private RefShieldService refShieldService;

    @Resource
    private RefAllowService refAllowService;

    @Resource
    private RefAddressService refAddressService;

    @Resource
    private RestHighLevelClient restHighLevelClient;


    @Override
    public ResultJson ownMoments(PageList<Moments> momentsPageList) {
        Page<Moments> page = momentsPageList.getPage();
        String token = request.getHeader("token");
        Long id = Long.parseLong(JwtUtil.getAudience(token));
        return ResultJson.ok(this.baseMapper.ownMoments(page, id));
    }

    @Override
    public ResultJson otherMoments(PageList<Long> momentsPageList) {
        Page<Moments> page=new Page<>(momentsPageList.getPageIndex(),momentsPageList.getPageSize());
        MomentParamVo param=new MomentParamVo();
        String token = request.getHeader("token");
        Long id = Long.parseLong(JwtUtil.getAudience(token));
        param.setId(id);
        param.setNowTime(LocalDateTime.now());
        param.setUserId(momentsPageList.getObj());
        return ResultJson.ok(this.baseMapper.otherMoments(page,param));
    }

    @Override
    public boolean deleteMoment(Long momentsId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("moments_id", momentsId);
        //删除点赞
        boolean refFabulous = refFabulousService.removeByMap(map);
        // 删除通知
        boolean notice = noticeService.removeByMap(map);
        // 删除评论
        boolean comment = commentService.removeByMap(map);
        //删除屏蔽关系
        boolean shield = refShieldService.removeByMap(map);
        //删除只允许查看
        boolean allow = refAllowService.removeByMap(map);
        //删除视图关联表
        boolean address = refAddressService.removeByMap(map);
        //修改朋友圈状态
        Moments moments1 = new Moments();
        moments1.setId(momentsId);
        moments1.setState(GlobalConstant.MOMENTS_DELETE_STATE);
        boolean moments = this.updateById(moments1);
        return refFabulous & notice & comment & shield & allow & address & moments;
    }

    @Override
    public ResultJson selectMoments(PageList<Moments> momentsPageList) {
        String token = request.getHeader("token");
        Long id = Long.parseLong(JwtUtil.getAudience(token));
        Page<Moments> page = momentsPageList.getPage();
        MomentParamVo momentParamVo = new MomentParamVo();
        momentParamVo.setNowTime(LocalDateTime.now());
        momentParamVo.setId(id);
        return ResultJson.ok(this.baseMapper.selectMoments(page, momentParamVo));
    }

    @Override
    @Transactional
    public ResultJson insertMoments(InsertMomentsVo insertMomentsVo) {
        LocalDateTime now = LocalDateTime.now();
        Moments moments = new Moments();
        if(insertMomentsVo.getVisibleTime()==null){
            moments.setVisibleTime(LocalDateTime.now().plusYears(50));
        } else {
            moments.setVisibleTime(LocalDateTime.now().plusDays(insertMomentsVo.getVisibleTime()));
        }
        moments.setUpdateTime(now);
        moments.setCreateTime(now);
        moments.setState(insertMomentsVo.getState());
        moments.setContent(insertMomentsVo.getContent());
        moments.setUserId(insertMomentsVo.getUserId());
        moments.setPingstate(insertMomentsVo.getPingstate());
        if(this.save(moments)){
            IndexResponse index = null;
            IndexRequest indexRequest = new IndexRequest("moments");
            indexRequest
                    .id(moments.getId()+"")
                    .source("{\"userId\":"+ moments.getUserId() +",\"content\":\""+ moments.getContent() +"\",\"createTime\":\""+ now.toString() +"\"}", XContentType.JSON);
            try {
                index = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
            } catch (IOException e) {
                return ResultJson.error(e.getMessage());
            }
            return ResultJson.ok(index.status());
        }
        return ResultJson.error();

    }

    @Override
    public ResultJson changeMoments(Moments moments) {
        /*
        * moments中传入的是更新条件
        * */
        Boolean bol = false;
        if(moments.getId()!=null){
            UpdateWrapper<Moments> wrapper = new UpdateWrapper<>();
            wrapper.eq("id",moments.getId());
            if(moments.getContent()!=null){
                wrapper.set("content",moments.getContent());
            }
            if(moments.getVisibleTime()!=null){
                wrapper.set("visible_time",moments.getVisibleTime());
            }
            bol = this.update(wrapper);
        }
        return ResultJson.r(bol);
    }

    @Override
    public ResultJson SearchMoments(String obj) {
        SearchRequest searchRequest = new SearchRequest("moments");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.termQuery("content",obj));
        searchRequest.source(sourceBuilder);
        SearchResponse search = null;
        try {
            search = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            return ResultJson.error(e.getMessage());
        }
        ReturnMoments returnMoments = new ReturnMoments();
        returnMoments.setTotal(search.getHits().getTotalHits().value);
        System.out.println("总条数 = " + search.getHits().getTotalHits().value);
        SearchHit[] hits = search.getHits().getHits();
        HashMap<String,String> hashMap = new HashMap<>();
        for (SearchHit hit : hits) {
            String id = hit.getId();
            String sourceAsString = hit.getSourceAsString();
            hashMap.put(id,sourceAsString);
            System.out.println("id = "+id+" source = "+sourceAsString);
        }
        returnMoments.setHashMap(hashMap);
        return ResultJson.ok(returnMoments);
    }
}
