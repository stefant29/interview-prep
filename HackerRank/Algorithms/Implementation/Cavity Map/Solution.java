// https://www.hackerrank.com/challenges/cavity-map

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    public static List<String> cavityMap(List<String> grid) {
        for (int i = 1; i < grid.size() - 1; i++) {
           
            for (int j = 1; j < grid.get(i).length() - 1; j++) {
                if (grid.get(i).charAt(j) > grid.get(i).charAt(j-1) && 
                    grid.get(i).charAt(j) > grid.get(i).charAt(j+1) && 
                    grid.get(i).charAt(j) > grid.get(i-1).charAt(j) && 
                    grid.get(i).charAt(j) > grid.get(i+1).charAt(j)) {
                    grid.set(i, grid.get(i).substring(0, j) + "X" + grid.get(i).substring(j+1));
                    // skip element to the right since it's smaller than this one
                    j++;
                }
            }
        }

        
        return grid;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String gridItem = bufferedReader.readLine();
            grid.add(gridItem);
        }

        List<String> result = Result.cavityMap(grid);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(result.get(i));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
