package service;

import model.Show;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class NetflixFilterServiceImpl implements NetflixFilterService {

    @Override
    public List<Show> getDataByType(List<Show> inputList, String type, Date fromDate, Date toDate, long n) {
        return inputList.stream()
                .filter(x -> x.getType() != null && x.getReleaseYear() != null)
                .filter(x -> x.getReleaseYear().after(fromDate) && x.getReleaseYear().before(toDate))
                .filter(x -> x.getType().equalsIgnoreCase(type)).limit(n)
                .collect(Collectors.toList());
    }

    @Override
    public List<Show> getDataByListedIn(List<Show> inputList, String listedIn, Date fromDate, Date toDate, long n) {
        return inputList.stream()
                .filter(x -> x.getListedIn() != null && x.getReleaseYear() != null)
                .filter(x -> x.getReleaseYear().after(fromDate) && x.getReleaseYear().before(toDate))
                .filter(x -> x.getListedIn().contains(listedIn)).limit(n)
                .collect(Collectors.toList());
    }

    @Override
    public List<Show> getDataByTypeAndCountry(List<Show> inputList, String type, String country, Date fromDate, Date toDate, long n) {
        return inputList.stream().filter(x -> x.getType() != null && x.getCountry() != null && x.getReleaseYear() != null)
                .filter(x -> x.getReleaseYear().after(fromDate) && x.getReleaseYear().before(toDate))
                .filter(x -> x.getType().equalsIgnoreCase(type) && x.getCountry().equalsIgnoreCase(country)).limit(n)
                .collect(Collectors.toList());
    }

    @Override
    public List<Show> getDataByDate(List<Show> inputList, Date fromDate, Date toDate, long n) {
        return inputList.stream()
                .filter(x -> x.getReleaseYear() != null)
                .filter(x -> x.getReleaseYear().after(fromDate) && x.getReleaseYear().before(toDate))
                .limit(n).collect(Collectors.toList());
    }

}