package com.qcby.hongyanfriendcircle.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 图片视屏关联表
 * </p>
 *
 * @author xmfs_bwfw
 * @since 2021-12-28
 */
@TableName("ref_address")
public class RefAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 动态主键
     */
    @TableId("moments_id")
    private Long momentsId;

    /**
     * 图片视屏地址
     */
    @TableField("address")
    private String address;

    public Long getMomentsId() {
        return momentsId;
    }

    public void setMomentsId(Long momentsId) {
        this.momentsId = momentsId;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "RefAddress{" +
            "momentsId=" + momentsId +
            ", address=" + address +
        "}";
    }
}
