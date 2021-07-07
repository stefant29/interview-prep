import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    
    public static boolean findSubstring(TreeMap<Integer, List<String>> map, String find) {
        return map.get(find.length()).contains(find);
    }

    public static String findRest(TreeMap<Integer, List<String>> map, String loginAttempt, int start, HashSet<String> notFound) {
        // make use of memoization: keep track of passwords that could not match anything, to skip them
        if (notFound.contains(loginAttempt)) {
            return null;
        }
        
        // if the password is found as is in the list of passwords
        if (map.containsKey(loginAttempt.length()) && map.get(loginAttempt.length()).contains(loginAttempt)) {
            return loginAttempt;
        }
        
        // go through each group of passwords: 1 letter, 2 letters, 3 letters...
        for (int j : map.keySet()) {
            // if this password is a substring of the loginAttempt, do the same, recursevly for the rest of the string
            if (j <= loginAttempt.length() && findSubstring(map, loginAttempt.substring(0, j))) {
                String rest = findRest(map, loginAttempt.substring(j), j + start, notFound);
                // if a match was found for the rest of the substring, return this password and then the rest
                if (rest != null) {
                    return loginAttempt.substring(0, j) + " " + rest;
                }
            }
        }
        
        // save this loginAttempt to the "blacklist" memoization array to skip it next time
        notFound.add(loginAttempt);
               
        return null;
    }

    public static String passwordCracker(List<String> passwords, String loginAttempt) {
        // save all passwords in a map: [ password.length => list<passwords> ]
        TreeMap<Integer, List<String>> map = new TreeMap<Integer, List<String>>(Collections.reverseOrder());
        for (String s : passwords) {
            List<String> list;
            if (map.containsKey(s.length())) {
                list = map.get(s.length());
            } else {
                list = new ArrayList<String>();
            }
            list.add(s);
            map.put(s.length(), list);
        }
        
        String rest = findRest(map, loginAttempt, 0, new HashSet<String>());
        return rest == null ? "WRONG PASSWORD" : rest;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<String> passwords = Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "));

            String loginAttempt = bufferedReader.readLine();

            String result = Result.passwordCracker(passwords, loginAttempt);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
