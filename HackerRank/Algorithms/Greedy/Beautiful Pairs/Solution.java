// https://www.hackerrank.com/challenges/beautiful-pairs

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

    public static int beautifulPairs(List<Integer> A, List<Integer> B) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap();
        
        // keep track of how many times each number appears in A
        for (int i : A) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        // decrease the number of times a number appears for each number in B
        for (int i : B) {
            // whenever a number matches, count it
            if (map.containsKey(i) && map.get(i) > 0) {
                count++;
            }
            map.put(i, map.getOrDefault(i, 0) - 1);
        }
        
        // search for numbers that do not have any matches and can be replaced 
        //   in order to form a new pair
        boolean foundOdd = false;
        for (int i : map.keySet()) {
            if (map.get(i) == 1) {
                foundOdd = true;
                break;
            }
        }
        
        // found one number that can be replaced so that a new pair is formed
        if (foundOdd) {
            count++;
        } else {
            // no such number is found, but we need to change one element from B anyway,
            //    decreasing number of pairs
            count--;
        }
        
        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.beautifulPairs(A, B);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
