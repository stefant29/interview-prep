// https://www.hackerrank.com/challenges/migratory-birds

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

    public static int migratoryBirds(List<Integer> arr) {
        int[] birdsFreq = new int[5];
        int maxFreq = 0, index = -1;
        
        for (int birdType : arr) {
            birdsFreq[birdType - 1]++;
        }
        
        for (int i = 0; i < birdsFreq.length; i++) {
            if (birdsFreq[i] > maxFreq) {
                maxFreq = birdsFreq[i];
                index = i + 1;
            }
        }
        
        return index;
        
        /*
            int maxFreq = 0;
            HashMap<Integer, Integer> birdsFreq = new HashMap();
            for (int birdType : arr) {
                int count = 1;
                if (birdsFreq.containsKey(birdType)) {
                    count += birdsFreq.get(birdType);
                }
                if (count > maxFreq) {
                    maxFreq = count;
                }
                birdsFreq.put(birdType, count);
            }
            
            int minIndex = arr.size() - 1;
            for (Map.Entry<Integer, Integer> entry : birdsFreq.entrySet()) {
                if (entry.getValue() == maxFreq && entry.getKey() < minIndex) {
                    minIndex = entry.getKey();
                }
            }
            
            return minIndex;
        */
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
