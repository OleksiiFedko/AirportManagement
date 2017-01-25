package userinterface.utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import userinterface.controllers.PassengersEditingController;

import java.util.Calendar;

public class DateUtils {
    private static ObservableList<String> monthList = FXCollections.observableArrayList();
    private static ObservableList<String> yearList = FXCollections.observableArrayList();
    private static ObservableList<String> dayList = FXCollections.observableArrayList();
    private static int amountOfDays;
    private static final int AMOUNT_OF_MONTH = 12;
    private static int currentYear;

    public static ObservableList<String> getMonthList() {
        for (int i = 1; i <= AMOUNT_OF_MONTH; i++) {
            if (i < 10) {
                monthList.add("0" + i);
            } else {
                monthList.add("" + i);
            }
        }
        return monthList;
    }

    public static ObservableList<String> getYearList(){
        Calendar calendar = Calendar.getInstance();
        currentYear = calendar.get(Calendar.YEAR);
        for(int i = (currentYear - 90); i <= currentYear; i++){
            yearList.add(i + "");
        }
        return yearList;
    }

    public static ObservableList<String> getDayList(String selectedMonth, String selectedYear) {
        int intYear = Integer.parseInt(selectedYear);
        int intMonth = Integer.parseInt(selectedMonth);
        if (intMonth == 1 || intMonth == 3 || intMonth == 5 || intMonth == 7 ||
                intMonth == 8 || intMonth == 10 || intMonth == 12) {
            amountOfDays = 31;
        } else if (intMonth == 2){
            if(intYear % 4 == 0) {
                amountOfDays = 29;
            } else {
                amountOfDays = 28;
            }
        } else {
            amountOfDays = 30;
        }
        for(int i = 1; i <= amountOfDays; i++){
            if (i < 10) {
                dayList.add("0" + i);
            } else {
                dayList.add("" + i);
            }
        }
        return dayList;
    }

    public static void parseDate(PassengersEditingController pEController, String birthday){
        char[] array = birthday.toCharArray();
        String day = array[0] + "" + array[1];
        String month = array[3] + "" + array[4];
        String year = array[6] + "" + array[7] + "" + array[8] + "" + array[9];
        pEController.setDay(day);
        pEController.setMonth(month);
        pEController.setYear(year);
    }
}


