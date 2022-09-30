package edu.njust.dormitory.service;

import edu.njust.dormitory.entity.Login;
import edu.njust.dormitory.entity.Maintenance;
import edu.njust.dormitory.repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceService {
    @Autowired
    private MaintenanceRepository maintenanceRepository;

    public Maintenance getInfo(Maintenance maintenance){
        return maintenanceRepository.findById(maintenance.getId());
    }

    public List<Maintenance> showMaintenance(){
        return maintenanceRepository.findUnchecked();
    }

    public void addMaintenance(Maintenance maintenance){
        maintenanceRepository.save(maintenance);
    }

    public void updateMaintenance(Maintenance maintenance,int resultNum){
        maintenanceRepository.updateMaintenanceById(maintenance.getId(),resultNum);
        maintenanceRepository.updateDateById(maintenance.getId(),maintenance.getTime());
    }

    public void delMaintenance(Maintenance maintenance){
        maintenanceRepository.deleteMaintenanceById(maintenance.getId());
    }
    public void updateUserName(Login oldLogin,Login newLogin){
        maintenanceRepository.updateUserName(oldLogin.getUserName(), newLogin.getUserName());
    }
}
