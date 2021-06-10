// https://www.hackerrank.com/challenges/the-grid-search

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

    public static String gridSearch(List<String> grid, List<String> pattern) {
       
        for (int indexRow = 0; indexRow < grid.size() - pattern.size() + 1; indexRow++) {
            String pattern0 = pattern.get(0);
            // try to find the first line of the pattern in each rows of the grid
            
            int indexCol = grid.get(indexRow).indexOf(pattern0);
            while (indexCol >= 0) {
                // for each pattern found
                int found = 1;

                // check for the next pattern lines in the grid, starting at the same indexCol
                for (int j = 1; j < pattern.size(); j++) {
                    // if current line of pattern does not match the grid, break the search starting with this column
                    if (!grid.get(indexRow + j).substring(indexCol, indexCol + pattern0.length()).equals(pattern.get(j))) {
                        break;
                    }
                    found++;
                }
                // return YES only if all pattern lines were found
                if (found == pattern.size()) {
                    return "YES";
                }
                
                // get next index that matches the pattern
                indexCol = grid.get(indexRow).indexOf(pattern0, indexCol + 1);
            }
        }
        
        return "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int R = Integer.parseInt(firstMultipleInput[0]);

                int C = Integer.parseInt(firstMultipleInput[1]);

                List<String> G = IntStream.range(0, R).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                    .collect(toList());

                String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int r = Integer.parseInt(secondMultipleInput[0]);

                int c = Integer.parseInt(secondMultipleInput[1]);

                List<String> P = IntStream.range(0, r).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                    .collect(toList());

                String result = Result.gridSearch(G, P);

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
