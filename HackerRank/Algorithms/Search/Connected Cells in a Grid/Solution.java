// https://www.hackerrank.com/challenges/connected-cell-in-a-grid

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

    public static int connectedCell(List<List<Integer>> matrix) {
        // first approach: trivial - for + MAP
        // cauta toti vecinii in MAP; fiecare (x,y) va avea un index -> indexul regiunii
        // daca nu are niciun vecin in map => o noua regiune cu ++index;

        // better approach: BFS
        // is it BETTER though??

        // add padding to the mat
        int[][] mat = new int[matrix.size() + 2][matrix.get(0).size() + 2];
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(0).size(); j++) {
                mat[i + 1][j + 1] = matrix.get(i).get(j);
            }
        }

        Map<String, Integer> map = new HashMap();
        int regionCount = 0;
        for (int i = 1; i < mat.length - 1; i++) {
            for (int j = 1; j < mat[0].length - 1; j++) {
                if (mat[i][j] == 1) {
                    if (mat[i - 1][j - 1] == 1) {
                        addNeighbours(i, j, mat, map, map.get((i - 1) + "" + (j - 1)));
                    } else if (mat[i - 1][j] == 1) {
                        addNeighbours(i, j, mat, map, map.get((i - 1) + "" + (j)));
                    } else if (mat[i - 1][j + 1] == 1) {
                        addNeighbours(i, j, mat, map, map.get((i - 1) + "" + (j + 1)));
                    } else if (mat[i][j - 1] == 1) {
                        addNeighbours(i, j, mat, map, map.get((i) + "" + (j - 1)));
                    } else {
                        addNeighbours(i, j, mat, map, regionCount + 1);
                        regionCount++;
                    }
                }
            }
        }

        int maxRegionCount = -1;
        Map<Integer, Integer> countRegions = new HashMap();
        for (String s : map.keySet()) {
            countRegions.put(map.get(s), countRegions.getOrDefault(map.get(s), 0) + 1);
        }

        for (int i : countRegions.keySet()) {
            maxRegionCount = (int) Math.max(maxRegionCount, countRegions.get(i));
        }

        return maxRegionCount;
    }

    private static void addNeighbours(int i, int j, int[][] mat, Map<String, Integer> map, int regionCount) {
        map.put(i + "" + j, regionCount);
        addNeighbour(i - 1, j - 1, mat, map, regionCount);
        addNeighbour(i - 1, j, mat, map, regionCount);
        addNeighbour(i - 1, j + 1, mat, map, regionCount);
        addNeighbour(i, j - 1, mat, map, regionCount);
        addNeighbour(i, j + 1, mat, map, regionCount);
        addNeighbour(i + 1, j - 1, mat, map, regionCount);
        addNeighbour(i + 1, j, mat, map, regionCount);
        addNeighbour(i + 1, j + 1, mat, map, regionCount);
    }

    private static void addNeighbour(int i, int j, int[][] mat, Map<String, Integer> map, int regionCount) {
        if (mat[i][j] == 1) {

            if (map.containsKey(i + "" + j) && map.get(i + "" + j) != regionCount) {
                mergeRegions(map.get(i + "" + j), regionCount, mat, map);
            }

            map.put(i + "" + j, regionCount);
        }
    }

    private static void mergeRegions(int originalRegion, int regionToChange, int[][] mat, Map<String, Integer> map) {
        // toate din map care au val originalRegion trebuie schimbate cu regionToChange
        for (String s : map.keySet()) {
            if (map.get(s) == originalRegion) {
                map.put(s, regionToChange);
            }
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("xxx.out"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                matrix.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt).collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.connectedCell(matrix);

        System.out.println(result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
