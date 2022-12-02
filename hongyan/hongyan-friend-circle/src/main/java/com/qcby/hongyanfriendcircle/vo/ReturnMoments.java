package com.qcby.hongyanfriendcircle.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

/**
 * @ProjectName: ppq
 * @Package: com.bwfw.ppq.VO
 * @ClassName: ReturnMoments
 * @Author: zxh
 * @Description: 朋友圈返回Vo
 * @Date: 2022/1/5 17:58
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnMoments {

    private Long total;

    private HashMap<String,String> hashMap;

}
