package edu.njust.dormitory.dao;

import edu.njust.dormitory.entity.Register;

import java.util.List;

public interface RegisterDAOInf {

    List<Register> queryRegister();

    Boolean checkUserName(String userName);

    void addRegister(Register register);

    void passRegister(Register register);

    void updateRegister(Register register);

    void delRegister(Register register);

}
