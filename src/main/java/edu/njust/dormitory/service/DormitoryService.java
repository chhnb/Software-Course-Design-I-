package edu.njust.dormitory.service;

import edu.njust.dormitory.dao.DormitoryDAO;
import edu.njust.dormitory.entity.Dormitory;
import edu.njust.dormitory.entity.Login;

import java.util.List;

public class DormitoryService {

    static DormitoryDAO dormitoryDAO = new DormitoryDAO();

    public Dormitory getInfo(Dormitory dormitory){
        List<Dormitory> dormitoryList = dormitoryDAO.queryDormitory(dormitory);
        if(dormitoryList == null)
            return null;
        for(Dormitory tmp: dormitoryList){
            dormitory.setId(tmp.getId());
            dormitory.setNumber(tmp.getNumber());
            dormitory.setElectric(tmp.getElectric());
            dormitory.setPeopleNum1(tmp.getPeopleNum1());
            dormitory.setPeopleNum2(tmp.getPeopleNum2());
            dormitory.setPeopleNum3(tmp.getPeopleNum3());
            dormitory.setPeopleNum4(tmp.getPeopleNum4());
        }
        return dormitory;
    }
    public void addMember(Dormitory dormitory,Login login){
        String userName = login.getUserName();
        int memberNumber = dormitory.getNumber();
        memberNumber = memberNumber+1;
        switch (memberNumber){
            case 1:{
                dormitory.setPeopleNum1(userName);
                break;
            }
            case 2:{
                dormitory.setPeopleNum2(userName);
                break;
            }
            case 3:{
                dormitory.setPeopleNum3(userName);
                break;
            }
            case 4:{
                dormitory.setPeopleNum4(userName);
                break;
            }
        }
        dormitoryDAO.updateDormitory(dormitory);
    }

    public List<Dormitory> queryAllDormitory(){
        return dormitoryDAO.showDormitory();
    }

    public List<Dormitory> queryPartDormitory(){
        return dormitoryDAO.showPartDormitory();
    }
}
