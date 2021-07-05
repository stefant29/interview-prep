// https://www.hackerrank.com/challenges/hackerland-radio-transmitters

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
    
    public static int hackerlandRadioTransmitters(List<Integer> x, int k) {
        Collections.sort(x);
        
        int count = 0, i = 0;
        
        while (i < x.size()) {
            // starting from left, find the right most house in range K
            int loc = x.get(i) + k;
            // condition must include equal, so i will go past the transmiter location
            while (i < x.size() && x.get(i) <= loc) {
                i++;
            }
            
            // place transmiter HERE
            i--;
            count++;
            
            loc = x.get(i) + k;
            // starting from the transmiter, go to the right most house in range K
            while (i < x.size() && x.get(i) <= loc) {
                i++;
            }
        }

        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> x = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.hackerlandRadioTransmitters(x, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
