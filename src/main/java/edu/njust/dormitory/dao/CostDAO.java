package edu.njust.dormitory.dao;

import edu.njust.dormitory.entity.Cost;
import edu.njust.dormitory.entity.Dormitory;
import edu.njust.dormitory.utils.HibernateUtils;

import java.util.List;

public class CostDAO implements CostDAOInf{

    static HibernateUtils hibernateUtils = new HibernateUtils();

    @Override
    public List<Cost> queryAllCost() {
        String sql = "select * from cost";
        return hibernateUtils.sqlQuery_Cost(sql);
    }

    @Override
    public Cost queryCost(Dormitory dormitory) {
        int dormitoryId = dormitory.getId();
        String sql = "select * from cost where dormitory_id = '" + dormitoryId + "'";
        List<Cost> costList = hibernateUtils.sqlQuery_Cost(sql);
        Cost cost = new Cost();
        for(Cost tmp : costList){
            cost.setDormitoryId(tmp.getDormitoryId());
            cost.setElectric(tmp.getElectric());
            cost.setWater(tmp.getWater());
            cost.setPower(tmp.getPower());
        }
        return cost;
    }

    @Override
    public List<Cost> queryPartCost() {
        String sql = "select * from cost where power > 200";
        return hibernateUtils.sqlQuery_Cost(sql);
    }

    @Override
    public void updateCost(Cost cost) {
        hibernateUtils.update_Cost(cost);
    }
}
