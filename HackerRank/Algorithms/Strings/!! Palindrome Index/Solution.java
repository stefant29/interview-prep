// https://www.hackerrank.com/challenges/palindrome-index

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    public static boolean isPalindrome(String s, int start, int end) {      
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        
        return true;
    }

    public static int palindromeIndex(String s) {
        int start = 0, end = s.length() - 1;

        if (isPalindrome(s, start, end)) {
            return -1;
        }
                
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                if (isPalindrome(s, start+1, end)) {
                    return start;
                }
                if (isPalindrome(s, start, end-1)) {
                    return end;
                }
                return -1;
            }
        }
        
        return -1;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String s = bufferedReader.readLine();

            int result = Result.palindromeIndex(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
