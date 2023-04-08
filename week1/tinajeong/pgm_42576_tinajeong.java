import java.util.HashMap;

public class pgm_42576_tinajeong {
    public String solution(String[] participants, String[] completions) {
        HashMap<String,Integer> participantMap = new HashMap<>();
        for(String participant : participants) {
            participantMap.merge(participant, 1, Integer::sum);
        }

        for(String completion: completions) {
            participantMap.merge(completion, -1, Integer::sum);
            participantMap.remove(completion, 0);
        }
        return participantMap.keySet().iterator().next();
    }
}
