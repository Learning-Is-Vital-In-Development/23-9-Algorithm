package pgm;

import java.util.HashSet;

public class pgm_42839_suhwan {

    public static void main(String[] args) {
        String numbers = "011";
        System.out.println(solution(numbers));
    }

    public static HashSet<Integer> answer;

    public static int solution(String numbers) {
        answer = new HashSet<>();

        recursive(numbers, "");

        return answer.size();
    }

    private static void recursive(String numbers, String number) {
        if (!number.equals("")) {
            isPrime(number);
        }
        for (int i = 0; i < numbers.length(); i++) {
            recursive(numbers.substring(0, i) + numbers.substring(i + 1), number + numbers.charAt(i));
        }
        
    }

    public static void isPrime(String n) {
        int number = Integer.parseInt(n);
        if (number < 2) {
            return;
        }

        for (int i = 2; i <= (int) Math.sqrt(number); i++) {
            if (number % i == 0) {
                return;
            }
        }
        answer.add(number);
    }

}
