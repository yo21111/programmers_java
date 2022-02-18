// 프로그래머스, [3차] 방금 그곡
/*
 기존 비교하는 단어와 다른 단어(ex. C#)이 있을 때엔 기존에 단어와
 비슷한 포맷으로 변환한 이후 작업을 진행하면 편하다
 */
package programmers_Java;

import java.util.*;

public class Solution_6 {
    public String solution(String m, String[] musicinfos) {
        m = conversion(m);
        Map<String, String> map = toMap(musicinfos);
        List<String> list = find(map, m);
        String ans = filter(list);

        if(ans.equals("(None)")) {
            return "(None)";
        } else {
            return map.get(ans);
        }

    }

    public static String conversion(String t) {
        String[] arr = {"C#", "D#", "F#", "G#", "A#"};
        for (int i = 0; i < arr.length; i++) {
            if(t.contains(arr[i])) {
                String newStr = "" + (char)(arr[i].charAt(0) + 8);
                t=t.replace(arr[i], newStr);
            }
        }
        return t;
    }

    public static String filter(List<String> list) {
        String ans = "";

        if (list.size() == 0) {
            ans = "(None)";
        } else if(list.size() == 1) {
            ans = list.get(0);
        } else {
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (o1.length() > o2.length()) {
                        return -1;
                    } else if (o1.length() < o2.length()) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            });

            ans = list.get(0);
        }

        return ans;
    }

    public static List<String> find(Map<String, String> map, String m) {
        Set<String> set = map.keySet();
        List<String> list = new ArrayList<>();

        Iterator<String> ir = set.iterator();
        while(ir.hasNext()) {
            String str = ir.next();
            if(str.contains(m)) list.add(str);
        }
        return list;
    }

    public static Map<String, String> toMap(String[] m) {
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < m.length; i++) {
            String[] arr = m[i].split(",");
            String title = conversion(arr[2]);
            int time = time(arr[0], arr[1]);
            String newM = song(time, conversion(arr[3]));
            map.put(newM, title);
        }

        return map;
    }

    public static String song(int time, String a) {
        int aLen = a.length();
        int repeatCnt = time / aLen;
        int leftCnt = time % aLen;

        String realA = "";
        for(int i = 0; i < repeatCnt; i++) {
            realA += a;
        }
        for (int j = 0; j < leftCnt; j++) {
            realA += a.charAt(j);
        }

        return realA;
    }

    public static int time(String s, String e) {
        String[] sArr = s.split(":");
        String[] eArr = e.split(":");

        int hour = (Integer.parseInt(eArr[0])-Integer.parseInt(sArr[0]))*60;
        int minute = (Integer.parseInt(eArr[1])-Integer.parseInt(sArr[1]));

        int time = hour + minute;
        return time;
    }
}