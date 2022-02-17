// 프로그래머스, [3차] 압축
/*
영문 대문자를 넣은 사전을 바탕으로 없는 문자라면 사전에 추가하고 있는 단어는 배열에 넣어 리턴하는 문제
단순 메서드 반복으로 풀 수 있던 문제
*/
package programmers_Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution_5 {
	public int[] solution(String msg) {
		Map<String, Integer> di = dictionary();
		
		List<Integer> list = addDi(msg, di);
		int[] answer = toAns(list);
		return answer;
	}
	
	public static int[] toAns(List<Integer> list) {
		int[] arr = new int[list.size()];
		
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		
		return arr;
	}
	
	public static List<Integer> addDi(String msg, Map<String, Integer> di) {
		List<Integer> list = new ArrayList<>();
		StringBuilder sb =  new StringBuilder(msg);
		
		String tmp = "";
		for (int i = 0; i < sb.length(); i++) {
			tmp += sb.charAt(i);
			if(di.containsKey(tmp)) {
				continue;
			} else {
				di.put(tmp, di.size()+1);
				list.add(di.get(tmp.substring(0, tmp.length()-1)));
				tmp = "";
				sb.delete(0, i);
				i = -1;
			}
		}
		if(sb.length() != 0) {
			list.add(di.get(sb.toString()));
		}
		return list;
	}
	

	// 사전에서 해당 단어 찾기
	public static boolean findWord(String word, Map<String, Integer> di) {
		Set<String> set = di.keySet();
		if (set.contains(word)) {
			return true;
		} else {
			return false;
		}
	}

	// 사전 초기화
	public static Map<String, Integer> dictionary() {
		Map<String, Integer> map = new HashMap<>();

		char first = 'A';

		for (int i = 1; i < 27; i++) {
			map.put("" + first, i);
			first = (char) (first + 1);
		}

		return map;
	}
}
