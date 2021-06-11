// https://www.hackerrank.com/challenges/bomber-man

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
    
    public static char[][] getFullGridArray(int rows, int cols, char symbol) {
        char[][] grid = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = symbol;
            }
        }
        return grid;
    }
  
    public static char[][] getInverse(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        char[][] fullGrid = getFullGridArray(rows, cols, 'O');
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 'O') {
                    if (i-1 >= 0) fullGrid[i-1][j] = '.';
                    if (j-1 >= 0) fullGrid[i][j-1] = '.';
                    fullGrid[i][j] = '.';                    
                    if (j+1 < cols) fullGrid[i][j+1] = '.';
                    if (i+1 < rows) fullGrid[i+1][j] = '.';
                }
            }
        }
        
        return fullGrid;
    }

    public static char[][] bomberMan(int n, char[][] grid) {
        // n == 0 || n == 1 -> initial state
        // n % 2 == 0 -> full of bombs
        // n % 2 == 1 -> two possible states: invers1 and inverse2
                    // 3 = 2 * 1 + 1 -> odd  => invers1
                    // 5 = 2 * 2 + 1 -> even => invers2 == invers(invers1)
                    // 7 = 2 * 3 + 1 -> odd  => invers1 == invers(invers2)
                    // 9 = 2 * 4 + 1 -> even => invers2
        
        char[][] inverseGridArray1 = getInverse(grid);
        char[][] inverseGridArray2 = getInverse(inverseGridArray1);

        if (n == 0 || n == 1) {
            return grid;
        } else if (n % 2 == 0) {
            return getFullGridArray(grid.length, grid[0].length, 'O');
        } else if ((n / 2) % 2 == 1) {
            return inverseGridArray1;
        } else {
            return inverseGridArray2;
        }        
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int rows = Integer.parseInt(firstMultipleInput[0]);

        int cols = Integer.parseInt(firstMultipleInput[1]);

        int n = Integer.parseInt(firstMultipleInput[2]);

        char[][] grid = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            grid[i] = bufferedReader.readLine().toCharArray();
        }
        
        char[][] result = Result.bomberMan(n, grid);
        for (int i = 0; i < rows; i++) {
            bufferedWriter.write(new String(result[i]) + "\n");
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
