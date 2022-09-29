package edu.njust.dormitory;

import edu.njust.dormitory.controller.CostController;
import edu.njust.dormitory.controller.DormitoryController;
import edu.njust.dormitory.controller.LoginController;
import edu.njust.dormitory.controller.MaintenanceController;
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
    private LoginController loginController;
    @Autowired
    private DormitoryController dormitoryController;
    @Autowired
    private CostController costController;
    @Autowired
    private MaintenanceController maintenanceController;
    @Test
    void contextLoads() {

        Login login = new Login();
        login.setUserName("oguriCap");
        login.setPwd("12345667");
        Result result = loginController.Login(login);
        System.out.println(result.getCode()+" "+result.getMessage());
        System.out.println(result.getToken());
        result = loginController.ChangeUserName(result.getToken(),"tachyon");
        System.out.println(result.getCode()+" "+result.getMessage());
        System.out.println(result.getToken());
    }

}
