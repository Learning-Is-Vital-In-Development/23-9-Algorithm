public class Solution {
	public long solution(int n, int[] times) {
		int minTime = Integer.MAX_VALUE;
		int maxTime = 0;

		for (int time: times) {
			if (time < minTime) {
				minTime = time;
			}

			if (maxTime < time) {
				maxTime = time;
			}
		}

		long low = n * (minTime / times.length);
		long high = (long)n * (long)maxTime;

		long mid = (low + high) / 2;

		while (low < high) {
			long countCustomer = getCountCustomer(mid, times);

			if (countCustomer < n) {
				low = mid + 1;
			} else {
				high = mid;
			}

			mid = (low + high) / 2;
		}

		return mid;
	}

	private long getCountCustomer(
		long mid,
		int[] times
	) {

		long count = 0;
		for (int time: times) {
			count += mid / time;
		}

		return count;
	}
}
