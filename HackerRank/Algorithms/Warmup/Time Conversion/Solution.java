// https://www.hackerrank.com/challenges/time-conversion

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static String timeConversion(String s) {
        String time = s.substring(0, 8);
        String format = s.substring(8, 10);

        if (format.equals("PM")) {
            String[] split = time.split(":");
            if (split[0].equals("12")) {
                return time;
            } else {
                return (Integer.parseInt(split[0]) + 12) + ":" + split[1] + ":" + split[2];
            }
        } else {
            String[] split = time.split(":");
            if (split[0].equals("12")) {
                return "00:" + split[1] + ":" + split[2];
            } else {
                return time;
            }
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
