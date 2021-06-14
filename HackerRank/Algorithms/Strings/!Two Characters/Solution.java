// https://www.hackerrank.com/challenges/two-characters

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
    
    public static boolean checkAlternate(char c1, char c2, String s) {
        char lastChar = '*';
        for (int i = 0; i < s.length(); i++) {
            if (c1 == s.charAt(i)) {
                if (lastChar == c1) {
                    return false;
                }
                
                lastChar = c1;
            }
            
            if (c2 == s.charAt(i)) {
                if (lastChar == c2) {
                    return false;
                }
                
                lastChar = c2;
            }
        }
        
        return true;
    }

    public static int alternate(String s) {
        int maxLen = 0;
        ConcurrentHashMap<Character, Integer> map = new ConcurrentHashMap();
        
        // count occurrences of chars in string
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        // for each pair i,j check if string s contains them alternating
        for (char c1 : map.keySet()) {
            for (char c2 : map.keySet()) {
                // if they alternate, compute the total length and update maxLen
                if (c1 != c2 && checkAlternate(c1, c2, s)) {
                    maxLen = Math.max(maxLen, map.get(c1) + map.get(c2));
                }
            }

            map.remove(c1);
        }
        
        return maxLen;
    }
    
    
    /**
     * Same solution, but using occurrences vector
     */
    public static int alternate2(String s) {
        int maxLen = 0;
        int[] count = new int[26];
        // count occurrences of chars in string
        for (char c : s.toCharArray()) {
            count[c-'a']++;
        }
        
        // for each pair i,j check if string s contains them alternating
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) {
                continue;
            }
            
            for (int j = 0; j < 26; j++) {
                // if they alternate, compute the total length and update maxLen
                if (i != j && count[j] != 0 && checkAlternate((char)('a'+i), (char)('a'+j), s)) {
                    maxLen = Math.max(maxLen, count[i] + count[j]);
                }
            }
            
            count[i] = 0;
        }
        
        return maxLen;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = Result.alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
