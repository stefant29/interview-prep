// https://www.hackerrank.com/challenges/happy-ladybugs

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

    public static String happyLadybugs(String b) {        
        boolean spaces = false;
        int[] ladyBugs = new int[26];
        
        // count how many ladybugs are in the game
        for (char c : b.toCharArray()) {
            if (c == '_') {
                spaces = true;
            } else {
                ladyBugs[c-'A']++;
            }
        }
        
        // if there is only one ladybug, it cannot be mathced with any other ladybug so return NO
        for (int i : ladyBugs) {
            if (i == 1) {
                return "NO";
            }
        }
        
        // if there are no spaces to land, check if the ladybugs are in correct position already
        if (!spaces) {
            for (int i = 1; i < b.length() - 1; i++) {
                // if one ladybug does not have a matching ladybug to the left or to the right, return NO
                if (b.charAt(i) != '_' && b.charAt(i) != b.charAt(i-1) && b.charAt(i) != b.charAt(i+1)) {
                    return "NO";
                }
            }
        }
        
        return "YES";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, g).forEach(gItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                String b = bufferedReader.readLine();

                String result = Result.happyLadybugs(b);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
