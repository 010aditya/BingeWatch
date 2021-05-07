package common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static Date parseDate(String date) {
        Date inputDate = null;
        try {
            inputDate = new SimpleDateFormat("yyyy").parse(date);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return inputDate;
    }
}
