
import model.Show;
import service.NetflixFilterService;
import service.NetflixFilterServiceImpl;
import common.DateUtil;

import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class MainClass {

    public static void main(String[] args) {
        FileParser fileParser = new FileParserImpl();
        NetflixFilterService netflixFilterService = new NetflixFilterServiceImpl();
        String path = "C:\\Users\\Adityaa\\Desktop\\BingeWatch\\src\\resources\\netflix_titles.csv";
        List<Show> inputList = fileParser.processInputFile(path);

        ScanInput scanInput = new ScanInput().invoke();
        String type = scanInput.getType();
        String listedIn = scanInput.getListedIn();
        String country = scanInput.getCountry();
        Date inputDate = scanInput.getInputDate();
        Date inputToDate = scanInput.getInputToDate();
        int n = scanInput.getN();

        getNetflixData(netflixFilterService, inputList, type, listedIn, country, inputDate, inputToDate, n);
    }

    private static void getNetflixData(NetflixFilterService netflixFilterService, List<Show> inputList, String type, String listedIn, String country, Date inputDate, Date inputToDate, int n) {
        //To get Data by Type
        System.out.println(type + " data");
        List<Show> dataByType = netflixFilterService.getDataByType(inputList, type, inputDate, inputToDate, n);
        dataByType.forEach(x -> System.out.print(x.toString() + " "));

        // To get Data by Listed in
        System.out.println("\n" + listedIn + " data");
        List<Show> dataByListedIn = netflixFilterService.getDataByListedIn(inputList, listedIn, inputDate, inputToDate, n);
        dataByListedIn.forEach(x -> System.out.print(x.toString() + " "));

        // To get Data by Country name and type
        System.out.println("\n" + type + " " + country + " data");
        List<Show> dataByTypeAndCountry = netflixFilterService.getDataByTypeAndCountry(inputList, type, country, inputDate, inputToDate, n);
        dataByTypeAndCountry.forEach(x -> System.out.print(x.toString() + " "));


        //To get data by date
        System.out.println("Data between date");
        List<Show> dataByDate = netflixFilterService.getDataByDate(inputList, inputDate, inputToDate, n);
        dataByDate.forEach(x -> System.out.println(x.toString() + " "));
    }

// To take input from console
    private static class ScanInput {
        private String type;
        private String listedIn;
        private String country;
        private Date inputDate;
        private Date inputToDate;
        private int n;

        public String getType() {
            return type;
        }

        public String getListedIn() {
            return listedIn;
        }

        public String getCountry() {
            return country;
        }

        public Date getInputDate() {
            return inputDate;
        }

        public Date getInputToDate() {
            return inputToDate;
        }

        public int getN() {
            return n;
        }

        public ScanInput invoke() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Type");
            type = sc.nextLine();
            System.out.println("Enter Listed In");
            listedIn = sc.nextLine();
            System.out.println("Enter County Name");
            country = sc.nextLine();
            System.out.println("Enter From Date");
            String date = sc.nextLine();
            inputDate = DateUtil.parseDate(date);
            System.out.println("Enter From Date");
            String dateTo = sc.nextLine();
            inputToDate = DateUtil.parseDate(dateTo);
            System.out.println("Enter Limit");
            n = sc.nextInt();
            System.out.println(inputDate);
            return this;
        }
    }
}
