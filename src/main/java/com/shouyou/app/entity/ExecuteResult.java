package com.shouyou.app.entity;

import java.util.List;

/**
 * Created by 01436296 on 2017/6/14.
 */
public class ExecuteResult<T> {
    private int status;
    private String message;
    private T t;
    private List<T> list;

    public ExecuteResult(){}
    public ExecuteResult(int status){
        this.status = status;
    }
    public ExecuteResult(int status,String message){
        this.message = message;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
