// https://www.hackerrank.com/challenges/java-bitset

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        BitSet b1 = new BitSet(n);
        BitSet b2 = new BitSet(n);
        
        for (int i = 0; i < m; i++) {
            String s = sc.next();
            int op1 = sc.nextInt();
            int op2 = sc.nextInt();
            
            switch(s) {
                case "AND":
                    if (op1 == 1) {
                        b1.and(b2);
                    } else {
                        b2.and(b1);
                    }
                    break;
                case "OR":
                    if (op1 == 1) {
                        b1.or(b2);
                    } else {
                        b2.or(b1);
                    }
                    break;
                case "XOR":
                    if (op1 == 1) {
                        b1.xor(b2);
                    } else {
                        b2.xor(b1);
                    }
                    break;
                case "FLIP":
                    if (op1 == 1) {
                        b1.flip(op2);
                    } else {
                        b2.flip(op2);
                    }
                    break;
                case "SET":
                    if (op1 == 1) {
                        b1.set(op2);
                    } else {
                        b2.set(op2);
                    }
                    break;
            }
            System.out.println(b1.cardinality() + " " + b2.cardinality());
        }
    }
}
