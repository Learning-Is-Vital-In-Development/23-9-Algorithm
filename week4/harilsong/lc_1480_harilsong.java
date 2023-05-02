package week4.harilsong;

public class lc_1480_harilsong {

    public int[] runningSum(int[] nums) {
        int[] answer = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            answer[i] = sum;
        }
        return answer;
    }

}
