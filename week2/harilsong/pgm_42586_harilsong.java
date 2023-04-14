package week2.harilsong;

import java.util.LinkedList;

public class pgm_42586_harilsong {
    public static void main(String[] args) {
        int[] progresses = {20};
        int[] speeds = {90};
        int[] result = solution(progresses, speeds);
        for (int i : result) {
            System.out.println("i: " + i);
        }

    }

    public static int[] solution(int[] progresses, int[] speeds) {
        // progresses, speeds 를 queue 로 만든다.
        // 가장 앞에 있는 progress 를 가져온다.
        // 최초 실행(if dayCount = 1)
        // 100 미만이라면 가장 앞에 있는 speed 를 한 번 더하고 dayCount 를 1 증가시킨다. 100 이 될 때까지 반복한다.
        // 100 이 되었으면 progresses.pop, speeds.pop 을 호출하고 release 를 1 증가시킨다.

        // 다시 가장 앞에 있는 progress 를 가져온다.
        // progress + (dayCount * 가장 앞에 있는 speeds) 를 했을 때 100 을 넘는지 확인한다.
        // 100 미만이라면, result.add(release) 를 호출하고 release 를 0 으로 만든다.
        // 가장 앞에 있는 speed 를 한 번 더하고 dayCount 를 1 증가시킨다. 100 이 될 때까지 반복한다.
        // 100 을 넘는다면 progress.pop, speeds.pop 을 호출하고 release 를 1 증가시킨다.

        // queue 가 비어있을 때까지 반복한다.

        // ---
        // 가장 앞에 있는 progress 를 가져온다.
        // 배포하는데 필요한 날짜 수를 구한다.
        // if dayCount > Math.ceil((100 - progress) / speed) 라면 바로 배포가 가능하므로,
        // result 의 마지막 원소에 1을 더한다.
        // else 아니라면 바로 배포가 불가능 하므로
        // dayCount 를 needDay 로 초기화하고(몇 번 더해야하는지는 상관없으므로)
        // result 의 마지막 원소로 1을 추가한다.

        int dayCount = 1;
        LinkedList<Integer> result = new LinkedList<>();

        LinkedList<Integer> progressQueue = new LinkedList<>();
        for (int progress : progresses) {
            progressQueue.add(progress);
        }
        LinkedList<Integer> speedQueue = new LinkedList<>();
        for (int speed : speeds) {
            speedQueue.add(speed);
        }

        while (!progressQueue.isEmpty()) {
            Integer progress = progressQueue.pop();
            Integer speed = speedQueue.pop();

            int needDay = (100 - progress) / speed;
            // progress 가 100 보다 작은데 progress + speed 가 100 을 초과한다면 needDay 는 0 이 아니라 1 이여야 한다.
            if (progress < 100 && progress + speed > 100) {
                needDay = 1;
            }
            if (dayCount > needDay) {
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
