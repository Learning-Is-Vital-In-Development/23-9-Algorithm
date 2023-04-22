package pgm;

import java.util.Arrays;
import java.util.Stack;

public class pgm_12096_suhwan {

    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        System.out.println(Arrays.toString(solution(arr)));
    }

    public static int[] solution(int []arr) {

        Stack<Integer> numberStack = new Stack<>();
        for (int number : arr) {
            if (numberStack.size() == 0 || numberStack.peek() != number) {
                numberStack.push(number);
            }
        }
        int[] answer = new int[numberStack.size()];

        for (int i = numberStack.size() - 1; i >= 0  ; i--) {
            answer[i] = numberStack.pop();
        }
        return answer;
    }

}
