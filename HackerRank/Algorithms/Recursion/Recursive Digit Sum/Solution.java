// https://www.hackerrank.com/challenges/recursive-digit-sum

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {    
    
    public static int sumDigits(String s, int k) {
        if (s.length() == 1) {
            return Integer.parseInt(s);
        }
        
        long sum = 0;
        for (char c : s.toCharArray()) {
            sum += Character.getNumericValue(c);
        }
        
        return sumDigits((sum * k) + "", 1);
    }
    
    public static int superDigit(String s, int k) {
        return sumDigits(s, k);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
