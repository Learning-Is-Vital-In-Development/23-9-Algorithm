package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10942_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i<N+1; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][N+1];
        for(int i = 1; i<N+1; i++) {
            dp[i][i] = 1;
        }
        for(int i = 1; i<N; i++) {
            if(numbers[i] == numbers[i+1]) {
                dp[i][i+1] = 1;
            }
        }
        //홀수
        for(int i = 2; i<N; i++) {
            int s = i; int e = i;
            while (s>0 && e<N) {
                if(numbers[s-1] == numbers[e+1]) {
                    dp[s-1][e+1] = 1;
                    s-=1; e+=1;
                } else {
                    break;
                }
            }
        }

        //짝수
        for(int i = 2; i<N; i++) {
            if(dp[i][i+1] == 1) {
                int s = i; int e = i+1;
                while (s > 0 && e < N) {
                    if(dp[s][e] == 1 && numbers[s-1] == numbers[e+1]) {
                        dp[s-1][e+1] = 1;
                        s-=1; e+=1;
                    } else {
                        break;
                    }
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(dp[s][e]).append("\n");
        }
        System.out.println(sb);
    }
}
