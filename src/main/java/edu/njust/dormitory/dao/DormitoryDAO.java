package edu.njust.dormitory.dao;

import edu.njust.dormitory.entity.Dormitory;
import edu.njust.dormitory.entity.Login;
import edu.njust.dormitory.utils.HibernateUtils;

import java.util.List;

public class DormitoryDAO implements DormitoryDAOInf{
    static HibernateUtils hibernateUtils = new HibernateUtils();

    @Override
    public List<Dormitory> showDormitory() {
        String sql = "select * from dormitory";
        return hibernateUtils.sqlQuery_Dormitory(sql);
    }

    @Override
    public List<Dormitory> showPartDormitory() {
        String sql = "select * from dormitory where number < 4";
        return hibernateUtils.sqlQuery_Dormitory(sql);
    }

    @Override
    public List<Dormitory> queryDormitory(Dormitory dormitory) {
        String sql = "select * from dormitory where id = '"+dormitory.getId()+"'";
        return hibernateUtils.sqlQuery_Dormitory(sql);
    }

    @Override
    public void updateDormitory(Dormitory dormitory) {
        hibernateUtils.update_Dormitory(dormitory);
    }


}
