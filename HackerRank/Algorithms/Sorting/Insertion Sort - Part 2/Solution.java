// https://www.hackerrank.com/challenges/insertionsort2

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
     
    public static void insertionSort2(int n, List<Integer> arr) {
        for (int i = 1; i < arr.size() ; i++) {
            int numberToInsert = arr.get(i);
            int j = i;
            for (; j >= 1; j--) {
                if (arr.get(j-1) > numberToInsert) {
                    arr.set(j, arr.get(j-1));
                } else {
                    break;
                }
            }
            arr.set(j, numberToInsert);
            printArray(arr);
        }
    }

    static void printArray(List<Integer> arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.insertionSort2(n, arr);

        bufferedReader.close();
    }
}
