// https://www.hackerrank.com/challenges/phone-book

import java.util.*;
import java.io.*;

class Solution{
	public static void main(String []argh) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap();

		int n = Integer.parseInt(br.readLine());

		for(int i = 0; i < n; i++) {
            map.put(br.readLine(), Integer.parseInt(br.readLine()));
		}

        String name = null;
		while((name = br.readLine()) != null) {
            if (map.containsKey(name)) {
                System.out.println(name + "=" + map.get(name));
            } else {
                System.out.println("Not found");
            }
		}
	}
}
