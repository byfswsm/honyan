package com.qcby.hongyansystemmanagement.mapper;


import com.qcby.hongyansystemmanagement.entity.RoleToPower;
import com.qcby.hongyansystemmanagement.entity.User ;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RpacMapper {

    List<User> selectAllUser();

    int userInsert(int uid, String username, String password, String details);

    int userDelete(int uid);

    int userUpdate(int uid,String username,String password, String details);

    // 给用户添加角色信息
    int userRoleInsert(int uid, int rid);

    // 删除用户绑定的角色
    int userRoleDelete(int uid);

    // 更新用户的角色信息
    int userRoleUpdate(int uid, int rid);

    // 查询角色和对应的权限
    List<RoleToPower> selectRoleToPower();

    List<String> selectAllPower();
}
