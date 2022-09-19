package edu.njust.dormitory.service;

import edu.njust.dormitory.dao.RegisterDAO;
import edu.njust.dormitory.entity.Register;

public class RegisterService {

    static RegisterDAO registerDAO = new RegisterDAO();

    /**
     * 新增注册人员
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

    public void addRegister(Register register){
        registerDAO.addRegister(register);
    }
}
