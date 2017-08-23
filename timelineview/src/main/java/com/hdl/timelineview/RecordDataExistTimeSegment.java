
package com.hdl.timelineview;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @功能 拿到起止日期的临界值
 */
public class RecordDataExistTimeSegment {
    /**
     * 最左边天0时间（临界值，起点）
     */
    private static long mostLeftDayZeroTime = Long.MAX_VALUE;
    /**
     * 最右边天0时间（临界值，终点）
     */
    private static long mostRightDayZeroTime = -1;
    /**
     * 开始时间
     */
    private long startTimeInMillisecond;
    /**
     * 结束时间
     */
    private long endTimeInMillisecond;
    /**
     * 覆盖时间区域的列表[最小、最大日期]
     */
    private List<Long> coverDateZeroOClockList = new ArrayList<>();

    /**
     * 构造方法
     *
     * @param startTimeInMillisecond 开始时间的毫秒值
     * @param endTimeInMillisecond   结束时间的毫秒值
     */
    public RecordDataExistTimeSegment(long startTimeInMillisecond, long endTimeInMillisecond) {
        this.startTimeInMillisecond = startTimeInMillisecond;
        this.endTimeInMillisecond = endTimeInMillisecond;
        if (startTimeInMillisecond < mostLeftDayZeroTime) {//开始时间小于最左边的时间
            this.mostLeftDayZeroTime = startTimeInMillisecond;//记录最左边时间
        }

        if (endTimeInMillisecond > mostRightDayZeroTime) {//结束时间大于最右边时间
            this.mostRightDayZeroTime = endTimeInMillisecond;//记录最右边时间
        }
        /**
         * 格式化时间
         */
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat zeroTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTimeDateString = dateFormat.format(startTimeInMillisecond);
        String startTimeZeroTimeString = startTimeDateString + " 00:00:00";

        String endTimeDateString = dateFormat.format(endTimeInMillisecond);
        String endTimeZeroTimeString = endTimeDateString + " 00:00:00";
        /**
         *
         * 以上代码的意思是获取startTimeInMillisecond和endTimeInMillisecond所在日期的起始时间.
         * eg:start/end=2017.10.11 10:12：10,那么这个值就是2017.10.11 00:00:00
         */
        try {
            Date startTimeZeroDate = zeroTimeFormat.parse(startTimeZeroTimeString);
            Date endTimeZeroDate = zeroTimeFormat.parse(endTimeZeroTimeString);

            long loopZeroDateInMilliseconds = startTimeZeroDate.getTime();//获取开始时间的毫秒值
            while (loopZeroDateInMilliseconds <= endTimeZeroDate.getTime()) {//结束条件是当前开始时间大于结束时间
                coverDateZeroOClockList.add(loopZeroDateInMilliseconds);
                loopZeroDateInMilliseconds = loopZeroDateInMilliseconds + TimebarView.SECONDS_PER_DAY * 1000;//加上一天的时间
            }
//            for (Long aLong : coverDateZeroOClockList) {
//                Log.e("hdltag", "RecordDataExistTimeSegment(RecordDataExistTimeSegment.java:78):" + zeroTimeFormat.format(new Date(aLong)));
//            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public long getStartTimeInMillisecond() {
        return startTimeInMillisecond;
    }

    public long getEndTimeInMillisecond() {
        return endTimeInMillisecond;
    }

    /**
     * 拿到起止日期
     *
     * @return
     */
    public List<Long> getCoverDateZeroOClockList() {
        return coverDateZeroOClockList;
    }
}