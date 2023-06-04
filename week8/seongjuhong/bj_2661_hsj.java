package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2661 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringBuilder str = new StringBuilder();
        for(int i = 0; i<N; i++) {
            str.append(3);
        }
        min = str.toString();

        good_sequence(N, "");


    }
    static int[] numbers = new int[]{1,2,3};
    public static void good_sequence(int n, String s) {
        if(n == 0) {
            System.out.println(s);
            System.exit(0);
        }
        for(int i = 0; i<numbers.length; i++) {
            if(checked(s + numbers[i])) {
                good_sequence(n-1, s + numbers[i]);
            }


        }

    }

    static String min;

    public static boolean checked(String str) {
        for(int j = 1; j<=str.length()/2; j++) {
            String s1 = str.substring(str.length()-j*2, str.length()-j);
            String s2 = str.substring(str.length()-j);

            if(s1.equals(s2)) {
                return false;
            }
        }
        return true;
    }
}
