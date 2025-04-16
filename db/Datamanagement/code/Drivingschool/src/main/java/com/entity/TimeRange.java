package com.entity;

import java.time.LocalTime;

// 定义时间区间结构
public class TimeRange {
    private LocalTime start;
    private LocalTime end;

    public TimeRange(String startStr, String endStr) {
        this.start = LocalTime.parse(startStr);
        this.end = LocalTime.parse(endStr);
    }

    public LocalTime getStart() { return start; }
    public LocalTime getEnd() { return end; }
}
