package pgm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class pgm_42577_suhwan {

    public static void main(String[] args) {
        String[] phoneBook = {"123", "456", "789"};
        System.out.println(solution2(phoneBook));

    }

    //정렬 후 반복
    public static boolean solution1(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length-1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return !answer;
            }
        }
        return answer;
    }

    //Hash 사용
    public static boolean solution2(String[] phone_book) {
        boolean answer = true;

        Set<String> numberSet = new HashSet<>(List.of(phone_book));

        for (String number : numberSet) {
            for (int i = 0; i < number.length(); i++) {
                if (numberSet.contains(number.substring(0,i))) {
                    return !answer;
                }
            }
        }
        return answer;
    }

}
