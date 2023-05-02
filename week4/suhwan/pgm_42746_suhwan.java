package pgm;

import java.util.ArrayList;
import java.util.List;

public class pgm_42746_suhwan {

    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};
        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        List<String> list = new ArrayList<>();

        for (int number : numbers) {
            list.add(String.valueOf(number));
        }

        list.sort((o1, o2) -> (o2+o1).compareTo(o1+o2));

        for (String s : list) {
            answer.append(s);
        }

        if (answer.toString().startsWith("0")) {
            return "0";
        }
        
        return answer.toString();
    }

}
