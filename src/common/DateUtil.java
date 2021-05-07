package common;

import exceptions.InvalidDateFormatException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static Date parseDate(String date) throws InvalidDateFormatException{
        Date inputDate = null;
        try {
            inputDate = new SimpleDateFormat("yyyy").parse(date);
        } catch (ParseException e) {
          throw new  InvalidDateFormatException(e.getMessage());
        }
        return inputDate;
    }
}
