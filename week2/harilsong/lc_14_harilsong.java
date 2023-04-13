package harilsong;

import java.util.Arrays;
import java.util.Comparator;

public class lc_14_harilsong {
    public static void main(String[] args) {
        String[] strs = {"a"};
        String result = longestCommonPrefix(strs);
        System.out.println("result: " + result);
    }

    public static String longestCommonPrefix(String[] strs) {
        String minWord = Arrays.stream(strs)
                .min(Comparator.comparing(String::length))
                .orElseThrow();
        String answer = "";
        for (int i = 0; i < minWord.length(); i++) {
            String prefix = minWord.substring(0, i + 1);
            for (String str : strs) {
                if (!str.startsWith(prefix)) {
                    return answer;
                }
            }
            answer = prefix;
        }

        return answer;
    }

    public static String solution2(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length - 1];
        int idx = 0;
        while (idx < s1.length() && idx < s2.length()) {
            if (s1.charAt(idx) == s2.charAt(idx)) {
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);
    }
}
