package edu.njust.dormitory.entity;

import lombok.Data;

@Data
public class Result {
    /**
     * 返回码
     * 0表示正常运行
     * 非0表示出现问题
     */
    private int code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private String message;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}