package edu.njust.dormitory.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "maintenance")
public class Maintenance {
    @Override
    public String toString() {
        return "Maintenance{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", equipmentId='" + equipmentId + '\'' +
                ", time=" + time +
                ", detail='" + detail + '\'' +
                ", result=" + result +
                '}';
    }

    /**
     * 自增长序号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Column(name = "user_name")
    private String userName;

    @Column(name = "equipment")
    private String equipmentId;

    @Column(name = "Time")
    private Date time;

    @Column(name = "Detail")
    private String detail;

    @Column(name = "result")
    private int result;
}
