// https://www.hackerrank.com/challenges/java-stack

import java.util.*;

class Solution{
	
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			String input=sc.next();
            System.out.println(checkValidity(input));
		}	
	}
    
    public static boolean checkValidity(String input) {
        Stack<Character> stack = new Stack<Character>();

        for (char c : input.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if ( (c == ')' && (stack.empty() || stack.pop() != '(')) || 
                        (c == ']' && (stack.empty() || stack.pop() != '[')) ||
                        (c == '}' && (stack.empty() || stack.pop() != '{')) ) {
                return false;
            }
        }
                
        return stack.empty();
    }
}
