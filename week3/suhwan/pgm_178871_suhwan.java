package pgm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class pgm_178871_suhwan {

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        System.out.println(Arrays.toString(solution2(players, callings)));

    }

    //시간초과
    public static String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];

        List<String> playerList = new ArrayList<>(Arrays.asList(players));

        for (String calling : callings) {
            int i = playerList.indexOf(calling);
            playerList.remove(calling);
            playerList.add(i-1, calling);
        }

        for (int i = 0; i <answer.length; i++) {
            answer[i] = playerList.get(i);
        }
        return answer;
    }

    public static String[] solution2(String[] players, String[] callings) {
        Map<String, Integer> playerMap = new HashMap<>();

        int i = 0;
        for (String player : players) {
            playerMap.put(player, i++);
        }

        for (String calling : callings) {
            Integer tmp = playerMap.get(calling);
            playerMap.put(calling, tmp -1);
            playerMap.put(players[tmp-1], tmp);
            players[tmp] = players[tmp-1];
            players[tmp-1] = calling;
        }

        return players;
    }

}
