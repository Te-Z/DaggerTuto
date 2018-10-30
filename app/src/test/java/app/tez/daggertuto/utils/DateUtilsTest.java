package app.tez.daggertuto.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Terence Zafindratafa on 29/10/2018
 */
public class DateUtilsTest extends DateUtils {

    @Override
    public Date getCurrentDate() {
        return generateTestCurrentDate();
    }

    private Date generateTestCurrentDate(){
        Calendar mCalendar = Calendar.getInstance();
        mCalendar.set(1991, 9, 19, 0, 0, 0);

        return mCalendar.getTime();
    }
}
