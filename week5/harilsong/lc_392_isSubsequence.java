package week5.harilsong;

public class lc_392_isSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int i = 0;
        for (int j = 0; j < t.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                if (++i == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }

}
