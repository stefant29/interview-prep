import java.util.*;
import java.io.*;

class Solution {
    public static void printSeries(int a, int b, int n) {
        for (int i = 0; i < n; i++) {
            a += Math.pow(2, i) * b;
            System.out.print(a + " ");
        }
        System.out.println();
    }
    
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            
            printSeries(a, b, n);
        }
        in.close();
    }
}
