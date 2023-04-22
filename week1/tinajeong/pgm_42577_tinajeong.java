import java.util.Arrays;
import java.util.HashSet;

public class pgm_42577_tinajeong {
    public boolean solution(String[] phoneBook) {
        HashSet<String> phoneNumberSet = new HashSet<>(List.of(phoneBook));

        for (String phoneNumber : phoneNumberSet) {
            for (int i = 1; i <= phoneNumber.length(); i++) {
                String prefix = phoneNumber.substring(0, i);
                if (phoneNumberSet.contains(prefix) && !phoneNumber.equals(prefix)) {
                    return false;
                }
            }
        }
        return true;
    }
}
