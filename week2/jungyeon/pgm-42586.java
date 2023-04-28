import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class Solution {

        public int[] solution(int[] progresses, int[] speeds) {
            Queue<Integer> queue1 = new LinkedList<>();
            List<Integer> list = new ArrayList<>();


            for (int i = 0; i < progresses.length; i++) {
                int work = 100 - progresses[i];

                if (work % speeds[i] == 0) {
                    queue1.add(work / speeds[i]);
                }
                else {
                    queue1.add(work / speeds[i] + 1);
                }
            }

            while (!queue1.isEmpty()) {
                int count = 1;
                int day = queue1.poll();

                while (!queue1.isEmpty() && day >= queue1.peek()) {
                    count++;
                    queue1.poll();
                }

                list.add(count);
            }

            int[] answer = new int[list.size()];

            for (int i = 0; i < answer.length; i++) {
                answer[i]= list.get(i);
            }

            return answer;
        }
    }

