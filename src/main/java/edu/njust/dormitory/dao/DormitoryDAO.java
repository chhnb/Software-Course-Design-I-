package edu.njust.dormitory.dao;

import edu.njust.dormitory.entity.Dormitory;
import edu.njust.dormitory.entity.Login;
import edu.njust.dormitory.utils.HibernateUtils;

import java.util.List;

public class DormitoryDAO implements DormitoryDAOInf{
    static HibernateUtils hibernateUtils = new HibernateUtils();

    @Override
    public List<Dormitory> showDormitory() {
        return null;
    }

    @Override
    public Dormitory queryDormitory(Dormitory dormitory) {
        return null;
    }

    @Override
    public void addMember(Dormitory dormitory, Login login) {

    }
}
