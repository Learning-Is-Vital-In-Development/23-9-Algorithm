package programmers;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Stack;

public class pg_17683 {
    /*
    musicinfo의 악보에 m 이 포함되어야 한다.
    이때 m의 중복은 없어야 함

    그러나 중복을 없에는 방법이 생각이 안나므로..musicInfo의 길이를 증가시킨다


    * */

    public String solution(String m, String[] musicinfos) {

        m = replaceStr(m);

        String title = "(None)";
        int max = Integer.MIN_VALUE;
        for(int i = 0; i< musicinfos.length; i++) {
            String[] musicInfo = musicinfos[i].split(",");
            String sheet = musicInfo[3];
            sheet = replaceStr(sheet);

            String startTime = musicInfo[0];
            String endTime = musicInfo[1];

            LocalTime start = LocalTime.parse(startTime);
            LocalTime end = LocalTime.parse(endTime);

            int period = (int) ChronoUnit.MINUTES.between(start, end);


            int sheetLength = sheet.length();

            if(period/sheetLength < 1) {
                sheet = sheet.substring(0, period + 1);
                System.out.println(sheet);
            }

            else {
                int length = (period/sheetLength) + 1;
                String tmp = sheet;
                for (int j = 0; j<length; j++) {
                    sheet += tmp;
                }
            }
            boolean result = false;
            for(int j = 0; j<sheet.length() - m.length(); j++) {
                if(sheet.charAt(j) == m.charAt(0)) {
                    for(int k = 0; k<m.length(); k++) {
                        if(sheet.charAt(j + k) == m.charAt(k)) {
                            result = true;
                        } else {
                            result = false;
                            break;
                        }
                    }
                }
                if(result) {
                    break;
                }
            }
            if(result) {
                if(max < period) {
                    max = period;
                    title = musicInfo[2];
                }
            }
        }


        return title;
    }

    public String replaceStr(String sheet) {
        Stack<Character> stack = new Stack<>();
        for (char c : sheet.toCharArray()) {
            stack.add(c);
        }

        String str= "";
        while (!stack.isEmpty()) {
            char c = stack.pop();
            if(c == '#') {
                String s = stack.pop().toString().toLowerCase();
                str =  s + str;
            }
            else {
                str = c + str;
            }
        }

        return str;
    }

    public static void main(String[] args) {
        pg_17683 p = new pg_17683();
        String m = "ABCDEFG";
        String[] musicinfos = new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        String m1 = "CC#BCC#BCC#BCC#B";
        String[] musicinfos1 = new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};

        String m2 = "ABC";
        String[] musicinfos2 = new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        System.out.println(p.solution(m1, musicinfos1));
    }
}
