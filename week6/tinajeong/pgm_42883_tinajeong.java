import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;
// https://school.programmers.co.kr/learn/courses/30/lessons/42883

public class pgm_42883_tinajeong {
    public int solution(int[] people, int limit) {
        Deque<Character> stack = new ArrayDeque<>();

		for (int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);
			while (!stack.isEmpty() && stack.peekLast() < c && k-- > 0) {
				stack.removeLast();
			}
			stack.addLast(c);
		}
		return stack.stream().limit(number.length() - k).map(String::valueOf).collect(Collectors.joining());
    }
}