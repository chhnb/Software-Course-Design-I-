package edu.njust.dormitory.utils;

import edu.njust.dormitory.entity.Cost;
import edu.njust.dormitory.entity.Dormitory;
import edu.njust.dormitory.entity.Login;
import edu.njust.dormitory.entity.Register;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HibernateUtils {

    /**
     * 传统sql语句操作Hibernate进行查询
     */
    public List<Login> sqlQuery_LoginEntity(String sql){
        List<Login> res;

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        NativeQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.addEntity(Login.class);
        res = sqlQuery.getResultList();

        transaction.commit();
        session.close();
        sessionFactory.close();

        return res;
    }
    /**
     * 新增数据并返回对应主键
     */
    public void insert_LoginEntity(Login loginEntity){
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Serializable save = session.save(loginEntity);
        System.out.println("新数据主键id：" + save);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
    /**
     * 根据主键更新数据
     */
    public void update_LoginEntity(Login loginEntity){
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(loginEntity);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
    /**
     * 删除记录
     */
    public void delete_LoginEntity(Login loginEntity){
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(loginEntity);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    /**
     * 传统sql语句操作Hibernate进行查询
     */
    public List<Register> sqlQuery_RegisterEntity(String sql){
        List<Register> res;

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        NativeQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.addEntity(Register.class);
        res = sqlQuery.getResultList();

        transaction.commit();
        session.close();
        sessionFactory.close();

        return res;
    }
    /**
     * 新增数据并返回对应主键
     */
    public void insert_RegisterEntity(Register registerEntity){
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Serializable save = session.save(registerEntity);
        System.out.println("新数据主键id：" + save);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
    /**
     * 根据主键更新数据
     */
    public void update_RegisterEntity(Register registerEntity){
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(registerEntity);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
    /**
     * 删除记录
     */
    public void delete_RegisterEntity(Register registerEntity){
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(registerEntity);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    /**
     * 传统sql语句操作Hibernate进行查询
     */
    public List<Dormitory> sqlQuery_Dormitory(String sql){
        List<Dormitory> res;

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        NativeQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.addEntity(Dormitory.class);
        res = sqlQuery.getResultList();

        transaction.commit();
        session.close();
        sessionFactory.close();

        return res;
    }
    /**
     * 新增数据并返回对应主键
     */
    public void insert_Dormitory(Dormitory dormitory){
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Serializable save = session.save(dormitory);
        System.out.println("新数据主键id：" + save);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
    /**
     * 根据主键更新数据
     */
    public void update_Dormitory(Dormitory dormitory){
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(dormitory);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
    /**
     * 删除记录
     */
    public void delete_Dormitory(Dormitory dormitory){
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(dormitory);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
    /**
     * 传统sql语句操作Hibernate进行查询
     */
    public List<Cost> sqlQuery_Cost(String sql){
        List<Cost> res;

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        NativeQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.addEntity(Cost.class);
        res = sqlQuery.getResultList();

        transaction.commit();
        session.close();
        sessionFactory.close();

        return res;
    }
    /**
     * 根据主键更新数据
     */
    public void update_Cost(Cost cost){
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(cost);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }

}
