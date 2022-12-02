package com.qcby.hongyanfriendcircle.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qcby.hongyanfriendcircle.vo.MomentParamVo;
import com.qcby.hongyanfriendcircle.vo.MomentsVO;
import com.qcby.hongyanfriendcircle.entity.Moments;
import org.apache.ibatis.annotations.Param;

/**
 * @ProjectName: ppq
 * @Package: com.bwfw.ppq.mapper
 * @ClassName: LoginMapper
 * @Author: zxh
 * @Description: 登录Mapper
 * @Date: 2021/12/28 22:43
 * @Version: 1.0
 */
public interface MomentsMapper extends BaseMapper<Moments> {

    IPage<MomentsVO> ownMoments(Page<Moments> page, @Param("id") Long id);

    IPage<MomentsVO> otherMoments(Page<Moments> page, @Param("momentParamVo") MomentParamVo momentParamVo);

    IPage<MomentsVO> selectMoments(Page<Moments> page,@Param("momentParamVo") MomentParamVo momentParamVo);

}
