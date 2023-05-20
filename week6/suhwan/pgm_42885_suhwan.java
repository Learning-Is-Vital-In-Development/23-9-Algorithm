package pgm;

import java.util.Arrays;

public class pgm_42885_suhwan {

    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        System.out.println(solution(people, limit));
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int j = 0;
        for (int i = people.length - 1; i >= 0; i--) {
            if (i < j) {
                break;
            }
            if(people[i] + people[j] <= limit){
                j++;
            }
            answer++;
        }
        return answer;
    }

}
