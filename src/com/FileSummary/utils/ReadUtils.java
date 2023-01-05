package com.FileSummary.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadUtils {

    private BufferedReader reader;
    public ReadUtils() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public int readInt(String userMsg, String errMsg) {
        int val = 0;
        System.out.println(userMsg);
        try {
            val = Integer.parseInt(reader.readLine());
        }
        catch (NumberFormatException e) {
            System.out.println("please enter a valid input");
            val = readInt(userMsg, errMsg);
        }
        catch (IOException e) {
            System.out.println("The input is wrong, please enter again!");
        }
        return val;
    }

    public String readString(String userMsg, String errMsg) {

        String str = "";

        try {
            System.out.println(userMsg);
            str = reader.readLine();
            if (str.trim().length() == 0) {
                System.out.println(errMsg);
                str = readString(userMsg, errMsg);
            }
        }
        catch (IOException e) {
            System.out.println("The input is wrong, please enter again!");
        }
        return str;
    }

    public Double readDouble(String userMsg, String errMsg) {

        Double dob = 0.0;

        try {
            System.out.println(userMsg);
            dob = Double.parseDouble(reader.readLine());
        }
        catch (NumberFormatException e) {
            System.out.println(errMsg);
            dob = readDouble(userMsg, errMsg);
        }
        catch (IOException e) {
            System.out.println("The input is wrong, please enter again!");
        }
        return dob;
    }

    public Date readDate(String userMsg, String errMsg) {

        Date date = null;
        SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");

        try {
            System.out.println(userMsg);
            date = (Date)format.parse(reader.readLine());
        }
        catch (ParseException e) {
            System.out.println(errMsg);
            date = readDate(userMsg, errMsg);
        }
        catch (IOException e) {
            System.out.println("The input is wrong, please enter again!");
        }
        return date;
    }
}
