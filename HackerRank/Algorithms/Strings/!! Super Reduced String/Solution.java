// https://www.hackerrank.com/challenges/reduced-string

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


    /**
     * Improved version: skip 2 identical items at a time
     */
    public static String superReducedString(String s) {
        StringBuffer sb = new StringBuffer();
        boolean deletedSomething = false;
        
        do {
            // reset sb and semaphore
            sb = new StringBuffer();
            deletedSomething = false;

            for (int i = 0; i < s.length(); i++) {               
                // skip the same chars, 2 at a time
                if (i + 1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
                    i++;
                    deletedSomething = true;
                } else {
                    // append the current character
                    sb.append(s.charAt(i));
                }
            }
            
            s = sb.toString();
        } while (deletedSomething);
        
        
        return sb.length() != 0 ? sb.toString() : "Empty String";
    }


    /**
     * Normal version
     */
    public static String superReducedString2(String s) {
        StringBuffer sb = new StringBuffer();
        boolean deletedSomething = false;
        
        do {
            // reset sb and semaphore
            sb = new StringBuffer();
            deletedSomething = false;

            for (int i = 0; i < s.length(); i++) {
                int indexStart = i;
                
                // skip the same chars
                while (i < s.length() && s.charAt(i) == s.charAt(indexStart)) {
                    i++;
                }
                
                // if number of equal items is different than 1, we deleted something
                if (i - indexStart != 1) {
                    deletedSomething = true;
                }

                // if the number of identical items is odd, add the character to result
                if ((i - indexStart) % 2 == 1) {
                    sb.append(s.charAt(indexStart));
                }
            
                // make sure we don't skip any numbers
                i--;
            }
            
            s = sb.toString();
        } while (deletedSomething);
        
        
        return sb.length() != 0 ? sb.toString() : "Empty String";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
