import java.util.Arrays;
// https://school.programmers.co.kr/learn/courses/30/lessons/42885

public class pgm_42885_tinajeong {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int left = 0;
        int right = people.length - 1;
        
        Arrays.sort(people);
        
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            
            right--;
            answer++;
        }
        
        return answer;
    }
}