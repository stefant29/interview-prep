// https://www.hackerrank.com/challenges/countingsort4

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

    public static void countSort(HashMap<Short, List<String>> map) {
        int[] count = new int[100];
        StringBuffer sb = new StringBuffer();

        for (short i : map.keySet()) {
            count[i] += map.get(i).size();
        }
        
        for (short i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                for (String s : map.get(i)) {
                    sb.append(s + " ");
                }
            }
        }
        
        System.out.println(sb.toString());
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        HashMap<Short, List<String>> map = new HashMap();

        IntStream.range(0, n).forEach(i -> {
            try {
                String[] line = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                Short number = Short.parseShort(line[0]);
                List<String> arr = map.getOrDefault(number, new ArrayList());
                arr.add(i < n / 2 ? "-" : line[1]);
                map.put(number, arr);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result.countSort(map);

        bufferedReader.close();
    }
}