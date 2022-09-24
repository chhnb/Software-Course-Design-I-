package edu.njust.dormitory.repository;

import edu.njust.dormitory.entity.Cost;
import edu.njust.dormitory.entity.Dormitory;
import edu.njust.dormitory.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CostRepository  extends JpaRepository<Register,Long> {

    @Query("select t from Cost t")
    List<Cost> findAllCost();

    @Query("select t from Cost t where t.dormitoryId = :id")
    Cost findById(@Param("id") Integer id);

    @Query("select t from Cost t where t.electric > 200")
    List<Cost> findPartCost();

    @Modifying
    @Transactional
    @Query("update Cost u set u.electric = :electric where u.dormitoryId = :id")
    void updateElectric(@Param("id") Integer id, @Param("electric") Integer electric);

    @Modifying
    @Transactional
    @Query("update Cost u set u.water = :water where u.dormitoryId = :id")
    void updateWater(@Param("id") Integer id,@Param("water") Integer water);

    @Modifying
    @Transactional
    @Query("update Cost u set u.power = :power where u.dormitoryId = :id")
    void updatePower(@Param("id") Integer id, @Param("power") Integer power);
}
