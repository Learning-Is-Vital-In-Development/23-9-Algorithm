package week6;

import java.util.Arrays;

public class pgm_42885_harilsong {

    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        int solution = solution(people, limit);
        System.out.println("solution: " + solution);
    }

    public static int solution(int[] people, int limit) {
        Arrays.sort(people);
        int min = 0;
        int answer = 0;
        for (int max = people.length - 1; min <= max; max--) {
            if (people[min] + people[max] <= limit) {
                min++;
            }
            answer++;
        }
        return answer;
    }

}
