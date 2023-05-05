import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class pgm_42746_tinajeong {
    // 가장 큰 수 
    // https://school.programmers.co.kr/learn/courses/30/lessons/42746
    // 람다식으로 Comparator를 선언해 활용해보았다.
    // 효율적인 concat 연산을 위해 StringBuilder사용. 문제 조건에도 정답이 너무 클 수 있다고 명시되어 있었다. 
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        ArrayList<String> numStrList = new ArrayList<>();
        for (int num : numbers) numStrList.add(String.valueOf(num));

        Comparator<String> comparator = 
            (o1, o2) -> Integer.compare(Integer.parseInt(o1+o2), Integer.parseInt(o2+o1));
        Collections.sort(numStrList, comparator.reversed());

        boolean isZero = true;
        for (String numStr : numStrList) {
            if (!numStr.equals("0")) isZero = false;
            answer.append(numStr);
        }

        return isZero ? "0" : answer.toString();
    }
    
}