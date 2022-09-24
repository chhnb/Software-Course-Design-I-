package edu.njust.dormitory;

import edu.njust.dormitory.controller.LoginController;
import edu.njust.dormitory.entity.Login;
import edu.njust.dormitory.entity.Register;
import edu.njust.dormitory.entity.Result;
import edu.njust.dormitory.service.RegisterService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class DormitoryManagementApplicationTests {

    @Autowired
    private RegisterService registerService;
    @Test
    void contextLoads() {

        Result result;
        Register register = new Register();
        register.setUserName("baozhiguo111");
        register = registerService.getInfo(register);
        System.out.println(register.getName());
        List<Register> registerList = registerService.showRegister();
        for(Register tmp: registerList){
            System.out.println(tmp.getUserName()+"  "+tmp.getName());
        }
    }

}
