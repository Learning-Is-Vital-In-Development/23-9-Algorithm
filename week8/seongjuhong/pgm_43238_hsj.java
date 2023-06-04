package programmers;

import java.util.Arrays;

public class pg_43238 {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long min = 0; long max = (long)times[times.length-1] * n;
        long ans = 0;
        while(min <= max) {
            long mid = (min + max)/2;
            int tmp = 0;
            for(long time : times) {
                tmp += (mid / time);
            }
            if(tmp >= n) {
                ans = mid;
                max = mid -1;
            } else {
                min = mid + 1;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        pg_43238 p = new pg_43238();
        int n = 6;
        int[] times = {7,10};
        System.out.println(p.solution(n,times));
    }
}
