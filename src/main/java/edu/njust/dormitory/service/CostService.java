package edu.njust.dormitory.service;

import edu.njust.dormitory.dao.CostDAO;
import edu.njust.dormitory.entity.Cost;
import edu.njust.dormitory.entity.Dormitory;

import java.util.List;

public class CostService {

    static CostDAO costDAO = new CostDAO();

    public List<Cost> queryAllCost() {
        return costDAO.queryAllCost();
    }

    public Cost queryCost(Dormitory dormitory) {
        return costDAO.queryCost(dormitory);
    }

    public List<Cost> queryPartCost() {
        return costDAO.queryPartCost();
    }

    public void updateCost(Cost cost) {
        costDAO.updateCost(cost);
    }

    public Cost getInfo(Cost cost){
        Dormitory dormitory = new Dormitory();
        dormitory.setId(cost.getDormitoryId());
        return costDAO.queryCost(dormitory);
    }
}
