package timerulers.yongxiang.com.timerulerslib.views.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具
 * Created by HDL on 2017/7/25.
 */

public class DateUtils {
    /**
     * 获取当前时间的起点（00:00:00）
     *
     * @param currentTime
     * @return
     */
    public static long getTodayStart(long currentTime) {
        Date curDate = new Date(currentTime);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(currentTime));
        // calendar.setTime(curDate);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return calendar.getTimeInMillis();
    }

    /**
     * 获取当前时间的终点（23:59:59）
     *
     * @param currentTime
     * @return
     */
    public static long getTodayEnd(long currentTime) {
        return getTodayStart(currentTime) + 24 * 60 * 60 * 1000L - 1000;
    }

    /**
     * 获取指定时间的年月日
     *
     * @param currentTime
     * @return
     */
    public static String getDateByCurrentTiem(long currentTime) {
        return new SimpleDateFormat("yyyy-MM-dd").format(currentTime);
    }

    /**
     * 获取指定日期的时间（如：10:11:12）
     *
     * @param currentTime
     * @return
     */
    public static String getTime(long currentTime) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        return format.format(new Date(currentTime));
    }
}
