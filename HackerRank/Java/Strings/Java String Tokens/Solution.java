// https://www.hackerrank.com/challenges/java-string-tokens

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        
        s = removeLeadingNonLetters(s);
        String[] split = s.split("[^a-zA-Z]+");

        int total = 0;
        for(String s1 : split) {
            if (s1.length() != 0) {
                total++;
            }
        }
        
        System.out.println(total);
                
        for(String s1 : split) {
            System.out.println(s1);
        }
        
        scan.close();
    }
     private static String removeLeadingNonLetters(String str) {
        int i;
        for (i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                break;
            }
        }
        return str.substring(i);
    }
}

