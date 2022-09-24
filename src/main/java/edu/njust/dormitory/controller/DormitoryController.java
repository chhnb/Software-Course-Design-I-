package edu.njust.dormitory.controller;

import edu.njust.dormitory.entity.Dormitory;
import edu.njust.dormitory.entity.Login;
import edu.njust.dormitory.entity.Result;
import edu.njust.dormitory.repository.LoginRepository;
import edu.njust.dormitory.service.DormitoryService;
import edu.njust.dormitory.service.LoginService;
import edu.njust.dormitory.utils.JwtUtils;
import edu.njust.dormitory.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DormitoryController {

    @Autowired
    private DormitoryService dormitoryService;
    @Autowired
    private LoginService loginService;

    /**
     * 查询所有宿舍
     * @return 所有宿舍的List
     */
    @PostMapping("/queryAllDormitory")
    public Result QueryAllDormitory(){
        Result result;

        List<Dormitory> dormitoryList = dormitoryService.queryAllDormitory();
        result = ResultUtils.success(dormitoryList);

        return  result;
    }

    /**
     * 查询登陆者的宿舍
     * @param token jwt字符串
     * @return 登录者所属宿舍信息
     */
    @PostMapping("/queryDormitory")
    public Result QueryDormitory(@RequestBody String token){
        Result result;

        Login login = new Login();
        login.setUserName(JwtUtils.getUserName(token));
        loginService.getInfo(login);

        int dormitoryId = login.getDormitoryId();
        Dormitory dormitory = new Dormitory();
        dormitory.setId(dormitoryId);
        dormitory = dormitoryService.getInfo(dormitory);

        if(dormitory == null){
            result = ResultUtils.error(5001,"宿舍不存在");
        }else{
            result = ResultUtils.success(dormitory);
        }

        return  result;
    }

    /**
     * 查询未分配宿舍者
     * @return 未分配宿舍者的List
     */
    @PostMapping("/queryHomeless")
    public Result QueryHomeless(){
        Result result;

        List<Login> logins = dormitoryService.queryHomeless();
        result = ResultUtils.success(logins);

        return result;
    }

    /**
     * 查询未满人宿舍
     * @return 未满人宿舍List
     */
    @PostMapping("/queryPartDormitory")
    public Result QueryPartDormitory(){
        Result result;

        List<Dormitory> dormitoryList = dormitoryService.queryPartDormitory();
        result = ResultUtils.success(dormitoryList);

        return result;
    }

    /**
     * 入住新宿舍
     * @param login 入住者用户名与入住的宿舍编号
     * @return 入住后的宿舍信息
     */
    @PostMapping("/addMember")
    public  Result AddMember(Login login){
        Result result;

        Dormitory dormitory = new Dormitory();
        dormitory.setId(login.getDormitoryId());
        dormitoryService.addMember(dormitory,login);
        result = ResultUtils.success(dormitory);

        return result;
    }

    /**
     * 重新分配宿舍
     * @param login 申请重新入住者的用户名
     * @return 入住者信息
     */
    @PostMapping("/delMember")
    public Result DelMember(Login login){
        Result result;

        Dormitory dormitory = new Dormitory();
        dormitory.setId(login.getDormitoryId());
        dormitoryService.delMember(dormitory,login);
        result = ResultUtils.success(login);

        return result;
    }
}
