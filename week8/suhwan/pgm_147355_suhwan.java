package pgm;

public class pgm_147355_suhwan {

    public static void main(String[] args) {
        String t = "500220839878";
        String p = "7";
        System.out.println(solution(t, p));
    }

    public static int solution(String t, String p) {
        int answer = 0;
        for (int i = 0; i < t.length()-p.length()+1; i++) {
            long i1 = Long.parseLong(t.substring(i, i + p.length()));
            if (i1 <= Long.parseLong(p)) {
                answer++;
            }
        }
        return answer;
    }
}
