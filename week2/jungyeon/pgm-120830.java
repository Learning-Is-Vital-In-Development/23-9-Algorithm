class Solution {
    public int solution(int n, int k) {
      
         int answer = (int) (12000*n+2000*k - Math.floor(n/10)*2000);
        return answer;
    }
}
