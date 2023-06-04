package pgm;

import java.util.*;

public class pgm_49189_suhwan {

    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(n, edge));
    }

    public static int solution(int n, int[][] edge) {
        int answer = 0;
        List<List<Integer>> list = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < edge.length; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] ints : edge) {
            list.get(ints[0]).add(ints[1]);
            list.get(ints[1]).add(ints[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited.add(1);
        int size = 0;

        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer node = queue.poll();
                for (int j = 0; j < list.get(node).size(); j++) {
                    if (!visited.contains(list.get(node).get(j))) {
                        visited.add(list.get(node).get(j));
                        queue.offer(list.get(node).get(j));
                    }
                }
            }
            answer = size;
        }
        return answer;
    }
}
