package edu.njust.dormitory.service;

import edu.njust.dormitory.entity.Login;
import edu.njust.dormitory.entity.Register;
import edu.njust.dormitory.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;
    /**
     * 登录
     * @return errorCode    0-成功
     *                      1-用户不存在
     *                      2-密码错误
     */
    public int checkUser(Login loginInfo){
        Login login = loginRepository.findLoginByUserName(loginInfo.getUserName());
        if(login == null){
            return 1;
        }else{
            if(login.getPwd().equals(loginInfo.getPwd())){
                return 0;
            }else{
                return 2;
            }
        }
    }

    public int findByUserName(Login login){
        login = loginRepository.findLoginByUserName(login.getUserName());
        if(login == null)
            return 1;
        return 0;
    }

    public void addLogin(Login login){
        try {
            Login res = loginRepository.save(login);
        } catch (Exception ignored) {
        }
    }


    public Login getInfo(Login loginInfo) {
        return loginRepository.findLoginByUserName(loginInfo.getUserName());
    }

    public void updateUserName(Login login,String newUserName) {
        loginRepository.updateUserName(login.getUserName(),newUserName);
    }

    public void updatePwd(Login login,String newPwd){
        loginRepository.updatePwd(login.getUserName(),newPwd);
    }

    public void delLogin(Login login){
        loginRepository.deleteLoginByUserName(login.getUserName());
    }

}
