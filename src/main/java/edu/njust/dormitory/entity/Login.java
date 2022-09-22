package edu.njust.dormitory.entity;

import javax.persistence.*;

@Entity
@Table(name = "login")
public class Login {

    /**
     * 自增长序号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num")
    private long num;

    /**
     * 用户名
     */
    @Column(name = "USER_NAME")
    private String userName;
    /**
     * 密码
     */
    @Column(name = "PWD")
    private String pwd;
    /**
     * 姓名
     */
    @Column(name = "NAME")
    private String name;
    /**
     * 身份证号
     */
    @Column(name = "ID")
    private String id;
    /**
     * 用户类型
     */
    @Column(name = "USER_TYPE")
    private int userType;

    @Column(name = "DORMITORY_ID")
    private int dormitoryId;

    public Login(){
    }

    public Login(String userName,String pwd,String name,String id,int userType){
        this.setUserName(userName);
        this.setPwd(pwd);
        this.setName(name);
        this.setId(id);
        this.setUserType(userType);
    }

    public long getNum(){return num;}
    public void setNum(long num) {this.num = num;}
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getDormitoryId(){return dormitoryId;}
    public void setDormitoryId(int dormitoryId) {this.dormitoryId = dormitoryId;}
}
