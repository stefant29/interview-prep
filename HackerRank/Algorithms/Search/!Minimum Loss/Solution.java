// https://www.hackerrank.com/challenges/minimum-loss

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

    /**
    * Trivial solution
    */
    public static int minimumLoss2(List<Long> price) {
        int minLoss = Integer.MAX_VALUE;
        
        for (int i = 0; i < price.size() - 1; i++) {
            int crtLoss = Integer.MAX_VALUE;
            
            for (int j = i + 1; j < price.size(); j++) {
                Long crtDiff = price.get(i) - price.get(j);
                if (crtDiff >= 0) {
                    crtLoss = (int)Math.min(crtDiff, crtLoss);
                }
            }
            
            minLoss = Math.min(minLoss, crtLoss);
        }
        
        return minLoss;
    }

    /**
    * Efficient solution
    */
    public static int minimumLoss(List<Long> prices) {
        Map<Long, Integer> indices = new HashMap();
        for (int i = 0; i < prices.size(); i++) {
            indices.put(prices.get(i), i);
        }
        
        Collections.sort(prices, Collections.reverseOrder());
        
        int minLoss = Integer.MAX_VALUE;
        for (int i = 0; i < prices.size() - 1; i++) {
            Long diff = prices.get(i) - prices.get(i+1);
            if (diff > 0 && indices.get(prices.get(i)) < indices.get(prices.get(i+1))) {
                minLoss = (int) Math.min(minLoss, diff);
            }
        }
        
        return minLoss;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Long> price = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        int result = Result.minimumLoss(price);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
