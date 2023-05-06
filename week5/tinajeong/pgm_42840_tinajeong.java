public class pgm_42840_tinajeong.java {
        // https://school.programmers.co.kr/learn/courses/30/lessons/42840
        private static final int[] pattern1 = {1,2,3,4,5};
        private static final int[] pattern2 = {2,1,2,3,2,4,2,5};
        private static final int[] pattern3 = {3,3,1,1,2,2,4,4,5,5};
        private static final int N = 3;
        public int[] solution(int[] answers) {
            int[] scoreArr = new int[N];
            ArrayList<Integer> highScoreList = new ArrayList<>();
            
            for(int i=0; i<answers.length ; i++) {
                int answer = answers[i];
                if(answer==pattern1[i%pattern1.length]) {
                    scoreArr[0]++;
                }
                if(answer==pattern2[i%pattern2.length]) {
                    scoreArr[1]++;
                }
                if(answer==pattern3[i%pattern3.length]) {
                    scoreArr[2]++;
                }
            }
            int max = -1;
            for(int score : scoreArr) {
                if(score > max) max = score;
            }
            
            for(int i=0;i<N;i++) {
                if(scoreArr[i]==max) highScoreList.add(i+1);
            }
            
            Collections.sort(highScoreList);
            return highScoreList.stream().mapToInt(i->i).toArray();
        }
}