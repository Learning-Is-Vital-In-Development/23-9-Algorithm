package pgm;

import java.util.HashSet;

public class pgm_42862_suhwan {

    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        System.out.println(solution(n, lost, reserve));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        HashSet<Integer> resSet = new HashSet<>();
        HashSet<Integer> loSet = new HashSet<>();

        for(int i: reserve) {
            resSet.add(i);
        }

        for(int i: lost) {
            if(resSet.contains(i)) {
                resSet.remove(i);
            }
            else {
                loSet.add(i);
            }
        }

        for(int i: resSet) {
            if(loSet.contains(i-1)) {
                loSet.remove(i - 1);
            }
            else
                loSet.remove(i + 1);
        }

        answer = n - loSet.size();

        return answer;
    }

}
