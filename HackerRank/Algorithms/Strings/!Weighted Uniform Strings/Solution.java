// https://www.hackerrank.com/challenges/weighted-uniform-string

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

    public static List<String> weightedUniformStrings(String s, List<Integer> queries) {
        List<String> result = new ArrayList();
        Set<Integer> set = new HashSet();
        
        for (int i = 0; i < s.length(); i++) {
            int counter = 1;
            int charWeight = s.charAt(i) - 'a' + 1;
            set.add(counter * charWeight);

            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
                i++;
                counter++;
                set.add(counter * charWeight);
            }
        }
        
        for (int query : queries) {
            result.add(set.contains(query) ? "Yes" : "No");
        }
        
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<String> result = Result.weightedUniformStrings(s, queries);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
