// https://www.hackerrank.com/challenges/kaprekar-numbers

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static boolean isKaprekar(int n) {
        long pow = (long) Math.pow(n, 2);
        
        String powString = "" + pow;
        String left = powString.substring(0, powString.length()/2);
        String right = powString.substring(powString.length()/2);
        
        try {
            if (Integer.parseInt(left) + Integer.parseInt(right) == n) {
                return true;
            }
        } catch (NumberFormatException exception) {}
        
        return false;
    }

    public static void kaprekarNumbers(int p, int q) {
        if (p++ == 1) {
            System.out.print("1 ");
        }
        
        boolean kaprekarExists = false;
        for (int i = p; i <= q; i++) {
            if (isKaprekar(i)) {
                System.out.print(i + " ");
                kaprekarExists = true;
            }
        }
        if (!kaprekarExists) {
            System.out.println("INVALID RANGE");
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        Result.kaprekarNumbers(p, q);

        bufferedReader.close();
    }
}
