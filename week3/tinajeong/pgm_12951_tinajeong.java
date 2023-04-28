public class pgm_12951_tinajeong {
    public String solution(String s) {
        StringBuilder result = new StringBuilder();
        if (s.trim().length() == 0) return s;
        String lowerString = s.toLowerCase();
        for (int i = 0; i < lowerString.length(); i++) {
            String currentString = lowerString.substring(i, i + 1);

            if (Character.isAlphabetic(lowerString.charAt(i))) {
                if (i == 0 || lowerString.charAt(i - 1) == ' ') {
                    result.append(currentString.toUpperCase());
                }
                else {
                    result.append(currentString);
                }
            } else {
                result.append(currentString);
            }
        }
        return result.toString();
    }
}