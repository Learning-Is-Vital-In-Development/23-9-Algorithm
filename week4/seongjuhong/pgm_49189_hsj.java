package programmers;

import java.util.*;

public class pg_49189 {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i<=n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i<edge.length; i++) {
            int start = edge[i][0];
            int end = edge[i][1];

            list.get(start).add(end);
            list.get(end).add(start);
        }

        Queue<Integer[]> queue = new LinkedList<>();
        Integer[] arr = new Integer[]{1,0};
        queue.add(arr);

        boolean[] visited = new boolean[n + 1];

        int[] map = new int[n+1];
        Arrays.fill(map, Integer.MAX_VALUE-1);
        map[1] = 0;

        while (!queue.isEmpty()) {
            Integer[] start = queue.poll();
            int node = start[0];
            int count = start[1];

            for(int i = 0; i<list.get(node).size(); i++) {
                int end = list.get(node).get(i);
                if(!visited[end]) {
                    visited[end] = true;
                    if(map[end] == Integer.MAX_VALUE-1) {
                        map[end] = count + 1;
                    } else {
                        map[end] = Math.min(map[node] + 1, map[end]);
                    }
                    Integer[] ends = new Integer[]{end, map[end]};
                    queue.add(ends);
                }

            }
        }

        Arrays.sort(map);

        int max = 0;
        for(int i = 0; i<map.length; i++) {
            if(map[i] < Integer.MAX_VALUE-1 && max < map[i]) {
                max = map[i];
            }
        }

        int count = 0;
        for(int i = 0; i<map.length; i++) {
            if(map[i] == max) {
                count++;
            }
        }
        return count;
    }

    Map<Integer, Integer> map = new HashMap<>();
    public void dfs(List<List<Integer>> list, boolean[] visited, int start, int count) {
        if(!map.containsKey(start)) {
            map.put(start, count);
        } else {
            if(map.get(start) > count) {
                map.put(start, count);
            }
        }

        for(int i = 0; i<list.get(start).size(); i++) {
            int end = list.get(start).get(i);
            if(!visited[end]) {
                visited[end] = true;
                dfs(list, visited, end, count+1);
                visited[end] = false;
            }
        }
    }



    public static void main(String[] args) {
        pg_49189 p = new pg_49189();

        int n = 6;
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        System.out.println(p.solution(n, vertex));
    }
}
