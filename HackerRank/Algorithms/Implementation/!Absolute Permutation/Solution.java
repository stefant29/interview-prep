// https://www.hackerrank.com/challenges/absolute-permutation

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

    public static List<Integer> absolutePermutation(int n, int k) {
        if (k < 0 || 2 * k > n) {
            return Arrays.asList(new Integer[] {-1});
        }
        
        HashSet<Integer> set = new HashSet<Integer>();
        List<Integer> result = new ArrayList();

        for (int i = 1; i <= n; i++) {
            if (i < k + 1) {
                result.add(k + i);
                set.add(k + i);
            } else {
                if (!set.contains(i - k)) {
                    result.add(i - k);
                    set.add(i - k);
                } else if (set.contains(k + i) || i + k > n) {
                    return Arrays.asList(new Integer[] {-1});
                } else {
                    result.add(i + k);
                    set.add(k + i);
                }
            }
        }

        return result;
    }

    /** 
     * This function works only for SHIFTING elements to the right and not for PERMUTATIONS
     */
    public static List<Integer> absoluteShift(int n, int k) {
        for (int i = 1; i <=n; i++) {
            int temp = k + i;
            if (temp > n) {
                temp = temp % n;
            }
            if (Math.abs(temp - i) != k) {
                return Arrays.asList(new Integer[]{-1});
            }
        }
        
        List<Integer> result = new ArrayList<Integer>();
        for (int i = k+1; i <= n; i++) {
            result.add(i);
        }
        for (int i = 1; i < k+1; i++) {
            result.add(i);
        }
        
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int k = Integer.parseInt(firstMultipleInput[1]);

                List<Integer> result = Result.absolutePermutation(n, k);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
