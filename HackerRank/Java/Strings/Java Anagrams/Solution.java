// https://www.hackerrank.com/challenges/java-anagrams

import java.io.*;
import java.util.*;

public class Solution {

    
    static boolean isAnagram(String a, String b) {
        HashMap<Character, Integer> map = new HashMap<>();
        a = a.toLowerCase();
        b = b.toLowerCase();
        
        if (a.length() != b.length()) {
            return false;
        }
        for(int i = 0; i < a.length(); i++) {
            if (map.containsKey(a.charAt(i))) {
                map.put(a.charAt(i), map.get(a.charAt(i)) + 1);
            } else {
                map.put(a.charAt(i), 1);
            }
            
            if (map.containsKey(b.charAt(i))) {
                map.put(b.charAt(i), map.get(b.charAt(i)) - 1);
            } else {
                map.put(b.charAt(i), -1);
            }
        }
        
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        
        return true;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
