// https://www.hackerrank.com/challenges/lisa-workbook

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

    public static int workbook(int n, int k, List<Integer> arr) {
        int count = 0, page = 1;
        
        for (int chapterIndex = 0; chapterIndex < n; chapterIndex++) {
            boolean pageDirty = true;
            
            for (int i = 1; i <= arr.get(chapterIndex); i++) {
                pageDirty = true;
                
                if (i == page) {
                    count++;
                }
                
                if (i % k == 0) {
                    pageDirty = false;
                    page++;
                }
            }
            
            if (pageDirty) {
                page++;
            }
        }
        
        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.workbook(n, k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
