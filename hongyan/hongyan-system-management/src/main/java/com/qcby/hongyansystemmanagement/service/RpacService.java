package com.qcby.hongyansystemmanagement.service;

import com.qcby.hongyansystemmanagement.entity.RoleToPowerVO;
import com.qcby.hongyansystemmanagement.entity.User;

import java.util.List;

public interface RpacService {

    List<User> selectAllUser();

    int userInsert(int userId, String username, String password, String details, int roleId);

    int userDelete(int userId);

    int userUpdate(int id, String username, String password, String details);

    int userRoleInsert(int userId, int roleId);

    int userRoleUpdate(int uid, int rid);

    RoleToPowerVO selectRoleToPower();

    List<String> selectAllPower();
}
