package com.blink.dagger.democache;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {

    /**
     * @param time
     * @return 转换方法
     */
    public static String getTime(long time) {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat  df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(time);
        return df.format(date);
    }
}
