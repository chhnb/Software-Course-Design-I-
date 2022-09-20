package edu.njust.dormitory.dao;

import edu.njust.dormitory.entity.Login;
import edu.njust.dormitory.utils.HibernateUtils;

import java.util.List;

public class LoginDAO implements LoginDAOInf {

    static HibernateUtils hibernateUtils = new HibernateUtils();

    /**
     * 登录
     * @return errorCode    0-成功
     *                      1-用户不存在
     *                      2-密码错误
     */
    @Override
    public int checkLogin(Login loginInfo) {
        int errorCode = 0;
        String sql = "select * from login where USER_NAME = '"+loginInfo.getUserName()+"'";
        List<Login> loginEntityList = hibernateUtils.sqlQuery_LoginEntity(sql);
        if(loginEntityList == null){
            errorCode = 1;
        }else{
            for(Login loginEntity : loginEntityList){
                if (!loginEntity.getPwd().equals(loginInfo.getPwd())) {
                    errorCode = 2;
                    break;
                }
            }
        }
        return errorCode;
    }


    @Override
    public Login getInfo(Login loginEntity) {

        String sql = "select * from login where USER_NAME = '"+loginEntity.getUserName()+"'";
        List<Login> loginEntityList = hibernateUtils.sqlQuery_LoginEntity(sql);

        Login res = new Login();
        res.setUserName(loginEntity.getUserName());
        res.setPwd(loginEntity.getPwd());

        for(Login login : loginEntityList){
            res.setNum(login.getNum());
            res.setName(login.getName());
            res.setId(login.getId());
            res.setUserType(login.getUserType());
        }
        return res;
    }

    @Override
    public void updateLogin(Login login) {
        hibernateUtils.update_LoginEntity(login);
    }

    @Override
    public void delLogin(Login login) {
        hibernateUtils.delete_LoginEntity(login);
    }


}
