package com.qcby.hongyansystemmanagement.service.impl;

import com.qcby.hongyansystemmanagement.entity.RoleToPower;
import com.qcby.hongyansystemmanagement.entity.RoleToPowerVO;
import com.qcby.hongyansystemmanagement.entity.User;
import com.qcby.hongyansystemmanagement.mapper.RpacMapper;
import com.qcby.hongyansystemmanagement.service.RpacService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RpacServiceImpl implements RpacService {

    @Resource
    private RpacMapper rpacMapper;

    @Override
    public List<User> selectAllUser() {
        return rpacMapper.selectAllUser();
    }


    /**
     * 创建新的用户
     * 创建用户时给该用户分配角色
     * @param roleId  角色id
     * @return  0: 添加失败   1：添加成功
     */
    @Override
    public int userInsert(int userId, String username, String password, String details, int roleId) {
        int result = rpacMapper.userInsert(userId, username, password, details);
        if (result == 1) {// 添加用户成功
            int result2 = rpacMapper.userRoleInsert(userId, roleId);
            if(result2 == 1){ // 给用户添加角色成功
                return 1;
            }else{
                rpacMapper.userDelete(userId); // 给用户添加角色失败  删除用户
                return 0;
            }
        }
        return 0; // 添加用户失败
    }

    /**
     * 删除用户
     * 删除用户时，需要同时将用户绑定的角色信息删掉
     * @param userId
     * @return 1 成功， 0 失败
     */
    @Override
    public int userDelete(int userId) {
        int i = rpacMapper.userDelete(userId);
        if (i == 1) { // 用户删除成功 ，删除用户绑定角色信息
            int i1 = rpacMapper.userRoleDelete(userId);
            if(i1 == 1){
                return 1;
            }
            return 0;
        }
        return 0;
    }

    @Override
    public int userUpdate(int id, String username, String password, String details) {
        return rpacMapper.userUpdate(id,username,password,details);
    }

    @Override
    public int userRoleInsert(int userId, int roleId) {
        return rpacMapper.userRoleInsert(userId, roleId);
    }

    @Override
    public int userRoleUpdate(int uid, int rid) {
        return rpacMapper.userRoleUpdate(uid,rid);
    }


    public RoleToPowerVO selectRoleToPower(){
        RoleToPowerVO rtp  = new RoleToPowerVO();
        Map<String, Map<String, List<String>>> resultMap = new HashMap<>();
        List<RoleToPower> roleToPowers = rpacMapper.selectRoleToPower();
        for (RoleToPower next : roleToPowers) {

            if (resultMap.containsKey(next.getRname())) { // map中已经有了第一级
                Map<String, List<String>> stringListMap = resultMap.get(next.getRname());// 拿到二级
                    if (stringListMap.containsKey(next.getLevel())) { // 如果有第二级的话 将能力添加到第二级中
                        stringListMap.get(next.getLevel()).add(next.getPowername());
                    }else{ // 如果没有第二级 那么创建一个新的第二级
                        ArrayList<String> arrayList = new ArrayList<>();
                        arrayList.add(next.getPowername());
                        stringListMap.put(next.getLevel(),arrayList);
                    }
            } else {
                HashMap<String, List<String>> hs = new HashMap<>();
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(next.getPowername());
                hs.put(next.getLevel(), arrayList);
                resultMap.put(next.getRname(), hs);
            }
        }
        rtp.setResultMap(resultMap);
        return rtp;
    }

    @Override
    public List<String> selectAllPower() {
        return rpacMapper.selectAllPower();
    }
}
