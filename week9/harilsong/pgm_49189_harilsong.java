package harilsong;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class pgm_49189_harilsong {

    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        int[] dist = new int[n + 1];

        int maxDist = 0;
        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            for (Integer adj : graph.get(current)) {
                // 방문한 적이 없다면
                if (!visited[adj]) {
                    dist[adj] = dist[current] + 1;
                    visited[adj] = true;
                    queue.offer(adj);
                    maxDist = Math.max(maxDist, dist[adj]);
                }
            }
        }

        int answer = 0;
        for (int d : dist) {
            if (d == maxDist) {
                answer++;
            }
        }

        return answer;
    }

}
