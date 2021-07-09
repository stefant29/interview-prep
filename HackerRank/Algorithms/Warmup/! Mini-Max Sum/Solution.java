// https://www.hackerrank.com/challenges/mini-max-sum

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

    public static void miniMaxSum(List<Long> arr) {
        long total = arr.stream().reduce((long) 0, (a,b) -> a + b);
        Collections.sort(arr);
        System.out.println((total - arr.get(arr.size() - 1)) + " " + (total - arr.get(0)));
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
