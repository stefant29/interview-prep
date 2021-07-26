// https://www.hackerrank.com/challenges/separate-the-numbers

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

    /**
     * Simple version: starting from the first number (of 1,2,3,etc digits), 
     *   construct the entire string and compare it to the original
     */
    static void separateNumbers2(String s) {
        if (s.length() == 1) {
            System.out.println("NO");
            return;
        }

        for (int i = 1; i <= Math.ceil((double)s.length() / 2); i++) {
            long firstNumber = Long.parseLong(s.substring(0, i));
            long copyFirstNumber = firstNumber;
            StringBuilder sb = new StringBuilder(s.length());

            while (sb.length() < s.length()) {
                sb.append(firstNumber++);
            }

            sb.trimToSize();

            if (sb.toString().equals(s)) {
                System.out.println("YES " + copyFirstNumber);
                return;
            }
        }

        System.out.println("NO");
    }


   
    /**
     * Improved version: starting from the first number (of 1,2,3,etc digits), 
     *   construct and compare the next numbers with substrings from s (to avoid creating the entire string)
     */
    public static void separateNumbers(String s) {
        for (int noDigits = 1; noDigits <= s.length() / 2; noDigits++) {
            long start = Long.parseLong(s.substring(0, noDigits));
            if (start == 0) {
                System.out.println("NO");
                return;
            }
            
            long next = start;
            int noDigitsNext = (int) (Math.log10(next) + 1);
            
            boolean wrongNext = false;

            for (int i = noDigitsNext; i < s.length(); i += noDigitsNext) {
                next++;
                noDigitsNext = (int) (Math.log10(next) + 1);
                
                if (i+noDigitsNext > s.length() || !s.substring(i, i+noDigitsNext).equals("" + next)) {
                    wrongNext = true;
                    break;
                }
            }
            
            if (!wrongNext) {
                System.out.println("YES " + start);
                return;
            }
            
        }
        System.out.println("NO");
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                Result.separateNumbers(s);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
