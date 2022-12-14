package edu.njust.dormitory.controller;

import com.alibaba.fastjson.JSONObject;
import edu.njust.dormitory.DormitoryManagementApplication;
import edu.njust.dormitory.entity.Login;
import edu.njust.dormitory.entity.Receive;
import edu.njust.dormitory.entity.Register;
import edu.njust.dormitory.entity.Result;
import edu.njust.dormitory.service.DormitoryService;
import edu.njust.dormitory.service.LoginService;
import edu.njust.dormitory.service.MaintenanceService;
import edu.njust.dormitory.service.RegisterService;
import edu.njust.dormitory.utils.JwtUtils;
import edu.njust.dormitory.utils.ResultUtils;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private LoginService loginService;
    @Autowired
    private DormitoryService dormitoryService;
    @Autowired
    private MaintenanceService maintenanceService;

    /**
     * 登录验证
     * @param login 用户名密码
     * @return 失败信息或token字符串
     */
    @PostMapping("/login")
    public Result Login(@RequestBody Login login){
        Result result;

        int res = loginService.checkUser(login);
        switch (res){
            case 0:{
                login = loginService.getInfo(login);

                String token = JwtUtils.sign(login);

                result = ResultUtils.success(login);
                result.setToken(token);
                break;
            }
            case 1:{
                result = ResultUtils.error(1001,"用户不存在");
                break;
            }
            default:{
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
        Result result;
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
            default:{
                result = ResultUtils.error(2006,"未知错误，请联系后台管理员");
            }
        }

        Login login = new Login();
        login.setUserName(register.getUserName());
        login = loginService.getInfo(login);
        if(login != null){
            result = ResultUtils.error(2005,"用户名已被使用");
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

        Login login = new Login();
        login.setUserName(register.getUserName());
        login = loginService.getInfo(login);
        if(login != null){
            result = ResultUtils.success();
            return result;
        }

        register = registerService.getInfo(register);
        if(register == null){
            result = ResultUtils.error(3001,"查询的用户不存在");
        }else{
            int checkRes = register.getCheckRes();

            switch (checkRes){
                case 0:{
                    result = ResultUtils.error(3002,"还未进行审核，请等待管理员处理");
                    break;
                }
                case 1:{
                    result = ResultUtils.success(register);
                    break;
                }
                case 2:{
                    result = ResultUtils.error(3003,"姓名不属实");
                    break;
                }
                case 3:{
                    result = ResultUtils.error(3003,"身份证号不符");
                    break;
                }
                case 4:{
                    result = ResultUtils.error(3003,"用户类型不符");
                    break;
                }
                default:{
                    result = ResultUtils.error(3000,"未知错误，请联系后台管理员");
                }
            }
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
    @PostMapping("/passRegister")
    public Result PassRegister(@RequestBody Register register){
        Result result;

        register = registerService.getInfo(register);
        if(register == null){
            result = ResultUtils.error(4001,"操作的用户不存在");
        }else {
            register.setCheckRes(1);
            registerService.updateRegister(register);
            Login login = new Login();
            login.setUserName(register.getUserName());
            login.setPwd(register.getPwd());
            login.setId(register.getId());
            login.setName(register.getName());
            login.setUserType(register.getUserType());
            login.setDormitoryId(0);
            loginService.addLogin(login);
            result = ResultUtils.success(login);
        }
        return  result;
    }

    /**
     * 拒绝注册申请
     * @return 注册信息
     */
    @PostMapping("/refuseRegister")
    public Result RefuseRegister(@RequestBody Receive receive){
        Result result;
        int errorCode = receive.getErrorCode();
        String userName = receive.getUserName();
        Register register = new Register();
        register.setUserName(userName);

        register = registerService.getInfo(register);
        if(register == null){
            result = ResultUtils.error(4001,"操作的用户不存在");
        }else {
            register.setCheckRes(errorCode);
            registerService.updateRegister(register);

            register = registerService.getInfo(register);
            result = ResultUtils.success(register);
        }

        return  result;
    }

    /**
     * 更改用户名
     * @return 用户信息
     */
    @PostMapping("/changeUserName")
    public Result ChangeUserName(@RequestBody Receive receive){
        Result result;

        String token = receive.getToken();
        String userName = receive.getUserName();
        String oldUserName = JwtUtils.getUserName(token);

        Login oldLogin = new Login();
        Login newLogin = new Login();
        oldLogin.setUserName(oldUserName);
        oldLogin = loginService.getInfo(oldLogin);
        newLogin.setUserName(oldUserName);
        newLogin = loginService.getInfo(newLogin);
        newLogin.setUserName(userName);

        Login login = new Login();
        login.setUserName(userName);
        login = loginService.getInfo(login);
        if(login != null){
            result = ResultUtils.error(2005,"用户名已被使用");
            return result;
        }

        Register register = new Register();
        register.setUserName(userName);
        register = registerService.getInfo(register);
        if(register != null){
            result = ResultUtils.error(2005,"用户名已被使用");
            return result;
        }

        dormitoryService.updateUserName(oldLogin,newLogin);
        maintenanceService.updateUserName(oldLogin,newLogin);
        registerService.updateUserName(oldLogin,newLogin);

        loginService.delLogin(oldLogin);
        loginService.addLogin(newLogin);
        String newToken = JwtUtils.sign(newLogin);

        result = ResultUtils.success(newLogin);
        result.setToken(newToken);

        return  result;
    }

    /**
     * 更改密码
     * @return 用户信息
     */
    @PostMapping("/changePwd")
    public Result ChangePwd(@RequestBody Receive receive){
        Result result;

        String token = receive.getToken();
        String pwd = receive.getPwd();

        Login login = new Login();
        login.setUserName(JwtUtils.getUserName(token));
        loginService.getInfo(login);

        loginService.updatePwd(login,pwd);
        result = ResultUtils.success();
        result.setToken(token);

        return  result;
    }

    /**
     * 注销
     * @return 空
     */
    @PostMapping("/delLogin")
    public Result DelLogin(@RequestBody Receive receive){
        Result result;

        String token = receive.getToken();

        Login login = new Login();
        login.setUserName(JwtUtils.getUserName(token));
        loginService.getInfo(login);
        loginService.delLogin(login);
        result = ResultUtils.success();

        return  result;
    }

    /**
     * 登出
     * @return 空
     */
    @PostMapping("/logout")
    public Result Logout(){

        Result result = ResultUtils.success();
        result.setToken(null);
        return  result;
    }
}
