package programmers;

import java.util.*;

public class pg42586 {
    public static int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer[]> deque = new ArrayDeque<>();

        for(int i = 0; i< progresses.length; i++) {
            Integer[] integers = new Integer[2];
            integers[0] = progresses[i];
            integers[1] = speeds[i];
            deque.addLast(integers);
        }
        List<Integer> days = new ArrayList<>();
        while (!deque.isEmpty()) {
            int size = deque.size();
            for(int i = 0; i<size; i++) {
                Integer[] integers = deque.poll();
                if(integers[0] < 100) {
                    integers[0] += integers[1];
                }
                deque.addLast(integers);
            }
            Stack<Integer[]> stack = new Stack<>();
            for(int i = 0; i<size; i++) {
                Integer[] integers = deque.poll();
                if(integers[0] < 100) {
                    deque.addFirst(integers);
                    if(stack.size() != 0) {
                        days.add(stack.size());
                    }
                    break;
                }
                stack.add(integers);
            }
            if(deque.isEmpty()) {
                days.add(stack.size());
            }
        }

        return days.stream()
                .mapToInt(i -> i)
                .toArray();
    }

    public static void main(String[] args) {
        int[] progresses = new int[]{93,90,99,99,80,99};
        int[] speeds = new int[]{1,1,1,1,1,1};

        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }
}
