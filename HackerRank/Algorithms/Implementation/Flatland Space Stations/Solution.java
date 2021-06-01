// https://www.hackerrank.com/challenges/flatland-space-stations

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int flatlandSpaceStations(int n, int[] c) {
        int minimumDistance = 0, crtMin;
        
        Arrays.sort(c);
        
        for (int city = 0; city < n; city++) {
            int position = Arrays.binarySearch(c, city);
            
            if (position < 0) {
                position = position * (-1) - 1;
                
                if (position == 0) {
                    crtMin = c[position] - city;
                } else if (position >= c.length) {
                    crtMin = city - c[position-1];
                } else {
                    crtMin = Math.min(city - c[position-1], c[position] - city);
                }
                
                if (minimumDistance < crtMin) {
                    minimumDistance = crtMin;
                }
            }
        }

        return minimumDistance;
    }
    
    /** 
     * Another approach
     */
    static int flatlandSpaceStations2(int n, int[] c) {       
        Arrays.sort(c);
        
        int max = c[0];
        for (int i = 1; i < c.length; i++) {
            if (max < (c[i] - c[i-1])/2) {
                max = (c[i] - c[i-1])/2;
            }
        }
        
        if (max == 1) {
            return 1;
        }
        
        return Math.max(max, n - c[c.length - 1] - 1);
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = flatlandSpaceStations(n, c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
