// https://www.hackerrank.com/challenges/gem-stones

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
    
    public static int gemstones(List<String> arr) {
        Map<Character, Set<Integer>> map = new HashMap();
        int count = 0;
        
        for (int i = 0; i < arr.size(); i++) {
            for (char c : arr.get(i).toCharArray()) {
                Set<Integer> set = map.getOrDefault(c, new HashSet());
                set.add(i);
                map.put(c, set);
            }
        }
        
        for (char key : map.keySet()) {
            if (map.get(key).size() == arr.size()) {
                count++;
            }
        }
        
        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> arr = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        int result = Result.gemstones(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
