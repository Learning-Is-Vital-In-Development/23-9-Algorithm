import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

// https://school.programmers.co.kr/learn/courses/30/lessons/43238
public class pgm_43238_tinajeong {
    public long solution(int n, int[] times) {
		long answer = 0;
		long left = 1L, mid = 0L;
		long maxTime = Collections.max(Arrays.stream(times).boxed().collect(Collectors.toList()));
		long right = (long)n * maxTime;

		while (left <= right) {
			mid = (left + right) / 2;
			long people = 0;

			for (int time : times) {
				people += mid / time;

				if (people >= n) {
					break;
				}
			}

			if (people >= n) {
				answer = mid;
				right = mid - 1;
			} else if (people < n) {
				left = mid + 1;
			}
		}
		return answer;
    }
}