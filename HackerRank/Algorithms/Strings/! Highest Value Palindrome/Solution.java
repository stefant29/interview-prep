// https://www.hackerrank.com/challenges/richie-rich/problem

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

    public static String highestValuePalindrome(String s, int n, int k) {
        StringBuilder sb = new StringBuilder(s);
        Set<Integer> indexChanged = new HashSet();
        
        for (int i = 0; i < sb.length() / 2; i++) {
            if (sb.charAt(i) != sb.charAt(sb.length() - 1 - i)) {
                if (k <= 0) {
                    return "-1";
                }
                
                char c = sb.charAt(i) > sb.charAt(sb.length() - 1 - i) ? sb.charAt(i) : sb.charAt(sb.length() - 1 - i);
                sb.setCharAt(i, c);
                sb.setCharAt(sb.length() - 1 - i, c);
                
                // keep track of the elements changed, 
                //    in case there are some leftover changes 
                //    and both of these can be turned into '9'
                indexChanged.add(i);
                k--;
            }
        }
        
        for (int i = 0; i < sb.length() / 2; i++) {
            if (sb.charAt(i) == '9') {
                continue;
            } else if (indexChanged.contains(i) && k >= 1) {
                // there are some turns available: turn to 9 a character already changed along with its match to '9'
                sb.setCharAt(i, '9');
                sb.setCharAt(sb.length() - 1 - i, '9');
                k--;
            } else if (k >= 2) {
                // more than 2 turns available: change this and the matching character to '9'
                sb.setCharAt(i, '9');
                sb.setCharAt(sb.length() - 1 - i, '9');
                k -= 2;
            }
        }
        
        // take care of the middle element
        if (sb.length() % 2 == 1 && k > 0) {
            sb.setCharAt(sb.length() / 2, '9');
        }
        
        return sb.toString();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String s = bufferedReader.readLine();

        String result = Result.highestValuePalindrome(s, n, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
