// https://www.hackerrank.com/challenges/30-data-types

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";
		
        Scanner scan = new Scanner(System.in);

        /* Declare second integer, double, and String variables. */
        int a;
        double b;
        String c;

        /* Read and save an integer, double, and String to your variables.*/
        a = Integer.parseInt(scan.nextLine());
        b = Double.parseDouble(scan.nextLine());
        c = scan.nextLine();

        /* Print the sum of both integer variables on a new line. */
        System.out.println(a + i);

        /* Print the sum of the double variables on a new line. */
        System.out.println(b + d);
		
        /* Concatenate and print the String variables on a new line; 
        	the 's' variable above should be printed first. */
        System.out.println(s + c);

        scan.close();
    }
}