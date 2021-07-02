// https://www.hackerrank.com/challenges/quicksort4

import java.io.*;
import java.util.*;

public class Solution {

    public static int count = 0;
    public static int shifts = 0;

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int numberToInsert = arr[i];
            int j = i;
            for (; j >= 1; j--) {
                if (arr[j - 1] > numberToInsert) {
                    arr[j] = arr[j - 1];
                    Solution.shifts++;
                } else {
                    break;
                }
            }
            arr[j] = numberToInsert;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        Solution.count++;
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, high);

        return i;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
            arr2[i] = arr1[i];
        }

        quickSort(arr1, 0, n - 1);
        insertionSort(arr2);

        System.out.println(Solution.shifts - Solution.count);
    }
}