// https://www.hackerrank.com/challenges/lilys-homework

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
    
    public static void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
    
    public static int aux(List<Integer> arr, List<Integer> sorted) {
        HashMap<Integer, Integer> map = new HashMap();
        int count = 0;
        
        // map: val=arr.get(index) => index
        for (int i = 0; i < arr.size(); i++) {
            map.put(arr.get(i), i);
        }
        
        for (int i = 0; i < arr.size(); i++) {
            if (sorted.get(i) != arr.get(i)) {
                // swap the element at position i with the right one as per the sorted array
                int minValIndex = map.get(sorted.get(i));
                swap(arr, minValIndex, i);

                // update map with new value/index
                map.put(arr.get(minValIndex), minValIndex);

                count++;
            }
        }
        
        return count;
    }

    public static int lilysHomework(List<Integer> arr) {
        List<Integer> arrCopy = new ArrayList(arr);
        List<Integer> sort = new ArrayList(arr);
        List<Integer> sortDesc = new ArrayList(arr);
        Collections.sort(sort);
        Collections.sort(sortDesc, Collections.reverseOrder());
        
        // !! IMPORTANT !! 
        // call the second aux() with a copy of arr, since it gets changed by the first call to aux()
        return Math.min(aux(arr, sort), aux(arrCopy, sortDesc));
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

        int result = Result.lilysHomework(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
