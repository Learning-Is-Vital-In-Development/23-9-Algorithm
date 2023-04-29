package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class pg42626 {
    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> foods = new PriorityQueue<>(Comparator.naturalOrder());

        for (int i : scoville) {
            foods.add(i);
        }

        int count = 0;
        while (foods.peek() < K) {
            count++;
            int food1 = foods.poll();
            int food2 = foods.poll();


            int newFood = food1 + (food2 * 2);
            foods.add(newFood);

            if(foods.size() <= 1) {
                break;
            }
        }

        if(foods.size() == 1 && foods.peek() < K) {
            return -1;
        } else {
            return count;
        }
    }
}
