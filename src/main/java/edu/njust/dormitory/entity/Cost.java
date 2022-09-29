package edu.njust.dormitory.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cost")
public class Cost {
    @Override
    public String toString() {
        return "Cost{" +
                "dormitoryId=" + dormitoryId +
                ", electric=" + electric +
                ", water=" + water +
                ", power=" + power +
                '}';
    }

    public int getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(int dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public int getElectric() {
        return electric;
    }

    public void setElectric(int electric) {
        this.electric = electric;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    /**
     * 宿舍编号
     */
    @Id
    @Column(name = "Dormitory_Id")
    private int dormitoryId;
    /**
     * 宿舍剩余电费
     */
    @Column(name = "Electric")
    private int electric;
    /**
     * 宿舍剩余水费
     */
    @Column(name = "Water")
    private int water;
    /**
     * 宿舍近期最大功率
     */
    @Column(name = "power")
    private int power;
}
