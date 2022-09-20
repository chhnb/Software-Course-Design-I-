package edu.njust.dormitory.service;

import edu.njust.dormitory.dao.LoginDAO;
import edu.njust.dormitory.entity.Login;

public class LoginService {
    static LoginDAO loginDAO = new LoginDAO();
    /**
     * 登录
     * @return errorCode    0-成功
     *                      1-用户不存在
     *                      2-密码错误
     */
    public int checkUser(Login loginInfo){
        return loginDAO.checkLogin(loginInfo);
    }

    public Login getInfo(Login loginInfo) {return loginDAO.getInfo(loginInfo);}

    public void updateLogin(Login login) {
        loginDAO.updateLogin(login);
    }

    public void delLogin(Login login){
        loginDAO.delLogin(login);
    }
}
