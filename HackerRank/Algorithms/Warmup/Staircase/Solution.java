// https://www.hackerrank.com/challenges/staircase

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
	
    public static void staircase(int n) {
        for (int i = 1; i < n; i++) {
            System.out.println(
                String.format("%0" + (n-i) + "d", 0).replace("0", " ") + 
                String.format("%0" + i + "d", 0).replace("0", "#")
            );
        }
        System.out.println(
            String.format("%0" + n + "d", 0).replace("0", "#")
        );
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.staircase(n);

        bufferedReader.close();
    }
}
