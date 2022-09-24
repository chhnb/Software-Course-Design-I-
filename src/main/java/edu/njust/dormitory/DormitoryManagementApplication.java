package edu.njust.dormitory;

import edu.njust.dormitory.controller.LoginController;
import edu.njust.dormitory.entity.Register;
import edu.njust.dormitory.entity.Result;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class DormitoryManagementApplication {

    static LoginController loginController = new LoginController();
    public static void main(String[] args) {
        SpringApplication.run(DormitoryManagementApplication.class, args);

    }

}
