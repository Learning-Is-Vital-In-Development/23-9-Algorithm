import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList();
        for (int i = 0; i < numRows; i++) {
            List<Integer> arr = new ArrayList();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    arr.add(1);
                } else {
                    int prev = result.get(i - 1).get(j - 1);
                    int next = result.get(i - 1).get(j);
                    arr.add(prev + next);
                }
            }
            result.add(arr);
        }
        return result;
    }
}

