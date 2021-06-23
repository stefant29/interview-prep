// https://www.hackerrank.com/challenges/countingsort3

import java.io.*;
import java.util.*;

public class Solution {
    
    public static void countingSort(int[] arr) {
        int[] count = new int[100];
        int total = 0;
        
        for (int i : arr) {
            count[i]++;
        }
        
        for (int i = 0; i < 100; i++) {
            total += count[i];
            System.out.print(total + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sc.next();
        }
        countingSort(arr);
    }
}