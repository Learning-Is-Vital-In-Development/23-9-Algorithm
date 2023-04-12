package leetcode.studyplan.level2.day2;

public class LongestCommonPrefix {
    private static final String EMPTY = "";

    public String longestCommonPrefix(String[] words) {
        StringBuilder sb = new StringBuilder(words[0]);

        for (String word: words) {
            if (word.length() < sb.length()) {
                sb.setLength(word.length());
            }
            for (int i = 0; i < sb.length(); i++) {
                if (word.charAt(i) == sb.charAt(i)) {
                    continue;
                }

                if (i == 0) {
                    return EMPTY;
                }

                sb.setLength(i);
                break;
            }
        }

        return sb.toString();
    }
}
