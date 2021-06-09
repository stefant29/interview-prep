// https://www.hackerrank.com/challenges/organizing-containers-of-balls

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

    public static String organizingContainers(List<List<Integer>> container) {
        HashMap<Integer, Integer> mapSumRowCol = new HashMap();
        
        // to make swaps, we must have an equal number of balls from each category 
        // with the number of balls in containers: sum on rows must be equal to sum on cols
        for (int i = 0; i < container.size(); i++) {
            int sumRow = 0, sumCol = 0;
            for (int j = 0; j < container.size(); j++) {
                sumRow += container.get(i).get(j);
                sumCol += container.get(j).get(i);
            }
            mapSumRowCol.put(sumRow, mapSumRowCol.getOrDefault(sumRow, 0) + 1);
            mapSumRowCol.put(sumCol, mapSumRowCol.getOrDefault(sumCol, 0) - 1);
        }
        
        // if the value is different than zero, this means one col sum does not match with a row sum
        for (Map.Entry<Integer, Integer> entry : mapSumRowCol.entrySet()) {
            if (entry.getValue() != 0) {
                return "Impossible";
            }
        }
        
        return "Possible";
    }


    /** 
     * Old solution
     */
    static String organizingContainers(int[][] container) {
        int[] containerCapacity = new int[container.length];
        int[] ballCount = new int[container.length];

        for (int i = 0; i < container.length; i++) {
            containerCapacity[i] = 0;
            for (int j = 0; j < container[i].length; j++) {
                containerCapacity[i] += container[i][j];
                ballCount[j] += container[i][j];
            }
        }

        Arrays.sort(containerCapacity);
        Arrays.sort(ballCount);

        for (int i = 0; i < containerCapacity.length; i++) {
            if (containerCapacity[i] != ballCount[i]) {
                return "Impossible";
            }
        }

        return "Possible";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> container = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        container.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                String result = Result.organizingContainers(container);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
