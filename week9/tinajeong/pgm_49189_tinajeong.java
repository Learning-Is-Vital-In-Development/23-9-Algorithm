import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/49189
public class pgm_49189_tinajeong {
	public int solution(int n, int[][] edge) {
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

		for (int[] e : edge) {
			graph.get(e[0]).add(e[1]);
			graph.get(e[1]).add(e[0]);
		}

		int[] dist = new int[n + 1];
		boolean[] visited = new boolean[n + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visited[1] = true;

		int maxDist = 0;
		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (int adj : graph.get(current)) {
				if (!visited[adj]) {
					dist[adj] = dist[current] + 1;
					visited[adj] = true;
					queue.add(adj);
					maxDist = Math.max(maxDist, dist[adj]);
				}
			}
		}

		int answer = 0;
		for (int d : dist) if (d == maxDist) answer++;

		return answer;
	}
}