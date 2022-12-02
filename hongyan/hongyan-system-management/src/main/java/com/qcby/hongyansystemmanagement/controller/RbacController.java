package com.qcby.hongyansystemmanagement.controller;

import com.qcby.hongyansystemmanagement.common.web.ResultJson;
import com.qcby.hongyansystemmanagement.entity.Power;
import com.qcby.hongyansystemmanagement.entity.RoleToPowerVO ;
import com.qcby.hongyansystemmanagement.entity.User ;
import com.qcby.hongyansystemmanagement.service.PowerService;
import com.qcby.hongyansystemmanagement.service.RpacService ;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("rbac")
public class RbacController {
    @Autowired
    private RpacService rpacService;

    @Autowired
    private PowerService powerService;


    // 添加用户
    @RequestMapping("userInsert")
    public @ResponseBody String userInsert(int userId, String username, String password, String details,int roleId) {
        if(password !=null && username !=null){
            log.info("添加用户入参---：  "+"userId:  "+userId+"username:  "+username+"password:  "+password+"details:  "+details+"roleId:   "+roleId);
            rpacService.userInsert(userId,username,password,details,roleId);
            log.info("添加用户出参---：  "+rpacService.userInsert(userId,username,password,details,roleId));
            return "添加成功";
        }
      //  return rpacService.userInsert(userId, username, password, details,roleId);
        return "参数输入不完整，请补充完整";
    }
//    public ResultJson userInsert(int userId, String username, String password, String details,int roleId) {
//        rpacService.userInsert(userId, username, password, details,roleId);
//        return ResultJson.ok();
//    }


    // 删除用户
    @GetMapping("userDelete")
    public @ResponseBody String userDelete(int userId){
        if(userId!=0){
            log.info("删除用户入参---：  "+"userId:  "+userId);
            rpacService.userDelete(userId);
            log.info("删除用户出参---：  "+ rpacService.userDelete(userId));
            return "删除成功";
        }
        return "删除失败";
       // return rpacService.userDelete(userId);
    }

    // 修改用户信息
    @GetMapping("userUpdate")
    public @ResponseBody String userUpdate(int id,String username,String password, String details){
        if(username !=null || password !=null ||details!=null){
            log.info("修改用户入参---：  "+"id:  "+id+"username:  "+username+"password:  "+password+"details:  "+details);
            rpacService.userUpdate(id, username, password, details);
            log.info("修改用户出参---：  "+ rpacService.userUpdate(id, username, password, details));
            return "修改成功";
        }
            return "修改失败";
       // return rpacService.userUpdate(id, username, password, details);
    }


    // 查询所有用户所有信息
    @GetMapping("selectAllUser")
    public @ResponseBody List<User> selectAllUser() {
        rpacService.selectAllUser();
        log.info("查询用户出参---：  "+ rpacService.selectAllUser());
        return rpacService.selectAllUser();
    }

    // 用户角色关联表插入数据
    @GetMapping("userRoleInsert")
    public @ResponseBody String userRoleInsert(@RequestParam int userId, int roleId) {
        if( userId !=0 && roleId !=0){
            log.info("添加用户角色关联表入参---：  "+"userId= "+userId+"roleId= "+roleId);
            rpacService.userRoleInsert(userId, roleId);
            log.info("添加用户角色关联表出参---：  "+rpacService.userRoleInsert(userId, roleId));
            return "添加成功";
        }
        return "添加失败";
        //return rpacService.userRoleInsert(userId, roleId);
    }

    /**
     * 修改，你写这个，如何定位到某一条具体的数据
     *
     * @param userId
     * @param roleId
     * @return
     */
    // 用户角色关联表更新数据
    @GetMapping("userRoleUpdate")
    public @ResponseBody String userRoleUpdate(int userId, int roleId){
        if( userId !=0 || roleId !=0){
            log.info("修改用户角色关联表入参---：  "+"userId= "+userId+"roleId= "+roleId);
            rpacService.userRoleInsert(userId, roleId);
            log.info("修改用户角色关联表出参---：  "+rpacService.userRoleInsert(userId, roleId));
            return "修改成功";
        }
        return "修改失败";
       // return rpacService.userRoleUpdate(userId,roleId);
    }

    // 查询角色关联的权限
    @GetMapping("selectRoleToPower")
    public @ResponseBody RoleToPowerVO selectRoleToPower(){
        rpacService.selectRoleToPower();
        log.info("查询角色关联出参---:  "+rpacService.selectRoleToPower());
        return rpacService.selectRoleToPower();
    }


   //增加权限接口(单纯增加权限列表的总数)
    @RequestMapping("insertPower")
    public ResultJson powerInsert(Power power){
        boolean r = powerService.save(power);
        return ResultJson.ok(r);
    }

    //删除权限接口(单纯删除权限列表的总数)
    @RequestMapping("deletePower")
    public ResultJson powerDelete(Long pid){

        return ResultJson.ok(powerService.delete(pid));
    }

    //修改权限接口(单纯修改权限列表的总数)
    @RequestMapping("updatepower")
    public ResultJson powerUpdate(Long pid,String powername){
       powerService.update(pid,powername);
        return ResultJson.ok("更新成功！");
    }

    // 查询所有的权限
    @RequestMapping("selectAllPower")
    public @ResponseBody List<String> selectAllPower(){
        rpacService.selectAllPower();
        log.info("查询角所有权限出参---:  "+rpacService.selectAllPower());
        return rpacService.selectAllPower();
    }


//    //查询所有权限接口(单纯增加权限列表的总数)
//    @RequestMapping("selectPower")
//    public ResultJson powerSelect(Long id){
//        Power r = powerService.getById(id);
//        return ResultJson.ok(r);
//    }
}
