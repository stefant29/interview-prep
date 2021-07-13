// https://www.hackerrank.com/challenges/30-exceptions-string-to-integer

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

        String S = bufferedReader.readLine();

        bufferedReader.close();
        
        try {
            System.out.println(Integer.parseInt(S));
        } catch (Exception e) {
            System.out.println("Bad String");
        }
    }
}
