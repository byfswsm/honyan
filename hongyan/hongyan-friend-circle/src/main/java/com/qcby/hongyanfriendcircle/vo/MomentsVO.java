package com.qcby.hongyanfriendcircle.vo;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.qcby.hongyanfriendcircle.entity.Comment;
import com.qcby.hongyanfriendcircle.entity.RefFabulous;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import java.util.List;


/**
 * @ProjectName: ppq
 * @Package: com.bwfw.ppq.VO
 * @ClassName: MomentsVO
 * @Author: zxh
 * @Description: 朋友圈的VO类
 * @Date: 2021/12/29 20:05
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MomentsVO {

    private Long id;

    /**
     * 拥有者
     */
    private Long userId;

    /**
     * 内容
     */
    private String content;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 可见时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime visibleTime;

    private List<RefFabulous> refFabulousList;

    private List<Comment> commentList;
}
