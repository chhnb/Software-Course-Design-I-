package edu.njust.dormitory.dao;

import edu.njust.dormitory.entity.Register;
import edu.njust.dormitory.utils.HibernateUtils;

import java.util.List;

public class RegisterDAO implements RegisterDAOInf{

    static HibernateUtils hibernateUtils = new HibernateUtils();

    /**
     * 获取所有未审核的注册信息
     * @return  未审核的注册信息list
     */
    @Override
    public List<Register> queryRegister() {
        String sql = "select * from register where check_res = '0'";
        return hibernateUtils.sqlQuery_RegisterEntity(sql);
    }

    @Override
    public Boolean checkUserName(String userName) {
        String sql = "select * from register where user_name = '" + userName + "'";
        List<Register> result = hibernateUtils.sqlQuery_RegisterEntity(sql);
        return result == null;
    }

    @Override
    public void addRegister(Register register) {
        hibernateUtils.insert_RegisterEntity(register);
    }


    @Override
    public void updateRegister(Register register) {
        hibernateUtils.update_RegisterEntity(register);
    }

    @Override
    public void delRegister(Register register) {
        hibernateUtils.delete_RegisterEntity(register);
    }

    @Override
    public Register getInfo(Register register) {
        Register res = null;
        String sql = "select * from register where user_name = '" + register.getUserName() + "'";
        List<Register> result = hibernateUtils.sqlQuery_RegisterEntity(sql);
        for(Register tmp: result){
            res = new Register();
            res.setNum(tmp.getNum());
            res.setUserName(tmp.getUserName());
            res.setPwd(tmp.getPwd());
            res.setName(tmp.getName());
            res.setId(tmp.getName());
            res.setUserType(tmp.getUserType());
            res.setCheckRes(tmp.getCheckRes());
        }
        return res;
    }
}
