package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        int left = 0; int right = arr.length-1;
        int start = 0; int end = 0;
        while (left< right) {
            if(arr[left] + arr[right] >= 0) {
                if(min > Math.abs(arr[left] + arr[right])) {
                    min = Math.abs(arr[left] + arr[right]);
                    start = arr[left]; end = arr[right];
                }
                right--;
            } else {
                if(min > Math.abs(arr[left] + arr[right])) {
                    min = Math.abs(arr[left] + arr[right]);
                    start = arr[left]; end = arr[right];
                }
                left++;
            }
        }

        System.out.println(start + " " + end);
    }
}
