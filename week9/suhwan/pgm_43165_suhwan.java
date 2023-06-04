package pgm;

public class pgm_43165_suhwan {

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }

    public static int answer = 0;

    public static int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return answer;
    }

    private static void dfs(int[] numbers, int depth, int target, int targetNumber) {
        if (numbers.length == depth) {
            if (target == targetNumber) {
                answer++;
            }
            return;
        }
        dfs(numbers, depth + 1, target, targetNumber + numbers[depth]);
        dfs(numbers, depth + 1, target, targetNumber - numbers[depth]);
    }

}
