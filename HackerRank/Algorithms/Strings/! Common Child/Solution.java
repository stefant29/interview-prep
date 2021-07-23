// https://www.hackerrank.com/challenges/common-child

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

   public static int commonChild(String s1, String s2) {
    int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length() + 1; i++)
            dp[i][0] = 0;
        for (int i = 0; i < s2.length() + 1; i++)
            dp[0][i] = 0;
        
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                int crt = 0;
                if (s1.charAt(i) == s2.charAt(j)) {
                    crt = 1 + dp[i][j];
                } else 
                    crt = Math.max(dp[i][j+1], dp[i+1][j]);
                dp[i+1][j+1] = crt;
            }
        }
         return dp[s1.length()][s2.length()];
   }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        int result = Result.commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
