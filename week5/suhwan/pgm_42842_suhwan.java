package pgm;

import java.util.Arrays;

public class pgm_42842_suhwan {

    public static void main(String[] args) {
        int brown = 10;
        int yellow = 2;
        System.out.println(Arrays.toString(solution(brown, yellow)));
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int i = yellow; i > 0; i--) {
            int width = i;

            // 약수 검증
            int height = -999;
            if ((yellow % i) == 0) {
                height = yellow / i;
            }

            //width, height -> 노란색 가로, 세로

            if ((width + 2) * (height + 2) == brown + yellow) {
                answer[0] = width + 2;
                answer[1] = height + 2;
                break;
            }
        }
        return answer;
    }

}
