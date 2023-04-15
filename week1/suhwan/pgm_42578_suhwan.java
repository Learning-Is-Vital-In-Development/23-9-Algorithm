package pgm;

import java.util.HashMap;
import java.util.Map;

public class pgm_42578_suhwan {

    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));

    }

    public static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> clothMap = new HashMap<>();
        for (String[] cloth : clothes) {
            clothMap.put(cloth[1], clothMap.getOrDefault(cloth[1], 1) + 1);
        }

        for (String key : clothMap.keySet()) {
            answer *= clothMap.get(key);
        }
        return answer -1;
    }

}
