package edu.njust.dormitory.dao;

import edu.njust.dormitory.entity.Login;

import java.util.List;

public interface LoginDAOInf {
    int checkLogin(Login loginInfo);
    Login getInfo(Login loginEntity);

    void updateLogin(Login login);

    void delLogin(Login login);

    List<Login> queryHomeless();
}