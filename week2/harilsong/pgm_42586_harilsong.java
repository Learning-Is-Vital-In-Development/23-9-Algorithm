package week2.harilsong;

import java.util.LinkedList;

public class pgm_42586_harilsong {
    public static void main(String[] args) {
        int[] progresses = {90, 90, 90, 90};
        int[] speeds = {30, 1, 1, 1};
        int[] result = solution(progresses, speeds);
        for (int i : result) {
            System.out.println("i: " + i);
        }

    }

    public static int[] solution(int[] progresses, int[] speeds) {
        // 가장 앞에 있는 progress 를 가져온다.
        // 배포하는데 필요한 날짜 수를 구한다.
        // if dayCount > Math.ceil((100 - progress) / speed) 라면 바로 배포가 가능하므로,
        // result 의 마지막 원소에 1을 더한다.
        // else 아니라면 바로 배포가 불가능 하므로
        // dayCount 를 needDay 로 초기화하고(몇 번 더해야하는지는 상관없으므로)
        // result 의 마지막 원소로 1을 추가한다.

        LinkedList<Integer> result = new LinkedList<>();

        LinkedList<Integer> progressQueue = new LinkedList<>();
        for (int progress : progresses) {
            progressQueue.add(progress);
        }
        LinkedList<Integer> speedQueue = new LinkedList<>();
        for (int speed : speeds) {
            speedQueue.add(speed);
        }

        int dayCount = 1;
        while (!progressQueue.isEmpty()) {
            Integer progress = progressQueue.poll();
            Integer speed = speedQueue.poll();

            int needDay = 0;
            if ((100 - progress) % speed == 0) {
                needDay = (100 - progress) / speed;
            } else {
                needDay = (100 - progress) / speed + 1;
            }
            if (dayCount >= needDay && !result.isEmpty()) {
                Integer last = result.removeLast();
                result.add(last + 1);
            } else {
                dayCount = needDay;
                result.add(1);
            }
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
