// https://www.hackerrank.com/challenges/sherlock-and-array

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
    
    public static String balancedSums(List<Integer> arr) {  
        int totalSum = 0;
        for (int i : arr) {
            totalSum += i;
        }
        
        int sumLeft = 0, sumRight = totalSum - arr.get(0);
        if (sumLeft == sumRight) {
            return "YES";
        }
        
        for (int i = 0; i < arr.size()-1; i++) {
            sumLeft += arr.get(i);
            sumRight -= arr.get(i+1);
            
            if (sumLeft == sumRight) {
                return "YES";
            }
        }
        
        return "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                String result = Result.balancedSums(arr);

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
