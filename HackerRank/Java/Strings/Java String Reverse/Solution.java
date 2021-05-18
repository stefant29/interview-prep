// https://www.hackerrank.com/challenges/java-string-reverse

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        
        //StringBuilder sb = new StringBuilder(A);
        //String rev = sb.reverse().toString();
        //System.out.println(rev.equals(A) ? "Yes" : "No");
        
        System.out.println(isPalindrome(A));
    }
    
    public static String isPalindrome(String A) {
        if (A == null || A.length() == 0) {
            return "No";
        }
        
        for (int i = 0; i < A.length() / 2; i++) {
            if (A.charAt(i) != A.charAt(A.length()-i-1)) {
                return "No";
            }
        }
        
        return "Yes";
    }
}



