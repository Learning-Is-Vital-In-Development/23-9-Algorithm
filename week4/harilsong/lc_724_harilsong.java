package week4.harilsong;

public class lc_724_harilsong {
    static class Solution {
        public int pivotIndex(int[] nums) {
            int target = 0;
            while (target < nums.length) {
                int left = 0;
                int right = 0;
                for (int i = 0; i < target; i++) {
                    left += nums[i];
                }

                for (int j = target + 1; j < nums.length; j++) {
                    right += nums[j];
                }

                if (left == right) {
                    return target;
                }
                target++;
            }
            return -1;
        }
    }

    static class Solution2 {
        public int pivotIndex(int[] nums) {
            // Initialize total sum of the given array...
            int totalSum = 0;
            // Initialize 'leftsum' as sum of first i numbers, not including nums[i]...
            int leftsum = 0;
            // Traverse the elements and add them to store the totalSum...
            for (int ele : nums) {
                totalSum += ele;
            }
            // Again traverse all the elements through the for loop and store the sum of i numbers from left to right...
            for (int i = 0; i < nums.length; leftsum += nums[i++]) {
                // sum to the left == leftsum.
                // sum to the right === totalSum - leftsum - nums[i]..
                // check if leftsum == totalSum - leftsum - nums[i]...
                if (leftsum * 2 == totalSum - nums[i]) {
                    return i;       // Return the pivot index...
                }
            }
            return -1;      // If there is no index that satisfies the conditions in the problem statement...
        }
    }
}
