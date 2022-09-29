package edu.njust.dormitory.repository;

import edu.njust.dormitory.entity.Dormitory;
import edu.njust.dormitory.entity.Login;
import edu.njust.dormitory.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DormitoryRepository  extends JpaRepository<Dormitory,Long> {

    @Query("select t from Dormitory t where t.id = :id")
    Dormitory findDormitoryById(@Param("id") Integer id);

    @Query("select t from Dormitory t")
    List<Dormitory> findAllDormitory();

    @Query("select t from Dormitory t where t.number < 4")
    List<Dormitory> findPartDormitory();

    @Modifying
    @Transactional
    @Query("update Dormitory u set u.number = :number where u.id = :id")
    void updateNumber(@Param("id") Integer id, @Param("number") Integer number);

    @Modifying
    @Transactional
    @Query("update Dormitory u set u.peopleNum1 = :newUserName where u.id = :id")
    void updatePeople1(@Param("id") Integer id, @Param("newUserName") String newUserName);

    @Modifying
    @Transactional
    @Query("update Dormitory u set u.peopleNum2 = :newUserName where u.id = :id")
    void updatePeople2(@Param("id") Integer id, @Param("newUserName") String newUserName);

    @Modifying
    @Transactional
    @Query("update Dormitory u set u.peopleNum3 = :newUserName where u.id = :id")
    void updatePeople3(@Param("id") Integer id, @Param("newUserName") String newUserName);

    @Modifying
    @Transactional
    @Query("update Dormitory u set u.peopleNum4 = :newUserName where u.id = :id")
    void updatePeople4(@Param("id") Integer id, @Param("newUserName") String newUserName);

    @Modifying
    @Transactional
    @Query("update Dormitory u set u.peopleNum1 = :newUserName where u.peopleNum1 = :oldUserName")
    void updateUserName1(@Param("oldUserName") String oldUserName, @Param("newUserName") String newUserName);
    @Modifying
    @Transactional
    @Query("update Dormitory u set u.peopleNum2 = :newUserName where u.peopleNum2 = :oldUserName")
    void updateUserName2(@Param("oldUserName") String oldUserName, @Param("newUserName") String newUserName);
    @Modifying
    @Transactional
    @Query("update Dormitory u set u.peopleNum3 = :newUserName where u.peopleNum3 = :oldUserName")
    void updateUserName3(@Param("oldUserName") String oldUserName, @Param("newUserName") String newUserName);
    @Modifying
    @Transactional
    @Query("update Dormitory u set u.peopleNum4 = :newUserName where u.peopleNum4 = :oldUserName")
    void updateUserName4(@Param("oldUserName") String oldUserName, @Param("newUserName") String newUserName);
}
