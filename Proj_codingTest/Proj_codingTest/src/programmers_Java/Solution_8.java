// 프로그래머스 해시, 전화번호 목록
/*
한 전화번호가 다른 전화번호의 접두어가 되는지 판별하는 문제
이전에 contains와 sort를 활용해서 풀었다가 풀지 못한적이 있어서
substring으로 모든 전화번호의 일부분을 set에 넣고 중복되는 것이 있다면
접두어가 있는 것으로 판단하는 코드를 작성하였음

하지만 1234123과 1231234를 substring(0, 3) 했을 때 접두어로 판단하고 중복이 제거되는
문제가 발생하여서 해당 케이스만 해결하는 코드를 추가 작성하였음

다른 문제 풀이를 보았을 때 startsWith( ) 함수를 활용하는 이중 for문 코드를 보고 놀랐음
*/
package programmers_Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_8 {
    public boolean solution(String[] phone_book) {
		List<Integer> list = toList(phone_book);
		System.out.println(list);
		for(int i = 0; i < list.size(); i++) {
			boolean chk = check(phone_book, list.get(i));
			if(!chk) return false;
		}
		return true;
	}
	
	public static boolean check(String[] p, int t) {
		Set<String> set = new HashSet<>();
		List<String> list = new ArrayList<>();
		
		int count = 0;
		
		for(int i = 0; i < p.length; i++) {
			if(p[i].length() < t) {
				continue;
			} else {
				if(set.contains(p[i].substring(0,t))) {
					list.add(p[i].substring(0,t));
				}
				set.add(p[i].substring(0, t));
				count++;
			}
		}

		if(set.size() == count) {
			return true;
		} else {
			for(String str : p) {
				for(String s : list) {
					if(s.equals(str)) return false;
				}
			}
			return true;
		}
	}
	
	public static List<Integer> toList(String[] p) {
		Set<Integer> set = new HashSet<>();
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < p.length; i++) {
			set.add(p[i].length());
		}
		
		for(Integer i : set) {
			list.add(i);
		}
		
		Collections.sort(list);
		
		return list;
	}
}
