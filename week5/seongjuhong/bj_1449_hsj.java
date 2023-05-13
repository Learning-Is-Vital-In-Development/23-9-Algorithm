package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int[] arr1 = new int[n];
        for(int i = 0; i<arr.length; i++) {
            arr1[n-i-1] = arr[i];
        }
        int count = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(arr1[0]);

        for(int i = 1; i<arr1.length; i++) {
            int k = q.peek();
            if(k - arr1[i] >= l) {
                q.add(arr1[i]);
            }
        }
        System.out.println(q.size());
    }
}
