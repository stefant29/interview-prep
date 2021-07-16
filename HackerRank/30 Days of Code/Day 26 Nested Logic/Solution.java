// https://www.hackerrank.com/challenges/30-nested-logic

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        if (y1 > y2) {
            return 10000;
        } else if (y1 == y2 && m1 > m2) {
            return 500 * (m1 - m2);
        } else if (y1 == y2 && m1 == m2 && d1 > d2) {
            return 15 * (d1 - d2);
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int d1 = sc.nextInt();
        int m1 = sc.nextInt();
        int y1 = sc.nextInt();

        int d2 = sc.nextInt();
        int m2 = sc.nextInt();
        int y2 = sc.nextInt();

        int result = libraryFine(d1, m1, y1, d2, m2, y2);

        System.out.println(String.valueOf(result));
    }
}
