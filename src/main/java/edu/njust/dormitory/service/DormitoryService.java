package edu.njust.dormitory.service;

import edu.njust.dormitory.dao.DormitoryDAO;
import edu.njust.dormitory.dao.LoginDAO;
import edu.njust.dormitory.entity.Dormitory;
import edu.njust.dormitory.entity.Login;

import java.util.List;
import java.util.Objects;

public class DormitoryService {

    static DormitoryDAO dormitoryDAO = new DormitoryDAO();
    static LoginDAO loginDAO = new LoginDAO();

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

        login = loginDAO.getInfo(login);
        login.setDormitoryId(dormitory.getId());

        int memberNumber = dormitory.getNumber();
        memberNumber = memberNumber+1;
        dormitory.setNumber(memberNumber);

        if(dormitory.getPeopleNum1() != null){
            if(dormitory.getPeopleNum2() != null){
                if(dormitory.getPeopleNum3() != null){
                    dormitory.setPeopleNum4(userName);
                }else{
                    dormitory.setPeopleNum3(userName);
                }
            }else{
                dormitory.setPeopleNum2(userName);
            }
        }else{
            dormitory.setPeopleNum1(userName);
        }

        loginDAO.updateLogin(login);
        dormitoryDAO.updateDormitory(dormitory);
    }

    public void delMember(Dormitory dormitory,Login login){
        String userName = login.getUserName();

        login.setDormitoryId(0);

        int memberNumber = dormitory.getNumber();
        memberNumber = memberNumber-1;
        dormitory.setNumber(memberNumber);

        if(!Objects.equals(dormitory.getPeopleNum1(), userName)){
            if(!Objects.equals(dormitory.getPeopleNum2(), userName)){
                if(!Objects.equals(dormitory.getPeopleNum3(), userName)){
                    dormitory.setPeopleNum4(null);
                }else{
                    dormitory.setPeopleNum3(null);
                }
            }else{
                dormitory.setPeopleNum2(null);
            }
        }else{
            dormitory.setPeopleNum1(null);
        }

        loginDAO.updateLogin(login);
        dormitoryDAO.updateDormitory(dormitory);
    }

    public List<Dormitory> queryAllDormitory(){
        return dormitoryDAO.showDormitory();
    }

    public List<Dormitory> queryPartDormitory(){
        return dormitoryDAO.showPartDormitory();
    }

    public List<Login> queryHomeless(){
        return loginDAO.queryHomeless();
    }
}
