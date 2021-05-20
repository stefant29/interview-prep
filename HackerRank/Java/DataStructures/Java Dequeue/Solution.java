// https://www.hackerrank.com/challenges/java-dequeue

import java.util.*;
public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();
        HashSet<Integer> set = new HashSet();

        int total = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            
            deque.addLast(num);
            set.add(num);
            
            if (deque.size() == m) {
                int first = deque.removeFirst();
                
                if (set.size() > total) {
                    total = set.size();
                }
                
                if (!deque.contains(first)) {
                    set.remove(first);
                }
            }
        }
        
        System.out.println(total);
    }
}
