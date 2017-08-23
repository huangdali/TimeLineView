package com.hdl.timelineview.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 整点判断工具
 * Created by HDL on 2017/8/3.
 */

public class IntegralPointUtils {
    private static IntegralPointUtils mIntegralPointUtils;
    private Calendar calendar;
    private Date date;
    private SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");

    private IntegralPointUtils() {
    }

    public static IntegralPointUtils getInstance() {
        synchronized (IntegralPointUtils.class) {
            if (mIntegralPointUtils == null) {
                mIntegralPointUtils = new IntegralPointUtils();
            }
        }
        return mIntegralPointUtils;
    }

    /**
     * 是否是整点
     *
     * @param currentTime
     * @return
     */
    public boolean isIntegralPoint(long currentTime) {
        if (calendar == null) {
            calendar = Calendar.getInstance();
        }
        if (date == null) {
            date = new Date();
        }
        date.setTime(currentTime);
        calendar.setTime(date);
//        Log.e("hdltag", "isIntegralPoint(IntegralPointUtils.java:45):" + calendar + "------" + date);
        //说明1：这里不能使用==0(会报错)，说明2:考虑到时间轴不能很准，建议在整点的10s以内都算是整点
        if (calendar.get(Calendar.MINUTE) <= 0 && calendar.get(Calendar.SECOND) <= 10) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取上一天
     *
     * @param currentTime
     * @return
     */
    public String getLastDay(long currentTime) {
        if (calendar == null) {
            calendar = Calendar.getInstance();
        }
        calendar.setTime(new Date(currentTime));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 1);
        return formater.format(calendar.getTime());
    }

    /**
     * 获取下一天
     *
     * @param currentTime
     * @return
     */
    public String getNextDay(long currentTime) {
        if (calendar == null) {
            calendar = Calendar.getInstance();
        }
        calendar.setTime(new Date(currentTime));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
        return formater.format(calendar.getTime());
    }
}
