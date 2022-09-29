package edu.njust.dormitory;

import edu.njust.dormitory.controller.CostController;
import edu.njust.dormitory.controller.DormitoryController;
import edu.njust.dormitory.controller.LoginController;
import edu.njust.dormitory.controller.MaintenanceController;
import edu.njust.dormitory.entity.*;
import edu.njust.dormitory.service.LoginService;
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
    @Autowired
    private LoginService loginService;
    @Test
    void contextLoads() {

        Result result;
        Login login = new Login();
        login.setUserName("oguriCap");
        login.setPwd("12345667");
        result = loginController.Login(login);
        System.out.println(result);

        String token = result.getToken();
        Receive receive = new Receive();
        receive.setToken(token);

        login = loginService.getInfo(login);
        login.setDormitoryId(3);

        result =  dormitoryController.QueryAllDormitory();
        System.out.println(result);
    }
}
