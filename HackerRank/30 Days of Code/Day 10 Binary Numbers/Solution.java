// https://www.hackerrank.com/challenges/30-binary-numbers

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        bufferedReader.close();
        
        int count = 0, max = 0;
        while (n > 0) {
            int rest = n % 2;
            if (rest == 1) {
                count++;
                if (count > max) {
                    max = count;
                }
            } else {
                count = 0;
            }
            
            n /= 2;
        }
        
        System.out.println(max);
    }
}
