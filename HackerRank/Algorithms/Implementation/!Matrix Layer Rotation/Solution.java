// https://www.hackerrank.com/challenges/matrix-rotation-algo

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    
    // go through the matrix on given layer and save all elements into an array
    public static ArrayList<Integer> getLayerAsArray(int[][] mat, int layer) {
        int m = mat.length, n = mat[0].length;
        ArrayList<Integer> arr = new ArrayList<Integer>();

        for (int j = layer; j < n - layer; j++) {
            arr.add(mat[layer][j]);
        }
        for (int i = layer + 1; i < m - 1 - layer; i++) { 
            arr.add(mat[i][n - 1 - layer]);
        }
        for (int j = n - 1 - layer; j >= layer; j--) {
            arr.add(mat[m - 1 - layer][j]);
        }
        for (int i = m - 1 - 1 - layer; i >= layer + 1; i--) { 
            arr.add(mat[i][layer]);
        }
        
        return arr;
    }

    // save in the matrix the element which comes after "r" positions
    public static void rotateMatrixLayer(int[][] mat, int r, int layer, List<Integer> arr) {
        int m = mat.length, n = mat[0].length;
        int k = r % arr.size();
        for (int j = layer; j < n - layer; j++) {
            mat[layer][j] = arr.get(k % arr.size());
            k++;
        }
        for (int i = layer + 1; i < m - 1 - layer; i++) { 
            mat[i][n - 1 - layer] = arr.get(k % arr.size());
            k++;
        }
        for (int j = n - 1 - layer; j >= layer; j--) {
            mat[m - 1 - layer][j] = arr.get(k % arr.size());
            k++;
        }
        for (int i = m - 1 - 1 - layer; i >= layer + 1; i--) { 
            mat[i][layer] = arr.get(k % arr.size());
            k++;
        }  
    }
    
    public static int[][] convertArrayToMatrix(List<List<Integer>> matrix) {
        int m = matrix.size(), n = matrix.get(0).size();
        int[][] mat = new int[m][n];
    
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = matrix.get(i).get(j);
            }        
        }
        
        return mat;
    }
    
    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        // construct int[][] matrix for in place rotation
        int[][] mat = convertArrayToMatrix(matrix);
        int maxLayers = (int)Math.min(mat.length, mat[0].length) / 2;
        
        // for each layer
        for (int layer = 0; layer < maxLayers; layer++) {
            // rotate the layer:
            //   extract all elements from that layer into an array
            //   then for each element of the layer, get the appropiate element after the rotation was made
            rotateMatrixLayer(mat, r, layer, getLayerAsArray(mat, layer));
        }
        
        printMat(mat);
    }
    
    public static void printMat(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }        
            System.out.println();
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> matrixRowItems = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
                matrixRowItems.add(matrixItem);
            }

            matrix.add(matrixRowItems);
        }

        Result.matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
