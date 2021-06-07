// https://www.hackerrank.com/challenges/encryption

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

    public static String encryption(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        
        s = s.replace(" ", "");

        int sqrt_low = (int) Math.floor(Math.sqrt(s.length()));
        int sqrt_high = (int) Math.ceil(Math.sqrt(s.length()));
        
        int maxI, maxJ;
        if (sqrt_low * sqrt_low >= s.length()) {
            maxI = sqrt_low;
            maxJ = sqrt_low;
        } else if (sqrt_low * sqrt_high >= s.length()) {
            maxI = sqrt_low;
            maxJ = sqrt_high;
        } else {
            maxI = sqrt_high;
            maxJ = sqrt_high;
        }
        
        for (int i = 0; i < maxJ; i++) {
            for (int j = 0; j < maxI; j++) {
                if (j*maxJ + i < s.length()) {
                    stringBuffer.append(s.charAt(j*maxJ + i));
                }
            }
            stringBuffer.append(" ");
        }
        
        return stringBuffer.toString();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
