package com.qcby.hongyancommon.api.chat.rpc;

import java.util.List;

public interface ChatFriendRpc {
    /**
     *  查找好友列表rpc接口
     *      返回好友主键集合
     * @param user_id
     * @return 主键集合
     */
    List<Long> selectFriendRex(Long user_id);
}
