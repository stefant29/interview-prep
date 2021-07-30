// https://www.hackerrank.com/challenges/making-anagrams

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

    public static int makingAnagrams(String s1, String s2) {
        int[] frequency = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            frequency[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            frequency[s2.charAt(i) - 'a']--;
        }

        int total = 0;
        for (int i = 0; i < 26; i++) {
            total += Math.abs(frequency[i]);
        }
        return total;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        int result = Result.makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
