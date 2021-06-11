// https://www.hackerrank.com/challenges/bigger-is-greater

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

    public static String biggerIsGreater(String w) {
        int end = w.length() - 1;
        while (end > 0 && w.charAt(end - 1) >= w.charAt(end)) {
            end--;
        }
        
        int indexToReplace = end-1;
        if (indexToReplace < 0) {
            return "no answer";
        }           
            
        end = w.length() - 1;
        while (w.charAt(indexToReplace) >= w.charAt(end)) {
            end--;
        }
        
        int indexReplaceWith = end;
        
        // append Prefix with bigger character and the rest of the string sorted
        String result = w.substring(0, indexToReplace) + w.charAt(indexReplaceWith) + sortString(w.substring(indexToReplace, indexReplaceWith) + w.substring(indexReplaceWith+1));

        return result.equals(w) ? "no answer" : result;
    }
    
    public static String sortString(String s) {
        int[] alphabet = new int[26];
        for (char c : s.toCharArray()) {
            alphabet[c-'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < alphabet[i]; j++) {
                sb.append((char)('a' + i));
            }
        }
        
        return sb.toString();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String w = bufferedReader.readLine();

                String result = Result.biggerIsGreater(w);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
