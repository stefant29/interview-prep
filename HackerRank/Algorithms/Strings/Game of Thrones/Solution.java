// https://www.hackerrank.com/challenges/game-of-thrones

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

    public static String gameOfThrones(String s) {
        int[] frequencies = new int[26];
        for (char c : s.toCharArray()) {
            frequencies[c - 'a']++;
        }
        
        boolean oddFrequencyFoundAlready = false;
        for (int freq : frequencies) {
            if (freq % 2 == 1) {
                if (oddFrequencyFoundAlready) {
                    return "NO";
                }
                oddFrequencyFoundAlready = true;
            }
        }
        
        return "YES";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
