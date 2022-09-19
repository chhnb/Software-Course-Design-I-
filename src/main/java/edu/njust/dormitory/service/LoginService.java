package edu.njust.dormitory.service;

import edu.njust.dormitory.dao.LoginDAO;
import edu.njust.dormitory.entity.Login;

public class LoginService {
    static LoginDAO loginDAO = new LoginDAO();
    public int checkUser(Login loginInfo){
        return loginDAO.checkLogin(loginInfo);
    }

    public Login getInfo(Login loginInfo) {return loginDAO.getInfo(loginInfo);}
}
