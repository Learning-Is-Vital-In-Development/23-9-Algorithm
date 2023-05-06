public class pgm_42839_tinajeong.java {
        // https://school.programmers.co.kr/learn/courses/30/lessons/42839
        HashSet<Integer> numSet = new HashSet<>();

        public int solution(String numbers) {
            int answer = 0;
            int[] numArr = new int[numbers.length()];
            for (int i = 0; i < numbers.length(); i++) {
                numArr[i] = Integer.parseInt(numbers.substring(i, i + 1));
            }
    
            for (int i = 1; i <= numArr.length; i++) {
                permutation(numArr, 0, numArr.length, i);
            }
    
            for (Integer integer : numSet) {
                boolean isPrime = true;
                if (integer < 2) {
                    continue;
                }
                for (int i = 2; i <= integer / 2; i++) {
                    if (integer % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) answer++;
            }
            return answer;
        }
    
        private void permutation(int[] arr, int depth, int n, int r) {
            if (r == depth) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < r; i++) {
                    stringBuilder.append(arr[i]);
                }
                numSet.add(Integer.parseInt(stringBuilder.toString()));
            }
    
            for (int i = depth; i < n; i++) {
                swap(arr, depth, i);
                permutation(arr, depth + 1, n, r);
                swap(arr, depth, i);
            }
        }
    
        private void swap(int[] arr, int depth, int i) {
            int temp = arr[depth];
            arr[depth] = arr[i];
            arr[i] = temp;
        }
}