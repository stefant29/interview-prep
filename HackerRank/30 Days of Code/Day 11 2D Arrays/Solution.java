// https://www.hackerrank.com/challenges/30-2d-arrays

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



public class Solution {
    
    public static int getMaximumHourglassSum(List<List<Integer>> mat) {
        int maxSum = Integer.MIN_VALUE;
        
        for (int i = 0; i < mat.size() - 2; i++) {
            for (int j = 0; j < mat.get(0).size() - 2; j++) {
                int crtSum = mat.get(  i).get(j) + mat.get(  i).get(j+1) + mat.get(  i).get(j+2) + 
                                                   mat.get(i+1).get(j+1) + 
                             mat.get(i+2).get(j) + mat.get(i+2).get(j+1) + mat.get(i+2).get(j+2);
                             
                if (crtSum > maxSum) {
                    maxSum = crtSum;
                }
            }
        }
        
        return maxSum;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }

        bufferedReader.close();
        
        System.out.println(getMaximumHourglassSum(arr));
    }
}

