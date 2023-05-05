package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class pgm_42627 {
    public int solution(int[][] jobs) {
        PriorityQueue<Integer[]> queue = new PriorityQueue<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer[]> queue1 = new PriorityQueue<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        for(int i = 0; i< jobs.length; i++) {
            Integer[] arr = new Integer[]{jobs[i][0], jobs[i][1],0};
            queue.add(arr);
        }

        int sum = 0;
        int total = 0;

        while (!queue.isEmpty() || !queue1.isEmpty()) {
            Integer[] arr = queue.peek();
            while (!queue.isEmpty()) {
                Integer[] que = queue.peek();
                if(sum >= que[0]) {
                    queue1.add(queue.poll());
                } else {
                    break;
                }
            }
            if(!queue1.isEmpty()) {
                if(sum >= queue1.peek()[0]) {
                    Integer[] q = queue1.poll();
                    sum += q[1];
                    total += (sum - q[0]);
                }
                while (!queue1.isEmpty()) {
                    queue.add(queue1.poll());
                }
            } else {
                Integer[] arr1 = queue.poll();
                sum = arr1[0] + arr1[1];
                total += arr1[1];
            }
        }
        return (int) Math.floor((double) total / jobs.length);
    }

    public static void main(String[] args) {
        pgm_42627 p = new pgm_42627();

        int[][] jobs = {{0,3},{1,9},{2,6}};
        System.out.println(p.solution(jobs));
    }
}
