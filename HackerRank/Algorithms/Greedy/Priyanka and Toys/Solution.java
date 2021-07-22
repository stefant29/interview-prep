// https://www.hackerrank.com/challenges/priyanka-and-toys

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    public static int toys(List<Integer> w) {
        Collections.sort(w);
        
        int limit = -1, container = 0;
        for (int i : w) {            
            if (i > limit) {
                container++;
                limit = i+4;
            }
        }
        
        return container;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] wTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> w = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int wItem = Integer.parseInt(wTemp[i]);
            w.add(wItem);
        }

        int result = Result.toys(w);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
