package interview;

//https://www.hackerrank.com/challenges/sherlock-and-anagrams

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

	public static HashMap<Character, Integer> cloneMap(HashMap<Character, Integer> map) {
		HashMap<Character, Integer> deepCopyMap = new HashMap();

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			deepCopyMap.put(entry.getKey(), entry.getValue());
		}

		return deepCopyMap;
	}

	public static int sherlockAndAnagrams(String s) {
		int count = 0;

		// handle case when noDigits = 1 separately;
		int[] freq = new int[26];
		for (char c : s.toCharArray()) {
			freq[c - 'a']++;
		}
		for (int i : freq) {
			count += i * (i - 1) / 2;
		}

		for (int noDigits = 2; noDigits < s.length(); noDigits++) {
			for (int start = 0; start < s.length() - noDigits + 1; start++) {
				HashMap<Character, Integer> map = new HashMap();
				// get first "noDigits" in the map
				for (int i = start; i < start + noDigits; i++) {
					map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
				}

				// iterate through the rest of the string, looking for matches
				for (int i = start + 1; i < s.length() - noDigits + 1; i++) {
					HashMap<Character, Integer> mapCopy = Result.cloneMap(map);

					for (int j = i; j < i + noDigits; j++) {
						// the current substring contains a char not present in the first substring of
						// "noDigits" chars
						if (!mapCopy.containsKey(s.charAt(j))) {
							break;
						} else {
							if (mapCopy.get(s.charAt(j)) - 1 == 0) {
								mapCopy.remove(s.charAt(j));
							} else {
								mapCopy.put(s.charAt(j), mapCopy.get(s.charAt(j)) - 1);
							}
						}
					}

					// if there is nothing left in the map => all the chars have matched, so add to
					// the counter
					if (mapCopy.isEmpty()) {
						count++;
					}
				}
			}

		}

		return count;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, q).forEach(qItr -> {
			try {
				String s = bufferedReader.readLine();

				int result = Result.sherlockAndAnagrams(s);

				bufferedWriter.write(String.valueOf(result));
				bufferedWriter.newLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
		bufferedWriter.close();
	}
}
