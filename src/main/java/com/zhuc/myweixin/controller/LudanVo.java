package com.zhuc.myweixin.controller;

/**
 * Created by ZHUC on 2015/5/27.
 */
public class LudanVo {

    private Long id;

    private String date;

    private String name;

    private String status;

    private String start;

    private String end;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public LudanVo(Long id, String date, String name, String status, String start, String end) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.status = status;
        this.start = start;
        this.end = end;
    }
}
