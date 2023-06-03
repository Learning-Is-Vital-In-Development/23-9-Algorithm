package pgm;

import java.util.Arrays;

public class pgm_43248_suhwan {

    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};
        System.out.println(solution(n, times));
    }

    public static long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);

        long start = 1;
        long end = (long) times[times.length - 1] * n;

        while (start <= end) {
            long mid = (start + end) / 2;

            long people = 0;
            for (int time : times) {
                people += mid / time;
            }

            if (people < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}
