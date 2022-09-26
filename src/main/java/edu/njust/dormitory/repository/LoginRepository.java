package edu.njust.dormitory.repository;

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
public interface LoginRepository  extends JpaRepository<Login,Long> {

    /**
     * 根据用户名查询
     */
    @Query("select t from Login t where t.userName = :userName")
    Login findLoginByUserName(@Param("userName") String userName);

    /**
     * 查询未分配宿舍
     */
    @Query("select t from Login t where (t.dormitoryId = 0 and t.userType = 1)")
    List<Login> findHomeless();

    /**
     * 删除
     */
    @Modifying
    @Transactional
    @Query("delete from Login r where r.userName = :userName")
    void deleteLoginByUserName(@Param("userName") String userName);

    /**
     * 根据id修改userName
     */
    @Modifying
    @Transactional
    @Query("update Login u set u.userName = :newUserName where u.userName = :oldUserName")
    void updateUserName(@Param("oldUserName") String oldUserName, @Param("newUserName") String newUserName);

    /**
     * 根据id修改pwd
     */
    @Modifying
    @Transactional
    @Query("update Login u set u.pwd = :pwd where u.userName = :userName")
    void updatePwd(@Param("userName") String userName, @Param("pwd") String pwd);

    @Modifying
    @Transactional
    @Query("update Login u set u.dormitoryId = :dormitoryId where u.userName = :userName")
    void updateDormitoryId(@Param("userName") String userName, @Param("dormitoryId") Integer dormitoryId);
}
