package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15661 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] pairs = new int[N][N];
        StringTokenizer st;
        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++) {
                pairs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] visited = new boolean[N];

        //팀원의 수는 2명에서 N-2 사이

        //팀원의 수를 2 ~ N/2 까지 해서 먼저 인원이 작은 팀원의 시너지를 구한 후

        //큰 팀의 시너지를 구한다

        int[] arr = new int[N];
        for(int i = 0; i<N; i++) {
            arr[i] = i;
        }
        int[] num;

        for(int i = 2; i<=N/2; i++) {
            num = new int[i];
            backTracking(pairs, arr,visited, 0, i, num, 0);
        }
        System.out.println(result);
    }

    static int result = Integer.MAX_VALUE;
    public static void backTracking(int[][] pairs,int[] arr, boolean[] visited, int x, int cnt, int[] num, int t) {
        if(cnt == 0) {
            int k = 0;
            int[] num2 = new int[arr.length - num.length];
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i]) {
                    num2[k] = i;
                    k += 1;
                }
            }
            int sum1 = 0;
            for (int i = 0; i < num.length; i++) {
                for (int j = 0; j < num.length; j++) {
                    if (i != j) {
                        int a = num[i];
                        int b = num[j];
                        sum1 += pairs[a][b];
                    }
                }
            }
            int sum2 = 0;
            for (int i = 0; i < num2.length; i++) {
                for (int j = 0; j < num2.length; j++) {
                    if (i != j) {
                        int a = num2[i];
                        int b = num2[j];
                        sum2 += pairs[a][b];
                    }
                }
            }

            int min = Math.abs(sum1 - sum2);
            if (result > min) {
                result = min;
            }
            return;
        }

        for(int i = x; i<arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                num[t] = arr[i];
                backTracking(pairs, arr, visited, i, cnt - 1, num, t+1);
                visited[i] = false;
            }
        }
    }
}
