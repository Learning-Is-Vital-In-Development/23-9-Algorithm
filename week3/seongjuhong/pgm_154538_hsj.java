package programmers;

import java.util.Arrays;

public class pg_154538 {
    public int solution(int x, int y, int n) {

        int[] dp = new int[1_000_001];
        Arrays.fill(dp, -1);
        dp[x] = 0;

        for(int i = x; i<=y; i++) {
            if(dp[i] != -1) {
                if(i+n <= y) {
                    if(dp[i + n] == -1) {
                        dp[i + n] = dp[i] + 1;
                    } else if(dp[i + n] != -1){
                        dp[i + n] = Math.min(dp[i] + 1, dp[i + n]);
                    }
                }
                if(i*2 <= y) {
                    if(dp[i * 2] == -1) {
                        dp[i * 2] = dp[i] + 1;
                    } else if(dp[i*2] != -1) {
                        dp[i*2] = Math.min(dp[i] + 1, dp[i*2]);
                    }
                }
                if(i*3 <= y) {
                    if(dp[i*3] == -1) {
                        dp[i * 3] = dp[i] + 1;
                    } else if(dp[i*3] != -1) {
                        dp[i*3] = Math.min(dp[i] + 1, dp[i*3]);
                    }
                }
            }
        }

        return dp[y];
//        dfs(x, y, n, 0);
//        if(min == Integer.MAX_VALUE) {
//            return  -1;
//        } else {
//            return min;
//        }
    }

    int min = Integer.MAX_VALUE;
    public void dfs(int x, int y, int n, int count) { //시간초과
        if(x == y) {
            if(min > count) {
                min = count;
            }
            return;
        }
        if(x > y) {
            return;
        }
        dfs(x + n, y, n, count+1);
        dfs(x * 2, y, n, count+1);
        dfs(x * 3, y, n, count+1);
    }

    public static void main(String[] args) {
        pg_154538 p = new pg_154538();

        System.out.println(p.solution(10,40,30));
    }
}
