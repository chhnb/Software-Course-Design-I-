package edu.njust.dormitory.dao;

import edu.njust.dormitory.entity.Cost;
import edu.njust.dormitory.entity.Dormitory;

import java.util.List;

public interface CostDAOInf {

     List<Cost> queryAllCost();

     Cost queryCost(Dormitory dormitory);

     List<Cost> queryPartCost();

     void updateCost(Cost cost);
}
