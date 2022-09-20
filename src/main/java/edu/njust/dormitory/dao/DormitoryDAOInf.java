package edu.njust.dormitory.dao;

import edu.njust.dormitory.entity.Dormitory;
import edu.njust.dormitory.entity.Login;

import java.util.List;

public interface DormitoryDAOInf {
    List<Dormitory> showDormitory();

    List<Dormitory> showPartDormitory();

    List<Dormitory> queryDormitory(Dormitory dormitory);

    void updateDormitory(Dormitory dormitory);


}
