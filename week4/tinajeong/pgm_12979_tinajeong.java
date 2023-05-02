public class pgm_12979_tinajeong {
    // 기지국 설치
    // https://school.programmers.co.kr/learn/courses/30/lessons/12979
    // w를 활용해 인덱스를 얼마나 이동할 것인지 고민하면 풀린다
    public int solution(int n, int[] stations, int w) {
		int toBeExpandedCount = 0;
		int i = 1;
		int stationIndex = 0;

		while (i <= n) {
			if (stationIndex < stations.length && i >= stations[stationIndex] - w) {
				i = stations[stationIndex] + w + 1;
				stationIndex++;
			} else {
				i += w * 2 + 1;
				toBeExpandedCount++;
			}
		}

		return toBeExpandedCount;
    }
}
