package edu.njust.dormitory.entity;

import javax.persistence.*;

@Entity
@Table(name = "dormitory")
public class Dormitory {
    /**
     * 自增长宿舍编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    /**
     * 宿舍人员数量
     */
    @Column(name = "Number")
    private int number;
    /**
     * 宿舍是否通电
     */
    @Column(name = "Electric")
    private int electric;
    /**
     * 宿舍人员用户名1
     */
    @Column(name = "People_num1")
    private String peopleNum1;
    /**
     * 宿舍人员用户名2
     */
    @Column(name = "People_num2")
    private String peopleNum2;
    /**
     * 宿舍人员用户名3
     */
    @Column(name = "People_num3")
    private String peopleNum3;
    /**
     * 宿舍人员用户名4
     */
    @Column(name = "People_num4")
    private String peopleNum4;

    public Dormitory(){}

    public Dormitory(int id,int number,int electric,String peopleNum1,String peopleNum2,String peopleNum3,String peopleNum4){
        this.id = id;
        this.number = number;
        this.electric = electric;
        this.peopleNum1 = peopleNum1;
        this.peopleNum2 = peopleNum2;
        this.peopleNum3 = peopleNum3;
        this.peopleNum4 = peopleNum4;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getElectric() {
        return electric;
    }

    public void setElectric(int electric) {
        this.electric = electric;
    }

    public String getPeopleNum1() {
        return peopleNum1;
    }

    public void setPeopleNum1(String peopleNum1) {
        this.peopleNum1 = peopleNum1;
    }

    public String getPeopleNum2() {
        return peopleNum2;
    }

    public void setPeopleNum2(String peopleNum2) {
        this.peopleNum2 = peopleNum2;
    }

    public String getPeopleNum3() {
        return peopleNum3;
    }

    public void setPeopleNum3(String peopleNum3) {
        this.peopleNum3 = peopleNum3;
    }

    public String getPeopleNum4() {
        return peopleNum4;
    }

    public void setPeopleNum4(String peopleNum4) {
        this.peopleNum4 = peopleNum4;
    }
}