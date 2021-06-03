// https://www.hackerrank.com/challenges/minimum-distances

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

    public static int minimumDistances(List<Integer> a) {
        HashMap<Integer, Integer> map = new HashMap();
        int minDistance = Integer.MAX_VALUE;
        
        for (int i = 0; i < a.size(); i++) {
            if (map.containsKey(a.get(i))) {
                int oldIndex = map.get(a.get(i));
                if (i - oldIndex < minDistance) {
                    minDistance = i - oldIndex;
                }
            }
            map.put(a.get(i), i);
        }
        
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.minimumDistances(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
