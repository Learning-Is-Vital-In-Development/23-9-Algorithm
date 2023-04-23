import java.util.PriorityQueue;

public class pgm_42626_tinajeong {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int s : scoville) {
            pq.offer(s);
        }

        int answer = 0;
        while (pq.peek() < K) {
            if (pq.size() == 1) {
                return -1;
            }
            int mixed = pq.poll() + pq.poll() * 2;
            pq.offer(mixed);
            answer++;
        }
        return answer;
    }
}