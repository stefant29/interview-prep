// https://www.hackerrank.com/challenges/2d-array

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

    public static int hourglassSum(List<List<Integer>> arr) {
        int maxSum = Integer.MIN_VALUE;
        
        for (int i = 1; i < arr.size() - 1; i++) {
            for (int j = 1; j < arr.size() - 1; j++) {
                int crtSum = 
                    arr.get(i-1).get(j-1) + arr.get(i-1).get(j) + arr.get(i-1).get(j+1) + 
                                            arr.get(i).get(j) + 
                    arr.get(i+1).get(j-1) + arr.get(i+1).get(j) + arr.get(i+1).get(j+1);
                    
                
                maxSum = Math.max(maxSum, crtSum);
            }
        }
        
        return maxSum;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
