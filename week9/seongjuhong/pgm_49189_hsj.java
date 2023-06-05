package programmers;

import java.util.*;

public class pg_49189_2 {

    Map<Integer, Integer> map = new HashMap<>();
    public int solution(int n, int[][] edge) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i<n+1; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i< edge.length; i++) {
            int start = edge[i][0];
            int end = edge[i][1];
            list.get(start).add(end);
            list.get(end).add(start);
        }

        boolean[] visited = new boolean[n+1];

        visited[1] = true;
        Integer[] arr = new Integer[]{1, 0};

        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(arr);

        int[] result = new int[n+1];
        Arrays.fill(result, Integer.MAX_VALUE-1);
        int max1 = -1;
        while(!queue.isEmpty()) {
            Integer[] arr1 = queue.poll();

            int start = arr1[0];
            int cnt = arr1[1];

            for(int i = 0; i<list.get(start).size(); i++) {
                int end = list.get(start).get(i);
                if(!visited[end]) {
                    visited[end] = true;

                    if(result[end] > cnt + 1) {
                        result[end] = cnt + 1;
                        if(max1 < cnt + 1) {
                            max1 = cnt + 1;
                        }
                    }
                    queue.add(new Integer[]{end, cnt+1});
                }
            }
        }

        int count = 0;
        for(int i : result) {
            if(i == max1) {
                count++;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        pg_49189_2 p = new pg_49189_2();
        int n = 6;
        int[][] edge = new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        System.out.println(p.solution(n, edge));
    }


}
