package pgm;

public class pgm_87946_suhwna {

    public static void main(String[] args) {
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        int k = 80;
        System.out.println(solution(k,dungeons));
    }
    
    public static boolean[] visited;
    public static int answer = -1;

    public static int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return answer;
    }

    private static void dfs(int k, int[][] dungeons, int count) {
        answer = Math.max(answer, count);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, count + 1);
                visited[i] = false;
            }
        }
    }

}
