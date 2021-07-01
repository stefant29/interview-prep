// https://www.hackerrank.com/challenges/quicksort2

import java.io.*;
import java.util.*;

public class Solution {

    static void quickSort(int arr[], int low, int high) {
        if (low >= high) {
            return;
        }
        
        int pivot = arr[low];
        ArrayList<Integer> leftlist = new ArrayList<Integer>();
        ArrayList<Integer> rightlist = new ArrayList<Integer>();
        
        for (int i = low + 1; i <= high; i++) {
            if (arr[i] > pivot) {
                rightlist.add(arr[i]);
            } else {
                leftlist.add(arr[i]);
            }
        }

        int i = low;
        for (int n : leftlist) {
            arr[i++] = n;            
        }
        arr[i++] = pivot;
        for (int n : rightlist) {
            arr[i++] = n;
        }
        
        quickSort(arr, low, low + leftlist.size() - 1);
        quickSort(arr, low + leftlist.size() + 1, high);

        printArray(arr, low, high);
    }

    static void printArray(int[] arr, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        quickSort(arr, 0, n - 1);
    }
}