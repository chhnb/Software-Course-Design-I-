package edu.njust.dormitory.service;

import edu.njust.dormitory.dao.RegisterDAO;
import edu.njust.dormitory.entity.Register;

import java.util.List;

public class RegisterService {

    static RegisterDAO registerDAO = new RegisterDAO();

    /**
     * 检查注册信息
     * @param register 注册者信息
     * @return  1-用户名过短 2-用户名过长 3-密码过短 4-密码过长 5-用户名重复
     */
    public int checkRegister(Register register){
        if(register.getUserName().length() < 8)
            return 1;
        if(register.getUserName().length() > 16)
            return 2;
        if(register.getPwd().length() < 6)
            return 3;
        if(register.getPwd().length() > 20)
            return 4;
        if(registerDAO.checkUserName(register.getUserName()))
            return 5;
        return 0;
    }

    /**
     * 增加新注册信息
     * @param register 注册信息
     */
    public void addRegister(Register register){
        registerDAO.addRegister(register);
    }

    /**
     * 补全注册信息
     * @param register 用户名
     * @return 完整注册信息
     */
    public Register getInfo(Register register){
        Register res;
        if(!registerDAO.checkUserName(register.getUserName()))
            return null;
        res = registerDAO.getInfo(register);
        return res;
    }

    /**
     * 更新注册信息中的审核结果
     * @param register 注册信息
     */
    public void updateRegister(Register register){
        registerDAO.updateRegister(register);
    }

    /**
     * 删除注册信息
     * @param register 注册信息
     */
    public void delRegister(Register register){
        registerDAO.delRegister(register);
    }

    public List<Register> showRegister(){
        return registerDAO.queryRegister();
    }
}
