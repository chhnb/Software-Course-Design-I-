package edu.njust.dormitory.controller;

import edu.njust.dormitory.entity.Dormitory;
import edu.njust.dormitory.entity.Login;
import edu.njust.dormitory.entity.Result;
import edu.njust.dormitory.service.DormitoryService;
import edu.njust.dormitory.service.LoginService;
import edu.njust.dormitory.utils.ResultUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DormitoryController {

    static LoginService loginService = new LoginService();
    static DormitoryService dormitoryService = new DormitoryService();
    @PostMapping("/queryAllDormitory")
    public Result QueryAllDormitory(){
        Result result;

        List<Dormitory> dormitoryList = dormitoryService.queryAllDormitory();
        result = ResultUtils.success(dormitoryList);

        return  result;
    }
    @PostMapping("/queryPartDormitory")
    public Result QueryPartDormitory(){
        Result result;

        List<Dormitory> dormitoryList = dormitoryService.queryPartDormitory();
        result = ResultUtils.success(dormitoryList);

        return  result;
    }
    @PostMapping("/queryDormitory")
    public Result QueryDormitory(Login login){
        Result result;

        int dormitoryId = login.getDormitoryId();
        Dormitory dormitory = new Dormitory();
        dormitory.setId(dormitoryId);
        dormitory = dormitoryService.getInfo(dormitory);
        if(dormitory == null){
            result = ResultUtils.error(401,"宿舍不存在");
        }else{
            result = ResultUtils.success(dormitory);
        }

        return  result;
    }
}
