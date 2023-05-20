package pgm;

public class pgm_42860_suhwan {

    public static void main(String[] args) {
        String name = "JEROEN";
        System.out.println(solution(name));
    }

    public static int solution(String name) {
        int answer = 0;
        int cursor = name.length()-1;

        for(int i = 0; i <name.length(); i++) {
            int front = name.charAt(i)-'A';
            int back = 'Z'-name.charAt(i)+1;
            int min = Math.min(front,back);

            answer+=min;

            int next = i+1;
            int count_a=0;

            while(next < name.length() && name.charAt(next) == 'A') {
                count_a+=1;
                next++;
            }

            int moveWithoutA = name.length() - count_a - 1;
            int min2 = Math.min(i, name.length() - next);
            cursor = Math.min(cursor, moveWithoutA + min2);
        }

        return answer+cursor;
    }

}
