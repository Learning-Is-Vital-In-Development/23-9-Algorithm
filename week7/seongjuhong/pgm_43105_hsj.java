package programmers;

import java.util.Arrays;

public class pg_43105 {
    public int solution(int[][] triangle) {
        int length = triangle.length;

        int[][] arr = new int[length][length];
        for(int i = 0; i<arr.length; i++) {
            Arrays.fill(arr[i], -1);
        }

        for(int i = 0; i<triangle.length; i++) {
            for(int j = 0; j<triangle[i].length; j++) {
                arr[i][j] = triangle[i][j];
            }
        }

        for(int i = 1; i<arr.length; i++) {
            for(int j = 0; j<triangle[i].length; j++) {
                if(arr[i][j] != -1) {
                    if(j <= 0) {
                        arr[i][j] += arr[i-1][j];
                    } else {
                        arr[i][j] += Math.max(arr[i-1][j], arr[i-1][j-1]);
                    }
                }
            }
        }
//        for(int i = 0; i<arr.length; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }
        Arrays.sort(arr[arr.length-1]);
        return arr[arr.length-1][arr.length-1];
    }

    public static void main(String[] args) {
        pg_43105 p = new pg_43105();
        int[][] triangle = new int[][]{{7}, {3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};

        System.out.println(p.solution(triangle));
    }
}
