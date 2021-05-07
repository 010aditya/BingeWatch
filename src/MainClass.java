
import model.Show;
import service.ShowData;
import service.ShowDataImpl;
import util.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class MainClass {

    public static void main(String[] args) {
        FileProcessor fileProcessor = new FileProcessorImpl();
        ShowData showData = new ShowDataImpl();
        String path = "C:\\Users\\Adityaa\\Desktop\\BingeWatch\\src\\resources\\netflix_titles.csv";
        List<Show> inputList = fileProcessor.processInputFile(path);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Type");
        String type = sc.nextLine();
        System.out.println("Enter Listed In");
        String listedIn = sc.nextLine();
        System.out.println("Enter County Name");
        String country = sc.nextLine();
        System.out.println("Enter From Date");
        String date = sc.nextLine();
        Date inputDate = DateUtil.parseDate(date);
        System.out.println("Enter From Date");
        String dateTo = sc.nextLine();
        Date inputToDate = DateUtil.parseDate(dateTo);
        System.out.println("Enter Limit");
        int n = sc.nextInt();
        System.out.println(inputDate);




        //To get Data by Type
        System.out.println(type + " data");
        List<Show> tvShowRecords = showData.getDataByType(inputList, type,inputDate,inputToDate, n);
        tvShowRecords.forEach(x -> System.out.print(x.toString() + " "));

        // To get Data by Listed in
        System.out.println("\n" + listedIn + " data");
        List<Show> horrorMoviesRecords = showData.getDataByListedIn(inputList, listedIn,inputDate,inputToDate , n);
        horrorMoviesRecords.forEach(x -> System.out.print(x.toString() + " "));

        // To get Data by Country name and type
        System.out.println("\n" + type + " " + country + " data");
        List<Show> movieShowsFromIndia = showData.getDataByTypeAndCountry(inputList, type, country,inputDate,inputToDate , n);
        movieShowsFromIndia.forEach(x -> System.out.print(x.toString() + " "));


        //To get data by date
        System.out.println("Data between date");
        List<Show> movieShowsByDate = showData.getDataByDate(inputList, inputDate, inputDate, n);
        movieShowsByDate.forEach(x -> System.out.println(x.toString() + " "));
    }



}
