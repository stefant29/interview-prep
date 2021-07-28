// https://www.hackerrank.com/challenges/anagram

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    public static int anagram(String s) {
        if (s.length() % 2 == 1) {
            return -1;
        }
        
        int[] occurrences = new int[26];
        for (int i = 0; i < s.length() / 2; i++) {
            occurrences[s.charAt(i) - 'a']++;
            occurrences[s.charAt(s.length() - 1 - i) - 'a']--;
        }
        
        int total = 0;
        for (int i = 0; i < 26; i++) {
            total += Math.abs(occurrences[i]);
        }
        
        return total / 2;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String s = bufferedReader.readLine();

            int result = Result.anagram(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
