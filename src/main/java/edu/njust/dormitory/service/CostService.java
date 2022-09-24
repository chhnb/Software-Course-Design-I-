package edu.njust.dormitory.service;

import edu.njust.dormitory.entity.Cost;
import edu.njust.dormitory.entity.Dormitory;
import edu.njust.dormitory.repository.CostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CostService {

    @Autowired
    private CostRepository costRepository;

    public List<Cost> queryAllCost() {
        return costRepository.findAllCost();
    }

    public Cost queryCost(Dormitory dormitory) {
        return costRepository.findById(dormitory.getId());
    }

    public List<Cost> queryPartCost() {
        return costRepository.findPartCost();
    }

    public void updateElectric(Cost cost, Integer electric) {
        costRepository.updateElectric(cost.getDormitoryId(), electric);
    }

    public void updateWater(Cost cost,Integer water){
        costRepository.updateWater(cost.getDormitoryId(), water);
    }

    public void updatePower(Cost cost,Integer power){
        costRepository.updatePower(cost.getDormitoryId(), power);
    }
    public Cost getInfo(Cost cost){
        return costRepository.findById(cost.getDormitoryId());
    }
}
