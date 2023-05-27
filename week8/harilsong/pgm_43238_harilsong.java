import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = 0;
        long min = 1;
        long max = (long) n * times[times.length - 1];
        long mid;
        while (min <= max) {
            long sum = 0;
            mid = (min + max) / 2;
            for (int time : times) {
                sum += mid / time;
            }
            if (sum >= n) {
                max = mid - 1;
                answer = mid;
            } else {
                min = mid + 1;
            }
        }
        return answer;
    }
}
