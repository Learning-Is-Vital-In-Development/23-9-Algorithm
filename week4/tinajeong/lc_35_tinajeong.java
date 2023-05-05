public class lc_35_tinajeong {
    // https://leetcode.com/problems/search-insert-position/description/
    // 이분탐색과 반환값을 start로 하면 된다는 아이디어만 있으면 쉽게 풀리는 문제
    
    public int searchInsert(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;

			if (nums[mid] == target) {
				return mid;
			}
			else if (nums[mid] > target)
			{
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}

		return start;
	}
}
