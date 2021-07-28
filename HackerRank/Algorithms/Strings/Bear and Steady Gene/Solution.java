// https://www.hackerrank.com/challenges/bear-and-steady-gene

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

       public static int steadyGene(String gene) {
        char[] genes = new char[] { 'A', 'G', 'C', 'T' };
        int end = 0, start = 0, minWindow = Integer.MAX_VALUE;
        HashMap<Character, Integer> mapCount = new HashMap();
        HashMap<Character, Integer> mapCrt = new HashMap();

        for (char c : gene.toCharArray()) {
            mapCount.put(c, mapCount.getOrDefault(c, 0) + 1);
        }

        for (char c : genes) {
            // update mapCount with the number of chars that need to be deleted
            mapCount.put(c, Math.max(0, mapCount.getOrDefault(c, 0) - gene.length() / 4));
            mapCrt.put(c, 0);
        }

        while (end < gene.length()) {
            mapCrt.put(gene.charAt(end), mapCrt.get(gene.charAt(end)) + 1);

            // try to increase lower bound while still keeping condition true
            while (start < gene.length() && 
                    mapCrt.get('A') >= mapCount.get('A') && mapCrt.get('G') >= mapCount.get('G') &&
                    mapCrt.get('C') >= mapCount.get('C') && mapCrt.get('T') >= mapCount.get('T')) {
                if (end - start + 1 < minWindow) {
                    minWindow = end - start + 1;
                }

                // update mapCrt: remove the first element since we will increase the start of the window
                mapCrt.put(gene.charAt(start), mapCrt.get(gene.charAt(start)) - 1);

                // increase window start
                start++;
            }

            // increase window end
            end++;
        }

        return minWindow;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String gene = bufferedReader.readLine();

        int result = Result.steadyGene(gene);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
