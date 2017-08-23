package com.hdl.timelineview;

/**
 * 时间段
 * Created by HDL on 2017/8/3.
 */

public class TimeSolt {
    private String timeSolt;//时间段字符串
    private int startTime;//开始时间
    private int endTime;//结束时间

    public TimeSolt() {
    }

    public TimeSolt(String timeSolt, int startTime, int endTime) {
        this.timeSolt = timeSolt;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getTimeSolt() {
        return timeSolt;
    }

    public void setTimeSolt(String timeSolt) {
        this.timeSolt = timeSolt;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "TimeSolt{" +
                "timeSolt='" + timeSolt + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
