class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        double number = 0;
        for(int i=0; i<numbers.length; i++){
            number = number + numbers[i];
            
        }
        answer = number/numbers.length;
        return answer;
    }
}
