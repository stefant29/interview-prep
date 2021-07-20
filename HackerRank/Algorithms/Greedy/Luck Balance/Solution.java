// https://www.hackerrank.com/challenges/luck-balance

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    
    public static int luckBalance(int k, List<List<Integer>> contests) {
        int luck = 0;
        
        // else (limit reached) => substract from luck
        Collections.sort(contests, new Comparator<List<Integer>>() {
            public int compare(List<Integer> a, List<Integer> b) {
                return b.get(0).compareTo(a.get(0));
            }
        });
        
        for (List<Integer> contest : contests) {
            // loose all non important contests
            if (contest.get(1) == 0) {
                luck += contest.get(0);
                
            // loose k MOST luckiest contest
            } else if (k-- > 0) {
                luck += contest.get(0);
                
            // win rest less luckiest contests
            } else {
                luck -= contest.get(0);
            }
        }
        
        return luck;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> contests = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] contestsRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> contestsRowItems = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowTempItems[j]);
                contestsRowItems.add(contestsItem);
            }

            contests.add(contestsRowItems);
        }

        int result = Result.luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
