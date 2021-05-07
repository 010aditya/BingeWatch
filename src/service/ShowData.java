package service;

import model.Show;

import java.util.Date;
import java.util.List;

public interface ShowData {

    List<Show> getDataByType(List<Show> inputList, String type,Date fromDate, Date toDate, long n);

    List<Show> getDataByListedIn(List<Show> inputList, String listedIn, Date fromDate, Date toDate,long n);

    List<Show> getDataByTypeAndCountry(List<Show> inputList, String type, String country,Date fromDate, Date toDate, long n);

    List<Show> getDataByDate(List<Show> inputList, Date fromDate, Date toDate, long n);
}

