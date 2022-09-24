package edu.njust.dormitory.controller;

import edu.njust.dormitory.entity.Cost;
import edu.njust.dormitory.entity.Dormitory;
import edu.njust.dormitory.entity.Result;
import edu.njust.dormitory.service.CostService;
import edu.njust.dormitory.service.DormitoryService;
import edu.njust.dormitory.utils.ResultUtils;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CostController {

    static CostService  costService = new CostService();

    /**
     * 查询所有宿舍的费用列表
     * @return 所有费用的List
     */
    @PostMapping("/queryAllCost")
    public Result QueryAllCost(){
        Result result;

        List<Cost> costList = costService.queryAllCost();
        if(costList != null){
            result = ResultUtils.success(costList);
        }else{
            result = ResultUtils.error(6001,"");
        }

        return result;
    }

    /**
     * 查询是否有用电违规宿舍
     * @return 违规宿舍List
     */
    @PostMapping("/queryPartCost")
    public Result QueryPartCost(){
        Result result;

        List<Cost> costList = costService.queryPartCost();
        if(costList != null){
            result = ResultUtils.success(costList);
        }else{
            result = ResultUtils.error(6001,"");
        }

        return result;
    }

    /**
     * 根据宿舍号查询费用
     * @param dormitory 宿舍信息
     * @return 费用信息
     */
    @PostMapping("/queryCost")
    public Result QueryCost(Dormitory dormitory){
        Result result;

        Cost cost = costService.queryCost(dormitory);
        if(cost != null){
            result = ResultUtils.success(cost);
        }else{
            result = ResultUtils.error(6001,"");
        }

        return  result;
    }

    /**
     * 电费缴费
     * @param dormitory 宿舍信息
     * @param money 缴费
     * @return 费用信息
     */
    @PostMapping("/addElectricCost")
    public Result AddElectricCost(Dormitory dormitory,int money){
        Result result;

        Cost cost = costService.queryCost(dormitory);
        if(cost == null){
            return ResultUtils.error(6002,"");
        }

        int electric = cost.getElectric();
        electric += money;
        costService.updateElectric(cost,electric);
        result = ResultUtils.success(cost);

        return result;
    }

    /**
     * 水费缴费
     * @param dormitory 宿舍信息
     * @param money 缴费
     * @return 费用信息
     */
    @PostMapping("/addWaterCost")
    public Result AddWaterCost(Dormitory dormitory,int money){
        Result result;

        Cost cost = costService.queryCost(dormitory);
        if(cost == null){
            return ResultUtils.error(6002,"");
        }

        int water = cost.getElectric();
        water += money;
        costService.updateWater(cost,water);
        result = ResultUtils.success(cost);

        return result;
    }
}
