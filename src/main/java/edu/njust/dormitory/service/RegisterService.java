package edu.njust.dormitory.service;

import edu.njust.dormitory.entity.Register;
import edu.njust.dormitory.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RegisterService {

    @Autowired
    private RegisterRepository registerRepository;

    /**
     * 检查注册信息
     * @param register 注册者信息
     * @return  1-用户名过短 2-用户名过长 3-密码过短 4-密码过长 5-用户名重复
     */
    public int checkRegister(Register register){
        if(register.getUserName().length() < 4)
            return 1;
        if(register.getUserName().length() > 16)
            return 2;
        if(register.getPwd().length() < 4)
            return 3;
        if(register.getPwd().length() > 20)
            return 4;
        int res = 0;
        try {
            Register registerTmp = registerRepository.findByUserName(register.getUserName());
            if(registerTmp != null)
                res = 5;
        } catch (Exception ignored) {
        }
        return res;
    }

    /**
     * 增加新注册信息
     * @param register 注册信息
     */
    public void addRegister(Register register){
        try {
            Register res = registerRepository.save(register);
        } catch (Exception ignored) {
        }
    }

    /**
     * 补全注册信息
     * @param register 用户名
     * @return 完整注册信息
     */
    public Register getInfo(Register register){
        try {
            return registerRepository.findByUserName(register.getUserName());
        } catch (Exception ignored) {
        }
        return null;
    }

    /**
     * 更新注册信息中的审核结果
     * @param register 注册信息
     */
    public void updateRegister(Register register){
        registerRepository.updateCheckResByUserName(register.getUserName(),register.getCheckRes());
    }

    /**
     * 删除注册信息
     * @param register 注册信息
     */
    public void delRegister(Register register){
        registerRepository.deleteRegisterByUserName(register.getUserName());
    }

    public List<Register> showRegister(){
        return registerRepository.findUnchecked();
    }

}
