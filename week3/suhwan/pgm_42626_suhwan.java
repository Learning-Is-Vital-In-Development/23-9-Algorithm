package pgm;

import java.util.PriorityQueue;
import java.util.Queue;

public class pgm_42626_suhwan {

    public static void main(String[] args) {
        int[] scoville = {1, 1, 1, 1, 0, 0};
        System.out.println(solution(scoville, 7));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> queue = new PriorityQueue<>();

        for (int i : scoville) {
            queue.add(i);
        }
        while (queue.peek() < K) {
            if (queue.size() < 2 ) {
                return -1;
            }
            queue.add(queue.poll() + queue.poll() * 2);
            answer++;
        }
        return answer;
    }

}
