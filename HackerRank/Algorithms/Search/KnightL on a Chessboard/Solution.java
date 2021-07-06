// https://www.hackerrank.com/challenges/knightl-on-chessboard

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

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /*
     * Get all possible moves given distances a, b and a matrix of n x n
     */
    public HashSet<Pair> getEdges(int a, int b, int n) {
        return new HashSet<Pair>() {
            {
                if (x - a >= 0 && y - b >= 0) {
                    add(new Pair(x - a, y - b));
                }
                if (x + a < n && y - b >= 0) {
                    add(new Pair(x + a, y - b));
                }
                if (x - a >= 0 && y + b < n) {
                    add(new Pair(x - a, y + b));
                }
                if (x + a < n && y + b < n) {
                    add(new Pair(x + a, y + b));
                }

                if (x - b >= 0 && y - a >= 0) {
                    add(new Pair(x - b, y - a));
                }
                if (x + b < n && y - a >= 0) {
                    add(new Pair(x + b, y - a));
                }
                if (x - b >= 0 && y + a < n) {
                    add(new Pair(x - b, y + a));
                }
                if (x + b < n && y + a < n) {
                    add(new Pair(x + b, y + a));
                }
            }
        };
    }
    
    /**
     * Set the same hashCode so HashMap can use equals() when comparing keys
     */
    @Override
    public int hashCode() {
        return 0;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        
        if (!(obj instanceof Pair)) {
            return false;
        }
        
        Pair p = (Pair) obj;
        return this.x == p.x && this.y == p.y;
    }
}

class Result {

    /*
 1  procedure BFS(G, root) is
 2      let Q be a queue
 3      label root as explored
 4      Q.enqueue(root)
 5      while Q is not empty do
 6          v := Q.dequeue()
 7          if v is the goal then
 8              return v
 9          for all edges from v to w in G.adjacentEdges(v) do
10              if w is not labeled as explored then
11                  label w as explored
12                  Q.enqueue(w)
     */
    
    public static int bfs(int a, int b, int n) {
        Queue<Pair> q = new LinkedList();
        Map<Pair, Integer> explored = new HashMap();
        Pair root = new Pair(0, 0), end = new Pair(n-1, n-1);
        
        // mark root as explored
        explored.put(root, 0);
        
        // add root
        q.add(root);
        
        while (!q.isEmpty()) {
            Pair v = q.poll();
            
            if (v.equals(end)) {
                return explored.get(v);
            }
            
            // get all possible moves from the current position
            for (Pair w : v.getEdges(a, b, n)) {
                // if any of them is unexplored
                if (!explored.containsKey(w)) {
                    // add it to the explored map along its level
                    explored.put(w, 1 + explored.get(v));
                    // and add it to the queue to be processed
                    q.add(w);
                }
            }
        }
        
        return -1;
    }

    public static List<List<Integer>> knightlOnAChessboard(int n) {
        List<List<Integer>> result = new ArrayList();
        
        for (int a = 1; a < n; a++) {
            List<Integer> listA = new ArrayList();
        
            for (int b = 1; b < n; b++) {
                listA.add(bfs(a, b, n));
            }
            
            result.add(listA);
        }
        
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> result = Result.knightlOnAChessboard(n);

        result.stream()
            .map(
                r -> r.stream()
                    .map(Object::toString)
                    .collect(joining(" "))
            )
            .map(r -> r + "\n")
            .collect(toList())
            .forEach(e -> {
                try {
                    bufferedWriter.write(e);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
