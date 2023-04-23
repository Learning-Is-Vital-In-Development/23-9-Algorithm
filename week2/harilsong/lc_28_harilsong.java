package harilsong;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lc_28_harilsong {
    public static void main(String[] args) {
        String s1 = "sadbutsad";
        String s2 = "sad";
        int result = strStr(s1, s2);
        System.out.println("result: " + result);
    }

    public static int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            String target = haystack.substring(i, haystack.length());
            if (target.startsWith(needle)) {
                return i;
            }
        }
        return -1;
    }
}
