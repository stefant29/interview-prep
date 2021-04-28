package interview;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.time.LocalDate;

class Result {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

    public static String findDay(int month, int day, int year) {
    	 // JAVA 7
//        Calendar c = Calendar.getInstance();
//        c.set(year, month - 1, day);
//        System.out.println(c.DAY_OF_WEEK);
//        
//        switch (c.get(Calendar.DAY_OF_WEEK)) {
//            case 1:
//                return "SUNDAY";
//            case 2:
//                return "MONDAY";
//            case 3:
//                return "TUESDAY";
//            case 4:
//                return "WEDNESDAY";
//            case 5:
//                return "THURSDAY";
//            case 6:
//                return "FRIDAY";
//            case 7:
//                return "SATURDAY";
//            default:
//                return "";
//        }
        
        // JAVA 8
        LocalDate date = LocalDate.of(year, month, day);
        return date.getDayOfWeek().toString();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
    	System.out.println(Result.findDay(8, 14, 2017));
    }
}
