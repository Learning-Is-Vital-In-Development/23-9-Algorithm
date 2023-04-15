package pgm;

import java.util.HashSet;
import java.util.Set;

public class pgm_1845_suhwan {

    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,2};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        return Math.min(numSet.size(), nums.length / 2);
    }

}
