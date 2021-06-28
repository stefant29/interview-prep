// https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem?isFullScreen=true

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
    /* Recursive Approach */
    public static int getReverse(int n) {
        if (n < 10) {
            return n;
        }

        // number of digits = log10(n);
        return n % 10 * (int) Math.pow(10, (int) Math.log10(n)) + getReverse(n / 10);
    }   
    
    public static int getReverse2(int n) {
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        
        return rev;
    }

    public static int beautifulDays(int start, int end, int k) {
        int count = 0;

        for (int i = start; i <= end; i++) {
            if (Math.abs(i - getReverse(i)) % k == 0) {
                count++;
            }
        }
        
        return count;
    }
    
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int i = Integer.parseInt(firstMultipleInput[0]);

        int j = Integer.parseInt(firstMultipleInput[1]);

        int k = Integer.parseInt(firstMultipleInput[2]);

        int result = Result.beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
