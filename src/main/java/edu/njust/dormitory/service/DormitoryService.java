package edu.njust.dormitory.service;

import edu.njust.dormitory.entity.Dormitory;
import edu.njust.dormitory.entity.Login;
import edu.njust.dormitory.repository.DormitoryRepository;
import edu.njust.dormitory.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
@Service
public class DormitoryService {


    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private DormitoryRepository dormitoryRepository;

    public Dormitory getInfo(Dormitory dormitory){
        return dormitoryRepository.findDormitoryById(dormitory.getId());
    }
    public void addMember(Dormitory dormitory,Login login){
        String userName = login.getUserName();
        loginRepository.updateDormitoryId(userName,dormitory.getId());

        int memberNumber = dormitory.getNumber();
        memberNumber = memberNumber+1;
        dormitoryRepository.updateNumber(dormitory.getId(),memberNumber);

        if(dormitory.getPeopleNum1() != null){
            if(dormitory.getPeopleNum2() != null){
                if(dormitory.getPeopleNum3() != null){
                    dormitoryRepository.updatePeople4(dormitory.getId(),userName);
                }else{
                    dormitoryRepository.updatePeople3(dormitory.getId(),userName);
                }
            }else{
                dormitoryRepository.updatePeople2(dormitory.getId(),userName);
            }
        }else{
            dormitoryRepository.updatePeople1(dormitory.getId(),userName);
        }
    }

    public void delMember(Dormitory dormitory,Login login){
        String userName = login.getUserName();
        loginRepository.updateDormitoryId(userName,0);

        int memberNumber = dormitory.getNumber();
        memberNumber = memberNumber-1;
        dormitoryRepository.updateNumber(dormitory.getId(),memberNumber);
        dormitory = dormitoryRepository.findDormitoryById(dormitory.getId());

        if(!Objects.equals(dormitory.getPeopleNum1(), userName)){
            if(!Objects.equals(dormitory.getPeopleNum2(), userName)){
                if(!Objects.equals(dormitory.getPeopleNum3(), userName)){
                    dormitoryRepository.updatePeople4(dormitory.getId(),null);
                }else{
                    dormitoryRepository.updatePeople3(dormitory.getId(),null);
                }
            }else{
                dormitoryRepository.updatePeople2(dormitory.getId(),null);
            }
        }else{
            dormitoryRepository.updatePeople1(dormitory.getId(),null);
        }
    }

    public List<Dormitory> queryAllDormitory(){
        return dormitoryRepository.findAllDormitory();
    }

    public List<Dormitory> queryPartDormitory(){
        return dormitoryRepository.findPartDormitory();
    }

    public List<Login> queryHomeless(){
        return loginRepository.findHomeless();
    }

    public void updateUserName(Login oldLogin,Login newLogin){
        dormitoryRepository.updateUserName1(oldLogin.getUserName(),newLogin.getUserName());
        dormitoryRepository.updateUserName2(oldLogin.getUserName(),newLogin.getUserName());
        dormitoryRepository.updateUserName3(oldLogin.getUserName(),newLogin.getUserName());
        dormitoryRepository.updateUserName4(oldLogin.getUserName(),newLogin.getUserName());
    }
}
