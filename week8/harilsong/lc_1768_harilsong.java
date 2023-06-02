class Solution {

    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int len = len1 + len2;
        char[] res = new char[len];
        int i = 0, j = 0, k = 0;
        while (i < len1 && j < len2) {
            res[k++] = word1.charAt(i++);
            res[k++] = word2.charAt(j++);
        }
        while (i < len1) {
            res[k++] = word1.charAt(i++);
        }
        while (j < len2) {
            res[k++] = word2.charAt(j++);
        }
        return new String(res);
    }
}
