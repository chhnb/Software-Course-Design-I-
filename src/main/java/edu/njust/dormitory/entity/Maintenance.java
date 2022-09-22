package edu.njust.dormitory.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "maintenance")
public class Maintenance {
    /**
     * 自增长序号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num")
    private long num;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "equipment_id")
    private int equipmentId;

    @Column(name = "Time")
    private Date time;

    @Column(name = "Detail")
    private String detail;
}
