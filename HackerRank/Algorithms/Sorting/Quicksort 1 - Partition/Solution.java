// https://www.hackerrank.com/challenges/quicksort1

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

    public static List<Integer> quickSort(List<Integer> arr) {
        LinkedList<Integer> result = new LinkedList();
        int equal = 1, leftSize = 0, pivot = arr.get(0);
        
        for (int i = 1; i < arr.size(); i++) {
            int crt = arr.get(i);
            if (crt > pivot) {
                result.addLast(crt);
            } else if (crt < pivot) {
                result.addFirst(crt);
                leftSize++;
            } else {
                equal++;
            }
        }
        
        while (equal-- > 0) {
            result.add(leftSize, pivot);
        }
        
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.quickSort(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
