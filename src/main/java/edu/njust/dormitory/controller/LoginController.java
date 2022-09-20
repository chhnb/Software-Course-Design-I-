package edu.njust.dormitory.controller;

import edu.njust.dormitory.entity.Login;
import edu.njust.dormitory.entity.Register;
import edu.njust.dormitory.entity.Result;
import edu.njust.dormitory.service.LoginService;
import edu.njust.dormitory.service.RegisterService;
import edu.njust.dormitory.utils.ResultUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {
    static LoginService loginService = new LoginService();
    static RegisterService registerService = new RegisterService();
    @PostMapping("/login")
    public Result Login(@RequestBody Login login){
        Result result = new Result();

        int res = loginService.checkUser(login);
        switch (res){
            case 0:{
                login = loginService.getInfo(login);
                result = ResultUtils.success(login);
                break;
            }
            case 1:{
                result = ResultUtils.error(1,"用户不存在");
                break;
            }
            case 2:{
                result = ResultUtils.error(2,"密码错误");
                break;
            }
        }

        return result;
    }

    @PostMapping("/register")
    public Result Register(@RequestBody Register register){
        Result result = new Result();
        register.setCheckRes(0);

        int res = registerService.checkRegister(register);
        switch (res){
            case 0:{
                registerService.addRegister(register);
                register = registerService.getInfo(register);
                result = ResultUtils.success(register);
                break;
            }
            case 1:{
                result = ResultUtils.error(101,"用户名过短");
                break;
            }
            case 2:{
                result = ResultUtils.error(102,"用户名过长");
                break;
            }
            case 3:{
                result = ResultUtils.error(103,"密码过短");
                break;
            }
            case 4:{
                result = ResultUtils.error(104,"密码过长");
                break;
            }
            case 5:{
                result = ResultUtils.error(105,"用户名已被使用");
                break;
            }
        }

        return  result;
    }

    @PostMapping("/queryRegister")
    public Result QueryRegister(@RequestBody Register register){
        Result result;

        register = registerService.getInfo(register);
        if(register == null){
            result = ResultUtils.error(201,"查询的用户不存在");
        }else{
            registerService.delRegister(register);
            result = ResultUtils.success(register);
        }

        return  result;
    }

    @PostMapping("/showRegister")
    public Result ShowRegister(){
        Result result;

        List<Register> registerList = registerService.showRegister();
        result = ResultUtils.success(registerList);

        return result;
    }

    @PostMapping("/updateRegister")
    public Result PassRegister(@RequestBody Register register){
        Result result;

        int tmp = register.getCheckRes();
        register = registerService.getInfo(register);
        if(register == null){
            result = ResultUtils.error(301,"操作的用户不存在");
        }else{
            register.setCheckRes(tmp);
            registerService.updateRegister(register);
            result = ResultUtils.success(register);
        }

        return  result;
    }

    @PostMapping("/changeUserName")
    public Result ChangeUserName(@RequestBody Login login){
        Result result;

        String userName = login.getUserName();
        login = loginService.getInfo(login);
        login.setUserName(userName);
        loginService.updateLogin(login);
        result = ResultUtils.success();

        return  result;
    }

    @PostMapping("/changePwd")
    public Result ChangePwd(@RequestBody Login login){
        Result result;

        String pwd = login.getPwd();
        login = loginService.getInfo(login);
        login.setPwd(pwd);
        loginService.updateLogin(login);
        result = ResultUtils.success();

        return  result;
    }

    @PostMapping("/delLogin")
    public Result DelLogin(@RequestBody Login login){
        Result result;

        login = loginService.getInfo(login);
        loginService.delLogin(login);
        result = ResultUtils.success();

        return  result;
    }

}
