package com.qcby.hongyansystemmanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qcby.hongyansystemmanagement.entity.Power ;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface PowerMapper extends BaseMapper<Power> {
    Object delete(Long pid);

    void update(@Param("pid") Long pid, @Param("powername") String powername);
}
