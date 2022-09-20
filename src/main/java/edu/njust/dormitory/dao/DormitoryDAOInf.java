package edu.njust.dormitory.dao;

import edu.njust.dormitory.entity.Dormitory;
import edu.njust.dormitory.entity.Login;

import java.util.List;

public interface DormitoryDAOInf {
    List<Dormitory> showDormitory();

    Dormitory queryDormitory(Dormitory dormitory);

    void addMember(Dormitory dormitory,Login login);


}
