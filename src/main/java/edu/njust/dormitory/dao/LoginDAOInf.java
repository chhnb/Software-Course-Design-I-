package edu.njust.dormitory.dao;

import edu.njust.dormitory.entity.Login;

public interface LoginDAOInf {
    int checkLogin(Login loginInfo);
    int forgetPwd(Login loginEntity);
    Login getInfo(Login loginEntity);
}