package pgm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class pgm_42586_suhwan {

    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {2, 3, 2, 2, 8, 2};
        System.out.println(Arrays.toString(solution(progresses,speeds)));
    }

    public static int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> progressQueue = new LinkedList<>();
        List<Integer> speedList = new ArrayList<>();
        List<Integer> answerList = new ArrayList<>();

        for (int speed : speeds) {
            speedList.add(speed);
        }

        for (int progress : progresses) {
            progressQueue.add(progress);
        }

        while (!progressQueue.isEmpty()) {
            // 프로그레스에 스피드만큼 더함
            for (int i = 0; i < progressQueue.size(); i++) {
                progressQueue.add(speedList.get(i) + progressQueue.poll());
            }
            int feature = 0;
            for (int i = 0; i <= progresses.length; i++) {
                //프로그레스 큐중 100이 넘은 프로그레스가 있을 경우 꺼내고 기능 추가 및 안쓰는 스피드 값 삭제
                if (progressQueue.peek() != null && progressQueue.peek() >= 100) {
                    progressQueue.poll();
                    speedList.remove(0);
                    feature++;
                }
            }
            if (feature > 0) {
                answerList.add(feature);
            }
        }
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

}
