// 프로그래머스, 문자열 압축
/*
 반복되는 문자열은 횟수를 체크하여 비손실 압축을 하는 문제
 실수했던 부분
 1. queue에서 횟수만큼 뽑아내서어 list로 넣는 부분에서
 	contains로 최초 확인하였기에 이어지는 것이 아니라도
 	중복 체크 되었었음 바로 직전 list의 요소와 확인하는 것으로 변경
 2. 반복 횟수를 넣어주는 findLen()에서 for문이 끝나버려 count가 추가적으로
 	붙지 못하는 현상이 있었음 마지막 부분일 때 count가 1이 아니면
 	String에 중첩 덧셈해주는 코드 추가 작성하였음.
 */
package programmers_Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_10 {
	public int solution(String s) {
		int len = s.length();
		int min = len;
		for (int i = 1; i <= len; i++) {
			int chk = check(s, i);
			if (chk < min)
				min = chk;
		}
		return min;
	}

	public static int check(String s, int t) {
		Queue<String> que = toQueue(s);
		List<String> list = new ArrayList<>();

		while (!que.isEmpty()) {
			String tmp = "";
			for (int i = 0; i < t; i++) {
				if (que.isEmpty()) {
					break;
				} else {
					tmp += que.poll();
				}
			}
			list.add(tmp);
		}
		int len = findLen(list);
		return len;
	}

	public static int findLen(List<String> list) {
		int count = 1;
		String tmp = list.get(0);
		
		for (int i = 1; i < list.size(); i++) {
			if(list.get(i-1).equals(list.get(i))) {
				count++;
			} else {
				if(count == 1) {
					tmp += list.get(i);
				} else {
					tmp += count + list.get(i);
					count = 1;
				}
			}
			
			if(i == list.size()-1) {
				if(count != 1) tmp += count;
			}
		}
		return tmp.length();
	}

	public static Queue<String> toQueue(String s) {
		Queue<String> que = new LinkedList<>();

		for (int i = 0; i < s.length(); i++) {
			que.add(s.charAt(i) + "");
		}

		return que;
	}
}