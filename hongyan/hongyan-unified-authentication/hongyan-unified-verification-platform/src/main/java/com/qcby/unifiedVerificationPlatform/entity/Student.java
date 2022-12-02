package com.qcby.unifiedVerificationPlatform.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

/**
 * @author 学生表
 */


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 学生表的id
     */
    private Long id;

    /**
     * 用户主键id
     */
    private Long userId;

    /**
     * 学生的姓名
     */
    private String name;

    /**
     * 学号  == 用户名
     */
    private String username;

    /**
     * 性别
     */
    private Integer sex;

    @TableField(exist = false)
    private String sexName;
    /**
     * 入学时间
     */
    private Date startDate;

    /**
     * 毕业时间，没毕业默认9999-01-01
     */
    private Date overDate;

    /**
     * 出生日期
     */
    private String birthday;

    /**
     * 民族
     */
    private String nation;

    /**
     * 所属学院的id
     */
    private Long collegeId;

    @TableField(exist = false)
    private String collegeName;
    /**
     * 所属专业的id
     */
    private Long majorId;

    @TableField(exist = false)
    private String majorName;
    /**
     * 所属班级的id
     */
    private Long classId;

    @TableField(exist = false)
    private String className;
    /**
     * 属于哪个老师管理，对应老师的id
     */
    private Long teacherId;

    @TableField(exist = false)
    private String teacherName;
    /**
     * 所属宿舍楼
     */
    private Long dormId;

    @TableField(exist = false)
    private String dormDetail;

    /**
     * 所属宿舍号
     */
    private Long dormfloorId;

    @TableField(exist = false)
    private String dormName;

    /**
     * 学生照片，存放照片的地址
     */
    private String photo;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 宗教
     */
    private String religion;

    /**
     * 学生状态，正常，休学，留校察看等
     */
    private String state;

    /**
     * 创建时间

     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 权限字符串
     */
    @TableField(exist = false)
    private Set<String> menuUrlPathList;

    @TableField(exist = false)
    private String token;

    @TableField(exist = false)
    private String password;
}