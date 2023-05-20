package programmers;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class pg42885 {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        Deque<Integer> deque = new ArrayDeque<>();
        for (int person : people) {
            deque.addLast(person);
        }

        int tube = 0;
        if(deque.size() <=1) {
            return 1;
        }

        while (!deque.isEmpty()) {
            int max = deque.pollLast();
            if(deque.isEmpty()) {
                tube++; break;
            }
            int min = deque.peekFirst();

            if(max + min <= limit) {
                tube++;
                deque.pollFirst();
            } else {
                tube++;
            }
        }
        return tube;

    }

    public static void main(String[] args) {
        pg42885 p = new pg42885();
        int[] people = new int[]{70,50,80,50};
        int limit = 100;

        System.out.println(p.solution(people, limit));
    }
}
