package programmers;

import java.util.Arrays;

public class pgm_42842_hsj {
    public int[] solution(int brown, int yellow) {
        int width = 0;
        int height = 0;

        int area = brown + yellow;

        int max_height = (int)Math.sqrt(area);

        //(가로 + 세로) * 2 - 4 = brown

        for(int i = 3; i<=max_height; i++) {
            width = area / i;
            if(area % width == 0) {
                int tmp_height = area / width;
                if(((tmp_height + width) * 2) - 4 == brown) {
                    break;
                }
            }
        }

        height = area / width;

        return new int[]{width, height};
    }

    public static void main(String[] args) {
        pgm_42842_hsj p = new pgm_42842_hsj();
        System.out.println(Arrays.toString(p.solution(24, 24)));
    }
}
