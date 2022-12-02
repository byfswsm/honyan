package com.qcby.hongyanfriendcircle.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class PageList<T> {
    @Value("${defpage.pagesize}")//默认是   10
    private Integer pageSize;
    @Value("${defpage.pageindex}")// 默认是  第1页
    private Integer pageIndex;
    private T obj;

    public Page<T> getPage() {
        return new Page<T>(this.pageIndex , this.pageSize);
    }

}
