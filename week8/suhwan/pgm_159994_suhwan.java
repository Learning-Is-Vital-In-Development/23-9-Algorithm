package pgm;

public class pgm_159994_suhwan {

    public static void main(String[] args) {
        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        System.out.println(solution(cards1, cards2, goal));
    }

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        int i1=0, i2=0;

        for (String target : goal) {
            if (i1 < cards1.length && cards1[i1].equals(target)) {
                i1++;
            } else if (i2 < cards2.length && cards2[i2].equals(target)) {
                i2++;
            } else
                return "No";
        }
        return "Yes";
    }

}
