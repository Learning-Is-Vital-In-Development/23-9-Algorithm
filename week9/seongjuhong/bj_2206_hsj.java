package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2206_2 {
    static int[][] map;
    static int N;
    static int M;
    static Queue<Integer[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i<N; i++) {
            String[] str = br.readLine().split("");
            for(int j = 0; j<str.length; j++) {
                map[i][j] = Integer.parseInt(str[j]);
                if(map[i][j] == 1) {
                    queue.add(new Integer[]{i, j});
                }
            }
        }
        int cnt = bfs();

        System.out.println(cnt);
    }
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};
    public static int bfs() {
        boolean[][][] visited = new boolean[N][M][2];

        visited[0][0][0] = true;
        int visit = 0;
        Queue<Integer[]> que = new LinkedList<>();
        que.add(new Integer[]{0,0,visit,1});

        while (!que.isEmpty()) {

            Integer[] arr = que.poll();

            int x = arr[0];
            int y = arr[1];
            visit = arr[2];
            int cnt = arr[3];


            if(x == N-1 && y == M-1) {
                return cnt;
            }

            for(int i = 0; i<dx.length; i++) {
                int tx = x + dx[i];
                int ty = y + dy[i];
                if(tx >= 0 && tx < N && ty >= 0 && ty < M) {
                    if(visit == 0) {
                        if(map[tx][ty] ==0) {
                            if(!visited[tx][ty][visit]) {
                                visited[tx][ty][visit] = true;
                                visited[tx][ty][1] = true;
                                que.add(new Integer[]{tx,ty,visit,cnt+1});
                            }
                        } else {
                            visited[tx][ty][visit] = true;
                            que.add(new Integer[]{tx, ty, 1, cnt+1});
                        }
                    } else {
                        if(map[tx][ty] == 0) {
                            if(!visited[tx][ty][visit]) {
                                visited[tx][ty][visit] = true;
                                que.add(new Integer[]{tx,ty,visit,cnt+1});
                            }
                        }
                    }
                }
            }

        }
        return -1;
    }
    }