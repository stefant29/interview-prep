// https://www.hackerrank.com/challenges/marcs-cakewalk

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    public static long marcsCakewalk(List<Integer> calorie) {
        Collections.sort(calorie, Collections.reverseOrder());
        
        long pow = 1, total = 0;
        for (int c : calorie) {
            total += pow * c;
            
            pow *= 2;
        }
        
        return total;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] calorieTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> calorie = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int calorieItem = Integer.parseInt(calorieTemp[i]);
            calorie.add(calorieItem);
        }

        long result = Result.marcsCakewalk(calorie);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
