package com.demo.security.model;

import java.util.Collection;

/**
 * 查询返回的消息
 */
public class SimpleResult {

    private boolean status = false;

    private String msg;

    private Collection<?> data ;

    public SimpleResult() {
    }

    public SimpleResult(boolean status) {
        this.status = status;
    }

    public SimpleResult(boolean status, Collection<?> data) {
        this.status = status;
        this.data = data;
    }

    public SimpleResult(boolean status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public SimpleResult(boolean status, String msg, Collection<?> data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Collection<?> getData() {
        return data;
    }

    public void setData(Collection<?> data) {
        this.data = data;
    }
}
