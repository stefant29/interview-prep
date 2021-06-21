// https://www.hackerrank.com/challenges/30-review-loop

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static String splitString(String s) {
        StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
        
        for (int i = 0; i < s.length(); i+= 2) {
            sb1.append(s.charAt(i));
        }
        for (int i = 1; i < s.length(); i+= 2) {
            sb2.append(s.charAt(i));
        }
        
        return sb1.toString() + " " + sb2.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < T; i++) {
            System.out.println(splitString(sc.nextLine()));
        }
    }
}
