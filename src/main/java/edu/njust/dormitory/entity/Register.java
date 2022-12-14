package edu.njust.dormitory.entity;


import javax.persistence.*;

@Entity
@Table(name = "register")
public class Register {
    @Override
    public String toString() {
        return "Register{" +
                "userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", userType=" + userType +
                ", checkRes=" + checkRes +
                '}';
    }

    /**
     * 用户名
     */
    @Id
    @Column(name = "user_name")
    private String userName;
    /**
     * 密码
     */
    @Column(name = "pwd")
    private String pwd;
    /**
     * 姓名
     */
    @Column(name = "name")
    private String name;
    /**
     * 身份证号
     */
    @Column(name = "id")
    private String id;
    /**
     * 用户类型
     */
    @Column(name = "user_type")
    private int userType;
    /**
     * 审核状况
     */
    @Column(name = "check_res")
    private int checkRes;

    public  Register(){

    }
    public  Register(String userName,String pwd,String name,String id,int userType,int checkRes){
        this.userName = userName;
        this.pwd = pwd;
        this.name = name;
        this.id = id;
        this.userType = userType;
        this.checkRes = checkRes;
    }

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

    public int getCheckRes() {
        return checkRes;
    }

    public void setCheckRes(int checkRes) {
        this.checkRes = checkRes;
    }
}
