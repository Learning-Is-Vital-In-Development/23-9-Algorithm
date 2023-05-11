public class pgm_42842_tinajeong.java {
        // https://school.programmers.co.kr/learn/courses/30/lessons/42842
        public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int width = 1;
        int height = 1;

        for (int i = yellow; i >= (yellow / i); i--) {
            if (yellow % i != 0) continue;
            if ((2 * i) + (2 * (yellow / i)) + 4 == brown) {
                width = i + 2;
                height = yellow / i + 2;
                break;
            }
        }

        answer[0] = width;
        answer[1] = height;
        return answer;
    }
}