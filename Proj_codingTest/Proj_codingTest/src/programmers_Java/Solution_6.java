//프로그래머스, [3차] 방금 그곡
/*
 -실수했던 부분
 String m에 따라 악보에 해당 음이 있는지 확인하는 문제
 C#과 같이 #이 붙어서 두글자가 되는 경우에 막혀서 진행이 안되었는데
 C# 을 한글자로 대체 치환 하고난 후 문제풀이 완료함
 
 한글자로 치환 이후 전체적으로 #을 고려하여 작성한 코드들을 수정하여야 했는데
 하나 두개 놓치는 부분이 있었기 때문에 시간이 약간 소요되었음
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
	
    //#이 붙은 계이름을 한글자로 치환
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
	
	// 문제에서 주어진 조건에 맞게 정렬 및 값 반환
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
	
	// keySet에서 해당 노래음을 가지고 있는지 확인
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
	
	// 문제를 HashMap으로 풀었기 때문에 최초 준비 작업
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
	
	
	// 노래는 반복되므로 결과적으로 재생된 노래의 악보를 반환
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
	
	// 노래 시작시간과 끝시간을 기준으로 노래된 시간 계산
	public static int time(String s, String e) {
		String[] sArr = s.split(":");
		String[] eArr = e.split(":");
		
		int hour = (Integer.parseInt(eArr[0])-Integer.parseInt(sArr[0]))*60;
		int minute = (Integer.parseInt(eArr[1])-Integer.parseInt(sArr[1]));
		
		int time = hour + minute;
		return time;
	}
}