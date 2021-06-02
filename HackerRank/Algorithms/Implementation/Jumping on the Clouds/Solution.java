// https://www.hackerrank.com/challenges/jumping-on-the-clouds

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
    
    public static int jump(List<Integer> c, int index) {
        // return -1 (bad values) for thunderclouds
        //    and for index that exceeds the limit
        if (index >= c.size() || c.get(index) == 1) {
            return -1;
        }
        // return 0 if the current position is the desired cloud (n-1)
        if (index == c.size() - 1) {
            return 0;
        }
        
        int step1 = jump(c, index + 1);
        int step2 = jump(c, index + 2);
        
        // if one call returns -1, then return the other value,
        //    in other words, the bigger number
        if (step1 + step2 == Math.max(step1, step2) - 1) {
            return Math.max(step1, step2) + 1;
        }
        
        // otherwise, both being > 0 (good values), 
        //    return the smallest number and add one
        //    for current step
        return Math.min(step1, step2) + 1;
    }

    public static int jumpingOnClouds(List<Integer> c) {
        return jump(c, 0);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
