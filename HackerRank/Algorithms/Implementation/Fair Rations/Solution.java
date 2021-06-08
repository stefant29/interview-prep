// https://www.hackerrank.com/challenges/fair-rations

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
    
    public static String fairRations(List<Integer> bread) {
        int lastIndex = -1, total = 0;

        for (int i = 0; i < bread.size(); i++) {
            if (bread.get(i) % 2 == 1) {
                // keep track of the last odd index
                if (lastIndex == -1) {
                    lastIndex = i;
                } else {
                    // add to the total, the difference between current odd index and last odd index
                    // since you need to offer bread to everyone in between, to make them even
                    total += (i - lastIndex) * 2;
                    // reset last odd index since everything is even until this index
                    lastIndex = -1;
                }
            }
        }
        
        // if lastIndex is -1, then all numbers are even so return total
        return lastIndex == (-1) ? "" + total : "NO";
    }
    
    /**
     * OLD SOLUTION
     */
    static void fairRations2(int[] B) {
        if (B.length <= 0)
            return;
        
        int count = 0;
        for (int i = 0; i < B.length - 1; i++) {
            if (B[i]%2 == 1) {
                B[i]++; B[i+1]++;
                count += 2;
            }
        }
        if (B[B.length - 1]%2 == 0)
            System.out.println(count);
        else
            System.out.println("NO");
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String result = Result.fairRations(B);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
