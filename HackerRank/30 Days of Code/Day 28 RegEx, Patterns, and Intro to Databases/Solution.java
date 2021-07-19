// https://www.hackerrank.com/challenges/30-regex-patterns

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

        int N = Integer.parseInt(bufferedReader.readLine().trim());
        ArrayList<String> list = new ArrayList<>();
        
        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            String firstName = firstMultipleInput[0];

            String emailID = firstMultipleInput[1];
            
            String[] emailSplit = emailID.split("@");

            if (emailSplit.length > 1 && emailSplit[1].equals("gmail.com")) {
                list.add(firstName);
            }
        }
        
        Collections.sort(list);
        
        for (String name : list) {
            System.out.println(name);
        }
        

        bufferedReader.close();
    }
}
