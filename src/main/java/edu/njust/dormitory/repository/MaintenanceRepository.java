package edu.njust.dormitory.repository;

import edu.njust.dormitory.entity.Maintenance;
import edu.njust.dormitory.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MaintenanceRepository  extends JpaRepository<Maintenance,Long> {
    /**
     * 根据报修编号查询
     */
    @Query("select t from Maintenance t where t.id = :id")
    Maintenance findById(@Param("id") int id);

    /**
     * 查询未确认
     */
    @Query("select t from Maintenance t where t.result = 0")
    List<Maintenance> findUnchecked();

    /**
     * 删除
     */
    @Modifying
    @Transactional
    @Query("delete from Maintenance t where t.id = :id")
    void deleteMaintenanceById(@Param("id") int id);

    /**
     * 根据userName修改checkRes
     */
    @Modifying
    @Transactional
    @Query("update Maintenance t set t.result = :result where t.id = :id")
    void updateMaintenanceById(@Param("id") int id, @Param("result") Integer result);

    @Modifying
    @Transactional
    @Query("update Maintenance t set t.userName = :newUserName where t.userName = :oldUserName")
    void updateUserName(@Param("oldUserName") String oldUserName, @Param("newUserName") String newUserName);
}
