class Solution {
    public int[] solution(int[] numbers) {
    	 int[] answer =new int [numbers.length];
        for(int i=0; i<=numbers.length-1; i++){
        	
            answer[i] =  2*(numbers[i]);
        }
        return answer;
    }
}
