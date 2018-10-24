package app.tez.daggertuto.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

/**
 * Created by Terence Zafindratafa on 24/10/2018
 */
public class DateUtils {

    private Date mDate;
    private SimpleDateFormat formatter;

    @Inject
    public DateUtils(Date date) {
        this.mDate = date;
        formatter = new SimpleDateFormat("dd/MM/yyyy");
    }

    public String getCurrentDate(){
        return formatter.format(mDate);
    }
}
