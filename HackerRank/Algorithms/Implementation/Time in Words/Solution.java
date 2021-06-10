import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    
    public static String[] digits = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    
    public static String[] decimals = {"twenty", "thirty", "forty", "fifty"};
    
    public static String timeInWords(int h, int m) {
        String link;
        
        if (m == 0) {
            return digits[h-1] + " o' clock";
        } else if (m <= 30) {
            link = "past";
        } else {
            link = "to";
            m = 60 - m;
            h++;
        }
        
        switch(m) {
         case 1:
            return "one minute " + link + " " + digits[h-1];
         case 30:
            return "half past " + digits[h-1];
         case 15:
         case 45:
            return "quarter" + " " + link + " " + digits[h-1];
         default:
            if (m < 20) {
                System.out.println(h);
                return digits[m - 1] + " minutes " + link + " " + digits[h-1];
            }
            return decimals[m / 10 - 2] + " " + digits[m % 10 - 1] + " minutes " + link + " " + digits[h-1];
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
