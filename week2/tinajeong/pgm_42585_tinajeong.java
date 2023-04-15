import java.util.ArrayList;

public class pgm_42585_tinajeong {
	public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] duration = new int[speeds.length];
        for (int i = 0; i < duration.length; i++) {
            int remain = 100 - progresses[i];
            duration[i] = (remain % speeds[i] == 0) ? remain / speeds[i] : remain / speeds[i] + 1;
        }

        int maxDuration = duration[0];
        int count = 1;
        for (int i = 1; i < duration.length; i++) {
            if (duration[i] <= maxDuration) {
                count++;
            } else {
                answer.add(count);
                count = 1;
                maxDuration = duration[i];
            }
        }
        answer.add(count);

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
