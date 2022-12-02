package com.qcby.hongyanfriendcircle.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qcby.hongyanfriendcircle.entity.RefFabulous;

import java.util.List;

/**
 * @ProjectName: ppq
 * @Package: com.bwfw.ppq.mapper
 * @ClassName: LoginMapper
 * @Author: zxh
 * @Description: 登录Mapper
 * @Date: 2021/12/28 22:43
 * @Version: 1.0
 */
public interface RefFabulousMapper extends BaseMapper<RefFabulous> {

    boolean delectFabulous(long userId,long momentsId);
    boolean addFabulous(RefFabulous refFabulous);
    List<RefFabulous> selectFabulous(RefFabulous refFabulous);
}
