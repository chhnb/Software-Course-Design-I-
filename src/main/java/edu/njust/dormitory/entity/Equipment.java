package edu.njust.dormitory.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "equipment")
public class Equipment {
    /**
     * 自增长序号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num")
    private long num;

    @Column(name = "Last_Check")
    private Date lastCheck;

    @Column(name = "state")
    private boolean state;
}
