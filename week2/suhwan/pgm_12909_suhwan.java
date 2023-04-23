package pgm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class pgm_12909_suhwan {

    public static void main(String[] args) {
        String s = "(()(";
        System.out.println(solution(s));
    }

    public static boolean solution(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        char[] brackets = s.toCharArray();
        Stack<Character> bracketStack = new Stack<>();

        for (char bracket : brackets) {
            if (bracket == '(') {
                bracketStack.push(bracket);
            } else {
                if (bracketStack.empty()) {
                    return false;
                }
                bracketStack.pop();
            }
        }
        return bracketStack.empty();
    }

    //시간 초과
    public static boolean solution2(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        List<String> bracketList = new ArrayList<>(Arrays.asList(s.split("")));
        Stack<String> bracketStack = new Stack<>();

        for (String bracket : bracketList) {
            if (bracket.equals("(")) {
                bracketStack.push(bracket);
            } else {
                if (bracketStack.empty()) {
                    return false;
                }
                bracketStack.pop();
            }
        }
        return bracketStack.empty();
    }


}
