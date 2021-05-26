// https://www.hackerrank.com/challenges/sock-merchant

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
    
    public static int sockMerchant(int n, List<Integer> ar) {
        HashSet<Integer> freq = new HashSet();
        int pairCount = 0;
        
        for (int i : ar) {
            if (!freq.contains(i)) {
                freq.add(i);
            } else {
                pairCount++;
                freq.remove(i);
            }
        }
        
        return pairCount;
        
        /* 
            // basic solution
            int pairCount = 0;
            int[] freq = new int[101];
            
            for (int i : ar) {
                freq[i]++;
            }
            
            for (int i : freq) {
                pairCount += i / 2;
            }
            
            return pairCount;
        */
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
