// https://www.hackerrank.com/challenges/repeated-string

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    public static long repeatedString(String s, long n) {
        if (s.length() == 1 && s.charAt(0) == 'a') {
            return n;
        }
        
        long occurrences = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                occurrences++;
            }
        }
        
        occurrences *= (long) Math.ceil(n / s.length());
        for (int i = 0; i < n % s.length(); i++) {
            if (s.charAt(i) == 'a') {
                occurrences++;
            }
        }
        
        return occurrences;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
