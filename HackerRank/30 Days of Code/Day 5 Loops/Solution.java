// https://www.hackerrank.com/challenges/30-loops

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
        
        int number = n;
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + number);
            number += n;
        }

        bufferedReader.close();
    }
}
