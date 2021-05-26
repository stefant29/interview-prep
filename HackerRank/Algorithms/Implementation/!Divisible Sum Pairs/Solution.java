// https://www.hackerrank.com/challenges/divisible-sum-pairs

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

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        int[] mods = new int[k];
        int count = 0;
        
        for (int i = 0; i < k; i++)
            mods[i] = 0;
        
        // count number of mods k in array
        for (int i = 0; i < ar.size(); i++)
            mods[ar.get(i) % k]++;
                
        // mod 0: Combinations of N taken by 2: n!/2!*(n-2)! == n*(n-1)/2
        count += mods[0] * (mods[0]-1) / 2;
        
        // for rest:
        for (int i = 1; i <= k/2; i++) {
            // if it's the same index, idem "mod 0"
            if (i == k-i)
                count += mods[i] * (mods[i]-1) / 2;
            // for rest: they combine: len(list1) * len(list2)
            else
                count += mods[i] * mods[k-i];
        }
        
        return count;
        
        /*
            // Basic solution
            int count = 0;
            for (int i = 0; i < ar.size() - 1; i++) {
                for (int j = i+1; j < ar.size(); j++) {
                    if ((ar.get(i) + ar.get(j)) % k == 0) {
                        count++;
                    }
                }
            }
            return count;
        */
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.divisibleSumPairs(n, k, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
