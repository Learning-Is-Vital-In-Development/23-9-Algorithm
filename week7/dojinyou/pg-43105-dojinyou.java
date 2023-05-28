public class IntegerTriangle {
	public int solution(int[][] triangle) {
		var maxValue = 0;
		var sumTriangle = new int[triangle.length][];
		sumTriangle[0] = new int[]{ triangle[0][0]};

		for(int i = 1; i < triangle.length; i++) {
			sumTriangle[i] = new int[triangle[i].length];
			for(int j = 0; j < triangle[i].length; j++) {
				var currentValue = triangle[i][j];
				var prevValue1 = 0 <= j-1 ? sumTriangle[i-1][j-1] : 0;
				var prevValue2 = j < sumTriangle[i-1].length ? sumTriangle[i-1][j] : 0;

				sumTriangle[i][j] = Math.max(prevValue1, prevValue2) + currentValue;
				if (sumTriangle[i][j] > maxValue) maxValue = sumTriangle[i][j];
			}
		}

		return maxValue;
	}
}
