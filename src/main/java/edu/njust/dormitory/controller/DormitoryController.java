package edu.njust.dormitory.controller;

import edu.njust.dormitory.entity.Dormitory;
import edu.njust.dormitory.entity.Login;
import edu.njust.dormitory.entity.Receive;
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
     * @return 登录者所属宿舍信息
     */
    @PostMapping("/queryDormitory")
    public Result QueryDormitory(@RequestBody Receive receive){
        Result result;

        String token = receive.getToken();

        Login login = new Login();
        login.setUserName(JwtUtils.getUserName(token));
        login = loginService.getInfo(login);

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
    public  Result AddMember(@RequestBody Login login){
        Result result;

        Dormitory dormitory = new Dormitory();
        dormitory.setId(login.getDormitoryId());
        dormitory = dormitoryService.getInfo(dormitory);
        dormitoryService.addMember(dormitory,login);

        dormitory = dormitoryService.getInfo(dormitory);
        result = ResultUtils.success(dormitory);

        return result;
    }

    /**
     * 重新分配宿舍
     * @return 入住者信息
     */
    @PostMapping("/delMember")
    public Result DelMember(@RequestBody Receive receive){
        Result result;

        String token = receive.getToken();

        String userName = JwtUtils.getUserName(token);
        Login login = new Login();
        login.setUserName(userName);
        login = loginService.getInfo(login);

        Dormitory dormitory = new Dormitory();
        dormitory.setId(login.getDormitoryId());
        dormitory = dormitoryService.getInfo(dormitory);

        dormitoryService.delMember(dormitory,login);

        dormitory = dormitoryService.getInfo(dormitory);
        result = ResultUtils.success(dormitory);

        return result;
    }
}
