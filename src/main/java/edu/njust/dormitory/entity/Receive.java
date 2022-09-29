package edu.njust.dormitory.entity;

import lombok.Data;

@Data
public class Receive {
    @Override
    public String toString() {
        return "Receive{" +
                "token='" + token + '\'' +
                ", userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", money=" + money +
                ", resultNum=" + resultNum +
                ", errorCode=" + errorCode +
                '}';
    }

    String token;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getResultNum() {
        return resultNum;
    }

    public void setResultNum(int resultNum) {
        this.resultNum = resultNum;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    String userName;
    String pwd;
    int money;
    int resultNum;
    int errorCode;
}
