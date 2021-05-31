// https://www.hackerrank.com/challenges/acm-icpc-team

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
     * Basic solution
     */
    public static int or(String s1, String s2) {
        int count = 0;
        
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == '1' || s2.charAt(i) == '1') {
                count++;
            }
        }

        return count;
    }
      
    public static List<Integer> acmTeamBasic(List<String> topic) {
        int max = 0, count = 0;
        for (int i = 0; i < topic.size() - 1; i++) {
            for (int j = i+1; j < topic.size(); j++) {
                int crtMax = or(topic.get(i), topic.get(j));
                if (crtMax > max) {
                    max = crtMax;
                    count = 1;
                } else if (crtMax == max) {
                    count++;
                }
            }
        }
        
        return new ArrayList<Integer>(Arrays.asList(max, count));
    }





    /**
     * Advanced solution using BitSets
     */
    private static BitSet fromString(String binary) {
        BitSet bitset = new BitSet(binary.length());
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                bitset.set(i);
            }
        }
        return bitset;
    }
    
    public static List<Integer> acmTeam(List<String> topic) {
        List<BitSet> bitSets = new ArrayList();
        for (String s : topic) {
            bitSets.add(fromString(s));
        }
        
        int max = 0, count = 0;
        for (int i = 0; i < bitSets.size() - 1; i++) {
            for (int j = i+1; j < bitSets.size(); j++) {
                BitSet copy = (BitSet) bitSets.get(i).clone();
                copy.or(bitSets.get(j));

                int crtMax = copy.cardinality();
                if (crtMax > max) {
                    max = crtMax;
                    count = 1;
                } else if (crtMax == max) {
                    count++;
                }
            }
        }
        
        return new ArrayList<Integer>(Arrays.asList(max, count));
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<String> topic = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> result = Result.acmTeam(topic);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
