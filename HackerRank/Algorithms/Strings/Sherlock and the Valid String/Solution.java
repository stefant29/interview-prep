// https://www.hackerrank.com/challenges/sherlock-and-valid-string

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

    public static String isValid(String s) {
        int[] frequencies =  new int[26];
        for (char c : s.toCharArray()) {
            frequencies[c - 'a']++;
        }
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < 26; i++) {
            if (frequencies[i] != 0) {
                map.put(frequencies[i], map.getOrDefault(frequencies[i], 0) + 1);
            } 
        }
        
        // no need to remove any characters
        if (map.size() == 1) {
            return "YES";
        }
        
        // too many characters to remove
        if (map.size() > 2) {
            return "NO";
        }

        // we know for sure there are two groups: 
        //   one with key1 appearances and the other with key2 appearances
        //   val1 is the number of characters with key1 appearances
        //   val2 is the number of characters with key2 appearances
        List<Integer> list = new ArrayList(map.keySet());
        int key1 = list.get(0);
        int key2 = list.get(1);
        int val1 = map.get(key1);
        int val2 = map.get(key2);
        
        // if the number of characers and their appearances is 1, it can be safely removed:
        if (val1 == 1 && key1 == 1 || val2 == 1 && key2 == 1) {
            return "YES";
        }
        
        // if the number of appearances is 1 and the number of characters differ by 1, the character can be removed
        if (val1 == 1 && key1 - key2 == 1 || val2 == 1 && key2 - key1 == 1) {
            return "YES";
        }        
        
        return "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
