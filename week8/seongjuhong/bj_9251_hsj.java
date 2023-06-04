package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] chars = new char[str.length()+1];
        for(int i = 1; i<=str.length(); i++) {
            chars[i] = str.charAt(i-1);
        }

        String str1 = br.readLine();
        char[] chars1 = new char[str1.length()+1];
        for(int i = 1; i<=str1.length(); i++) {
            chars1[i] = str1.charAt(i-1);
        }

        int[][] dp = new int[chars.length][chars1.length];

        for(int i = 1; i<chars.length; i++) {
            for(int j = 1; j<chars1.length; j++) {
                if(chars[i] == chars1[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[chars.length-1][chars1.length-1]);
    }
}
