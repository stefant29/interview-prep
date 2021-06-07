// https://www.hackerrank.com/challenges/climbing-the-leaderboard

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

    public static List<Integer> climbingLeaderboard(List<Integer> leaderboardScores, 
                                                    List<Integer> playerScores) {
        List<Integer> playerRanking = new ArrayList();

        // eliminate duplicates
        for (int i = 0; i < leaderboardScores.size()-1; i++) {
            if (leaderboardScores.get(i).equals(leaderboardScores.get(i+1))) {
                leaderboardScores.remove(i);
                // since one element was removed, i will now point to the next element
                //   so we need to decrement it
                i--;
            }
        }
        
        // use BinarySearch to determine where the score should be placed within the ranking
        for (int score : playerScores) {
            int index = Collections.binarySearch(leaderboardScores, score, Comparator.reverseOrder());
            
            if (index >= 0) {
                playerRanking.add(index + 1);
            } else {
                playerRanking.add(index * (-1));
            }
        }
        
        return playerRanking;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

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
