package com.entity;

import java.time.LocalTime;

// 定义时间区间结构
public class Time {
    private String time;
    private boolean[] bool;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean[] getBool() {
        return bool;
    }

    public void setBool(boolean[] bool) {
        this.bool = bool;
    }
}
