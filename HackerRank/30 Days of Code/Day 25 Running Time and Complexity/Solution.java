// https://www.hackerrank.com/challenges/30-running-time-and-complexity

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static String checkPrime(int n) {
        if (n == 1 || n == 0) {
            return "Not prime";
        }
            
        int sup = (int) Math.sqrt(n);
        for (int i = 2; i <= sup; i++) {
            if (n % i == 0) {
                return "Not prime";
            }
        }
        
        return "Prime";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < T; i++) {
            System.out.println(checkPrime(Integer.parseInt(sc.nextLine())));
        }
    }
}
