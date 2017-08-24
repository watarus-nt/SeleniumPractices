package utils.DataGenerator;

import org.fluttercode.datafactory.impl.DataFactory;

import java.util.Date;

public class DataFactoryUtils {

    private DataFactory df;

    public DataFactoryUtils() {
        df = new DataFactory();
    }

    public static void main(String[] args) {
        DataFactoryUtils dataFactoryUtils = new DataFactoryUtils();
        DataFactory df = new DataFactory();
/*
        dataFactoryUtils.createHumanBasicInfo();
        dataFactoryUtils.createRandomDate(1970, 1, 1);



        //favorite animal
        //get value from a list bases on input probability
        String[] values = {"Cat","Dog","Goat","Horse","Sheep"};
        for (int i = 0; i < 10; i++) {
            System.out.println(df.getItem(values,80,"None"));
        }
*/

        for (int i = 0; i < 10; i++) {
            System.out.println("getRandomText: " + df.getRandomText(2, 8));
            System.out.println("getRandomChars: " + df.getRandomChars(20));
            System.out.println("getRandomWord: " + df.getRandomWord(4, 10));
            System.out.println("-------------------------------");
        }
    }

    public String generateFirstName() {
        return df.getFirstName();
    }

    public String generateLastName() {
        return df.getLastName();
    }

    public String generateAddress() {
        return df.getAddress() + "," + df.getCity() + "," + df.getNumberText(5);
    }

    public String generateBussinessName() {
        return df.getBusinessName();
    }

    public String generateBirthday() {
        return String.valueOf(df.getBirthDate());
    }

    public void createRandomDate(int year, int month, int day) {
        Date minDate = df.getDate(2000, 1, 1);
        Date maxDate = new Date();

        for (int i = 0; i < 10; i++) {
            Date start = df.getDateBetween(minDate, maxDate);
            Date end = df.getDateBetween(start, maxDate);
            System.out.println("Date range = " + dateToString(start) + " to " + dateToString(end));
        }
    }

    public void createHumanBasicInfo() {
        for (int i = 0; i < 5; i++) {
            System.out.println("-----------------------" + i + "-----------------------");
            String name = df.getFirstName() + " " + df.getLastName();
            System.out.println(name);
            System.out.println(df.getBirthDate());
            System.out.println(df.getBusinessName());
            System.out.println(generateAddress());
        }
    }

    private String dateToString(Date date) {
        return String.valueOf(date);
    }
}