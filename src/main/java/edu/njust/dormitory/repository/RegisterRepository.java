package edu.njust.dormitory.repository;

import edu.njust.dormitory.entity.Register;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public interface RegisterRepository extends JpaRepository<Register,Long> {
    /**
     * 根据用户名查询
     */
    @Query("select t from Register t where t.userName = :userName")
    Register findByUserName(@Param("userName") String userName);

    /**
     * 查询未审核
     */
    @Query("select t from Register t where t.checkRes = 0")
    List<Register> findUnchecked();

    /**
     * 删除
     */
    @Modifying
    @Transactional
    @Query("delete from Register r where r.userName = :userName")
    void deleteRegisterByUserName(@Param("userName") String userName);

    /**
     * 根据userName修改checkRes
     */
    @Modifying
    @Transactional
    @Query("update Register r set r.checkRes = :checkRes where r.userName = :userName")
    void updateCheckResByUserName(@Param("userName") String userName, @Param("checkRes") Integer checkRes);


}
