package edu.njust.dormitory.dao;

import edu.njust.dormitory.entity.Register;
import edu.njust.dormitory.utils.HibernateUtils;

import java.util.List;

public class RegisterDAO implements RegisterDAOInf{

    static HibernateUtils hibernateUtils = new HibernateUtils();

    @Override
    public List<Register> queryRegister() {
        return null;
    }

    @Override
    public Boolean checkUserName(String userName) {
        String sql = "select * from register where USER_NAME = '" + userName + "'";
        List<Register> result = hibernateUtils.sqlQuery_RegisterEntity(sql);
        return result == null;
    }

    @Override
    public void addRegister(Register register) {
        hibernateUtils.insert_RegisterEntity(register);
    }

    @Override
    public void passRegister(Register register) {

    }

    @Override
    public void updateRegister(Register register) {

    }

    @Override
    public void delRegister(Register register) {

    }
}
