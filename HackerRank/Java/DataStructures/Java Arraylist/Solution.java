// https://www.hackerrank.com/challenges/java-arraylist

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer>[] arr = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            int counter = sc.nextInt();
            for (int j = 0; j < counter; j++) {
                if (arr[i] == null) {
                    arr[i] = new ArrayList<Integer>();
                }
                
                arr[i].add(sc.nextInt());
            }
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            try {
                System.out.println(arr[x-1].get(y-1));
            } catch (Exception e) {
                System.out.println("ERROR!");
            }
        }
    }
}
