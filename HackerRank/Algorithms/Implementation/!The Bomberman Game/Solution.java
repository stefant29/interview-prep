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
    
    public static List<String> convertMatrixToList(char[][] matrix) {
        List<String> list = new ArrayList();
        
        for (int i = 0; i < matrix.length; i++) {
            list.add(new String(matrix[i]));
        }
        
        return list;
    }
    
    public static char[][] convertListToMatrix(List<String> list) {
        int rows = list.size(), cols = list.get(0).length();
        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = list.get(i).toCharArray();
        }

        return matrix;
    }
    
    public static char[][] getFullGridArray(int rows, int cols, char symbol) {
        char[][] grid = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = symbol;
            }
        }
        return grid;
    }
    
    public static List<String> getFullGrid(int rows, int cols, char symbol) {
        List<String> list = new ArrayList();
        for (int i = 0; i < rows; i++) {
            list.add(new String(new char[cols]).replace('\0', symbol));
        }
        return list;
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

    public static List<String> bomberMan(int n, List<String> grid) {
        // n == 0 || n == 1 -> initial state
        // n % 2 == 0 -> full of bombs
        // n % 2 == 1 -> two possible states: invers1 and inverse2
                    // 3 = 2 * 1 + 1 -> odd  => invers1
                    // 5 = 2 * 2 + 1 -> even => invers2 == invers(invers1)
                    // 7 = 2 * 3 + 1 -> odd  => invers1 == invers(invers2)
                    // 9 = 2 * 4 + 1 -> even => invers2
        
        char[][] gridMatrix = convertListToMatrix(grid);
        char[][] inverseGridArray1 = getInverse(gridMatrix);
        char[][] inverseGridArray2 = getInverse(inverseGridArray1);
       
        List<String> inverseGrid1 = convertMatrixToList(inverseGridArray1);
        List<String> inverseGrid2 = convertMatrixToList(inverseGridArray2);
  
        if (n == 0 || n == 1) {
            return grid;
        } else if (n % 2 == 0) {
            return getFullGrid(grid.size(), grid.get(0).length(), 'O');
        } else if ((n / 2) % 2 == 1) {
            return inverseGrid1;
        } else {
            return inverseGrid2;
        }        
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r = Integer.parseInt(firstMultipleInput[0]);

        int c = Integer.parseInt(firstMultipleInput[1]);

        int n = Integer.parseInt(firstMultipleInput[2]);

        List<String> grid = IntStream.range(0, r).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = Result.bomberMan(n, grid);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
