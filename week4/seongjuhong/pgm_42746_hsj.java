package programmers;

import java.util.Arrays;

public class pgm_42746 {
    public String solution(int[] numbers) {

        int count = numbers.length;
        for (int number : numbers) {
            if(number == 0) count--;
        }
        if(count == 0) return "0";

        numbers = Arrays.stream(numbers)
                .boxed()
                .sorted((o1, o2) ->{
                    String s1 = o1.toString() + o2.toString();
                    String s2 = o2.toString() + o1.toString();

                    int num1 = Integer.parseInt(s1);
                    int num2 = Integer.parseInt(s2);

                    return num2 - num1;
                })
                .mapToInt(i -> i)
                .toArray();

        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(number);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        pgm_42746 p = new pgm_42746();
        int[] numbers = {123,1222};
        System.out.println(p.solution(numbers));
    }
}
