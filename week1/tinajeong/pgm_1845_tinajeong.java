import java.util.Arrays;

class pgm_1845_tinajeong {
    public int solution(int[] nums) {
        return (int) Math.min(Arrays.stream(nums).distinct().count(), nums.length / 2);
    }
}