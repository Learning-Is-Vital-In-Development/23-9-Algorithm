package programmers;

import java.util.HashSet;
import java.util.Set;

public class pg_42895_2 {
    public int solution(int N, int number) {
        Set<Integer>[] set = new Set[9];
        int tmp = N;
        for(int i = 1; i<9; i++) {
            set[i] = new HashSet<>();

            set[i].add(tmp);
            tmp = tmp * 10 + N;
        }

        for(int i = 2; i<set.length; i++) {
            for(int j = 1; j<=i; j++) {
                for(Integer integer : set[i]) {
                    for(Integer integer1 : set[j]) {
                        if(i + j < set.length) {
                            set[i+j].add(integer + integer1);
                            set[i+j].add(integer-integer1);
                            set[i+j].add(integer1-integer);
                            set[i+j].add(integer * integer1);
                            if(integer1 != 0) {
                                set[i+j].add(integer / integer1);
                            }
                            if(integer != 0) {
                                set[i+j].add(integer1 / integer);
                            }
                        }
                    }
                }
            }
        }

        for(int i = 1; i<set.length; i++) {
            for(Integer integer : set[i]) {
                if(integer == number) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        pg_42895_2 p = new pg_42895_2();
//        System.out.println(p.solution(5,12));
        System.out.println(p.solution(2,11));
    }
}
