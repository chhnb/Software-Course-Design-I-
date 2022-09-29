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

import java.util.List;

@RestController
public class MaintenanceController {

    @Autowired
    private MaintenanceService maintenanceService;

    @PostMapping("/queryMaintenance")
    public Result QueryMaintenance(@RequestBody Maintenance maintenance){
        Result result;
        maintenance = maintenanceService.queryMaintenance(maintenance);
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

    @PostMapping("/addMaintenance")
    public Result AddMaintenance(@RequestBody Maintenance maintenance){
        Result result;
        maintenanceService.addMaintenance(maintenance);
        result = ResultUtils.success(maintenance);
        return result;
    }

    @PostMapping("/updateMaintenance")
    public Result UpdateMaintenance(@RequestBody Maintenance maintenance, Receive receive){
        Result result;
        int resultNum = receive.getResultNum();

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
