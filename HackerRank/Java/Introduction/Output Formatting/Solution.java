import java.util.Scanner;

public class Solution {

    public static void printNicely(String s, int x) {
        System.out.print(s);
        for (int i = 0; i < 15 - s.length(); i++) {
            System.out.print(" ");
        }
        if (x < 10) {
            System.out.print("00");
        } else if (x < 100) {
            System.out.print("0");
        }
        System.out.println(x);
    }

    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("================================");
            for(int i=0;i<3;i++){
                String s1=sc.next();
                int x=sc.nextInt();
                
                //printNicely(s1, x);
                System.out.printf("%-15s%03d%n", s1, x);
            }
            System.out.println("================================");

    }
}
