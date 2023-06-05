import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i; j++) {
                int prev = triangle.get(i - 1).get(j - 1);
                int next = triangle.get(i - 1).get(j);
                list.add(prev + next);
            }
            if (i > 0) {
                list.add(1);
            }
            triangle.add(list);
        }
        return triangle.get(rowIndex);
    }
}

