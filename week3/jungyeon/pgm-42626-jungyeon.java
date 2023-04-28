import java.util.*;

class Solution {
    public int solution(int[] sco, int K) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int answer = 0;
        
        for (int i = 0; i < sco.length; i++) {
            priorityQueue.offer(sco[i]);
        }
                           
        while (!priorityQueue.isEmpty()) {
            int current = priorityQueue.poll();
            
            if (current < K) {
                if (priorityQueue.size() == 0) {
                    return -1;
                }
                int next = priorityQueue.poll();
                int sum = current + next * 2;
                priorityQueue.offer(sum);
                answer++;
                
            }
        }
        return answer;
    }
}
