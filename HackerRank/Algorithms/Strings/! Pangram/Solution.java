// https://www.hackerrank.com/challenges/pangrams

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
     * Improved version, no aditional space (except for recreating the string with replaceAll)
     * We can improve on "replaceAll" by using a char array instead of a string,
     *   since strings are immutable
     */
    public static String pangrams(String s) {
        for (int i = 0; i < 26; i++) {
            int oldLength = s.length();

            s = s.replaceAll((char) ('a' + i) + "|" + (char) ('A' + i), "");
            
            // no occurrences of character ('a' + i) were found/removed => string is not a pangram 
            if (oldLength == s.length()) {
                return "not pangram";
            }
        }

        return "pangram";
    }


    /**
     * Classic version, with aditional data structure
     */
    public static String pangrams2(String s) {
        s = s.toLowerCase();
        byte[] arr = new byte[26];
        
        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i))) {
                arr[s.charAt(i) - 'a'] = 1;
            }
        }
        
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 1) {
                return "not pangram";
            }
        }

        return "pangram";
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
