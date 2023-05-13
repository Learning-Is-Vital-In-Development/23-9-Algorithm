package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ16637 {
    //이 문제는 사드세요....

    //사전에 알아야 할 것 : 배열에 수식을 담는다면 짝수 번째에는 숫자가 들어가고 홀수 번째에는 연산자가 들어간다
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String str = br.readLine();
        //수식 넣을 배열
        String[] formula = str.split("");

        //만약 수식의 길이가 1이면 그냥 숫자 출력 후 종료
        if(formula.length <= 1) {
            System.out.println(formula[0]);
            return;
        }

        boolean[] visited = new boolean[N];

        // ( ) 최대 삽입 개수
        int symbols_cnt = (int) Math.ceil((double) N / 2) - 1;

        //연산자 배열
        int[] num = new int[symbols_cnt];
        int idx = 0;
        for(int i = 0; i<formula.length; i++) {
            if(i %2 == 1) {
                num[idx] = i;
                idx++;
            }
        }
        symbols_cnt = (N + 1) / 4;

        for(int i = 1; i<=symbols_cnt; i++) {
            backTracking(formula, num, visited, 0, new ArrayList<>(), i);
        }

        System.out.println(max);
    }

    static int max = Integer.MIN_VALUE;

    public static void backTracking(String[] formula, int[] num,boolean[] visited, int x, List<Integer> list, int cnt) {
        if(cnt == 0) {
            //임시 배열
            String[] tmp = new String[formula.length];
            for(int i = 0; i<formula.length; i++) {
                tmp[i] = formula[i];
            }

            for(int i = 0; i<list.size(); i++) {
                int first = Integer.parseInt(tmp[list.get(i)-1]);
                int last = Integer.parseInt(tmp[list.get(i)+1]);
                int n;
                if(tmp[list.get(i)].equals("*")) {
                    n = first * last;
                } else if(tmp[list.get(i)].equals("+")) {
                    n = first + last;
                } else {
                    n = first - last;
                }
                tmp[list.get(i) -1] = "";
                tmp[list.get(i)] = String.valueOf(n);
                tmp[list.get(i) +1] = "";

            }

            int count = 0;
            for(int i = 0; i<tmp.length; i++) {
                if(!tmp[i].equals("")) {
                    count++;
                }
            }

            // () 안의 연산이 다 끝난 최종 수식
            String[] final_formula = new String[count];

            count = 0;
            for(int i = 0; i<tmp.length; i++) {
                if(!tmp[i].equals("")) {
                    final_formula[count] = tmp[i];
                    count++;
                }
            }

            int result = Integer.parseInt(final_formula[0]);

            //최종 연산
            for(int i = 1; i<final_formula.length; i+=2) {
                int last = Integer.parseInt(final_formula[i + 1]);
                if(final_formula[i].equals("*")) {
                    result *= last;
                }
                else if(final_formula[i].equals("+")) {
                    result += last;
                } else {
                    result -= last;
                }
            }

            //최댓값과 비교
            if(max < result) {
                max = result;
            }
            return;
        }

        //연산자 배열에서 조합으로 사용할 연산자 선택
        //이때 괄호가 중첩되면 안되므로 연산자 배열 내 앞뒤의 연산자는 사용 못하도록 막아야 함
        for(int i = x; i< num.length; i++) {
            if(!visited[num[i]]) {
                int n = num[i];
                visited[n] = true;
                if(i > 0 && !visited[num[i -1]]) {
                    n = num[i-1];
                    visited[n] = true;
                }
                if(i < num.length-1 &&!visited[num[i + 1]]) {
                    n = num[i+1];
                    visited[n] = true;
                }
                list.add(num[i]);
                backTracking(formula, num, visited, i, list, cnt-1);
                visited[num[i]] = false;
                if(i > 0 && visited[num[i - 1]]) {
                    visited[num[i- 1]] = false;
                }
                if(i < num.length-1 &&visited[num[i + 1]]) {
                    visited[num[i + 1]] = false;
                }
                int size = list.size();
                list.remove(size-1);
            }
        }

    }
}
