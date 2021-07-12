// https://www.hackerrank.com/challenges/30-scope

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Difference {
  	private int[] elements;
  	public int maximumDifference;

	public Difference(int[] arr) {
        this.elements = arr;
    }
    
    public void computeDifference() {
        if (elements.length == 0) {
            return;
        }
        
        int min = elements[0], max = elements[0];
        for (int i : elements) {
            min = (int) Math.min(min, i);
            max = (int) Math.max(max, i);
        }
        
        maximumDifference = (int) Math.abs(max - min);
    }

} // End of Difference class

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}