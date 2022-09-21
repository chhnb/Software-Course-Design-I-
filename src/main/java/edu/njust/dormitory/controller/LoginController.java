package edu.njust.dormitory.controller;

import com.alibaba.fastjson.JSONObject;
import edu.njust.dormitory.entity.Login;
import edu.njust.dormitory.entity.Register;
import edu.njust.dormitory.entity.Result;
import edu.njust.dormitory.service.LoginService;
import edu.njust.dormitory.service.RegisterService;
import edu.njust.dormitory.utils.JwtUtils;
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

    /**
     * 登录验证
     * @param login 用户名密码
     * @return 失败信息或token字符串
     */
    @PostMapping("/login")
    public Result Login(@RequestBody Login login){
        Result result = new Result();

        int res = loginService.checkUser(login);
        switch (res){
            case 0:{
                login = loginService.getInfo(login);

                String token = JwtUtils.sign(login);
                result.setToken(token);

                result = ResultUtils.success(result);
                break;
            }
            case 1:{
                result = ResultUtils.error(1001,"用户不存在");
                break;
            }
            case 2:{
                result = ResultUtils.error(1002,"密码错误");
                break;
            }
        }

        return result;
    }

    /**
     * 注册
     * @param register 注册信息
     * @return 失败信息或注册信息
     */
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
                result = ResultUtils.error(2001,"用户名过短");
                break;
            }
            case 2:{
                result = ResultUtils.error(2002,"用户名过长");
                break;
            }
            case 3:{
                result = ResultUtils.error(2003,"密码过短");
                break;
            }
            case 4:{
                result = ResultUtils.error(2004,"密码过长");
                break;
            }
            case 5:{
                result = ResultUtils.error(2005,"用户名已被使用");
                break;
            }
        }

        return  result;
    }

    /**
     * 查询审核进度并清空记录
     * @param register 注册用户名
     * @return 失败信息或查询结果
     */
    @PostMapping("/queryRegister")
    public Result QueryRegister(@RequestBody Register register){
        Result result;

        register = registerService.getInfo(register);
        if(register == null){
            result = ResultUtils.error(3001,"查询的用户不存在");
        }else{
            registerService.delRegister(register);
            result = ResultUtils.success(register);
        }

        return  result;
    }

    /**
     * 展示未审核名单
     * @return 未审核人员List
     */
    @PostMapping("/showRegister")
    public Result ShowRegister(){
        Result result;

        List<Register> registerList = registerService.showRegister();
        result = ResultUtils.success(registerList);

        return result;
    }

    /**
     * 审核通过
     * @param register 被审核人员
     * @return 注册信息
     */
    @PostMapping("/updateRegister")
    public Result PassRegister(@RequestBody Register register){
        Result result;

        int tmp = register.getCheckRes();
        register = registerService.getInfo(register);
        if(register == null){
            result = ResultUtils.error(4001,"操作的用户不存在");
        }else{
            register.setCheckRes(tmp);
            registerService.updateRegister(register);
            result = ResultUtils.success(register);
        }

        return  result;
    }

    /**
     * 更改用户名
     * @param token token字符串
     * @param userName 新密码
     * @return 用户信息
     */
    @PostMapping("/changeUserName")
    public Result ChangeUserName(@RequestBody String token,String userName){
        Result result;

        Login login = new Login();
        login.setUserName(JwtUtils.getUserName(token));
        loginService.getInfo(login);


        login.setUserName(userName);
        loginService.updateLogin(login);
        result = ResultUtils.success();
        result.setToken(token);

        return  result;
    }

    /**
     * 更改密码
     * @param token token字符串
     * @param pwd 新密码
     * @return 用户信息
     */
    @PostMapping("/changePwd")
    public Result ChangePwd(@RequestBody String token,String pwd){
        Result result;

        Login login = new Login();
        login.setUserName(JwtUtils.getUserName(token));
        loginService.getInfo(login);

        login.setPwd(pwd);
        loginService.updateLogin(login);
        result = ResultUtils.success();
        result.setToken(token);

        return  result;
    }

    /**
     * 注销
     * @param token token字符串
     * @return 空
     */
    @PostMapping("/delLogin")
    public Result DelLogin(@RequestBody String token){
        Result result;

        Login login = new Login();
        login.setUserName(JwtUtils.getUserName(token));
        loginService.getInfo(login);
        loginService.delLogin(login);
        result = ResultUtils.success();

        return  result;
    }

    /**
     * 登出
     * @param token token字符串
     * @return 空
     */
    @PostMapping("/logout")
    public Result Logout(@RequestBody String token){
        Result result = ResultUtils.success();
        result.setToken(null);
        return  result;
    }
}
