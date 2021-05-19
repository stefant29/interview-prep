// https://www.hackerrank.com/challenges/java-list

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            String command = sc.next();
            if (command.equals("Insert")) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                arr.add(x, y);
            } else if (command.equals("Delete")) {
                arr.remove(sc.nextInt());
            }
        }
        
        for (int i : arr) {
            System.out.print(i + " ");
        }
        
        sc.close();
    }
}
