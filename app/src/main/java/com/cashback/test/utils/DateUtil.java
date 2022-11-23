package com.cashback.test.utils;

public class DateUtil {

    public static String getFormattedDate(String date) {
        // Remove the time component from the date: 2022-11-11 00:00:00 -> 2022-11-11
        String cleanDate = date.split(" ")[0];

        // Return date in format: 25 November
        String[] dateParts = cleanDate.split("-");
        String day = dateParts[2];
        String month = dateParts[1];

        String monthName = getMonthName(month);

        return day + " " + monthName;
    }

    private static String getMonthName(String month) {
        switch (month) {
            case "01":
                return "January";
            case "02":
                return "February";
            case "03":
                return "March";
            case "04":
                return "April";
            case "05":
                return "May";
            case "06":
                return "June";
            case "07":
                return "July";
            case "08":
                return "August";
            case "09":
                return "September";
            case "10":
                return "October";
            case "11":
                return "November";
            case "12":
                return "December";
            default:
                return "";
        }
    }
}
