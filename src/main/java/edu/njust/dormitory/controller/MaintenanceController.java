package edu.njust.dormitory.controller;

import edu.njust.dormitory.entity.Maintenance;
import edu.njust.dormitory.entity.Receive;
import edu.njust.dormitory.entity.Result;
import edu.njust.dormitory.service.MaintenanceService;
import edu.njust.dormitory.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@RestController
public class MaintenanceController {

    @Autowired
    private MaintenanceService maintenanceService;

    @PostMapping("/queryMaintenance")
    public Result QueryMaintenance(@RequestBody Maintenance maintenance){
        Result result;
        maintenance = maintenanceService.getInfo(maintenance);
        result = ResultUtils.success(maintenance);
        return result;
    }

    @PostMapping("/showMaintenance")
    public Result ShowMaintenance(){
        Result result;
        List<Maintenance> maintenanceList = maintenanceService.showMaintenance();
        result = ResultUtils.success(maintenanceList);
        return result;
    }

    @PostMapping("/showPartMaintenance")
    public Result ShowPartMaintenance(){
        Result result;
        List<Maintenance> maintenanceList = maintenanceService.showPartMaintenance();
        result = ResultUtils.success(maintenanceList);
        return result;
    }

    @PostMapping("/addMaintenance")
    public Result AddMaintenance(@RequestBody Maintenance maintenance){
        Result result;
        maintenance.setTime(new Date());
        maintenance.setResult(0);

        maintenanceService.addMaintenance(maintenance);

        result = ResultUtils.success(maintenance);
        return result;
    }

    @PostMapping("/updateMaintenance")
    public Result UpdateMaintenance(@RequestBody Receive receive){
        Result result;
        int resultNum = 1;
        int id = receive.getId();
        Date date = receive.getDate();

        Maintenance maintenance = new Maintenance();
        maintenance.setId(id);
        maintenance = maintenanceService.getInfo(maintenance);
        maintenance.setTime(date);

        maintenanceService.updateMaintenance(maintenance,resultNum);
        result = ResultUtils.success(maintenance);
        return result;
    }

    @PostMapping("/finishMaintenance")
    public Result FinishMaintenance(@RequestBody Receive receive){
        Result result;
        int resultNum = 2;
        int id = receive.getId();
        Date date = receive.getDate();

        Maintenance maintenance = new Maintenance();
        maintenance.setId(id);
        maintenance = maintenanceService.getInfo(maintenance);
        maintenance.setTime(date);

        maintenanceService.updateMaintenance(maintenance,resultNum);
        result = ResultUtils.success(maintenance);
        return result;
    }

    @PostMapping("/delMaintenance")
    public Result DelMaintenance(@RequestBody Maintenance maintenance){
        Result result;
        maintenanceService.delMaintenance(maintenance);
        result = ResultUtils.success();
        return result;
    }
}
