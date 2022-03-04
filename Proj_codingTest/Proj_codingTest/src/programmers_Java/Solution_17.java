//프로그래머스, 탐욕법, 구명보트
/*
 최대 2명이서 limit 몸무게를 넘지 않는 다면 같은 구명보트를 탈 수 있음
 Deque를 사용하여 앞뒤로 같이 탈 수 있는 사람들을 찾았으나
 앞뒤로 i, j를 넣은다음 중앙으로 보내면서 푸는 방법도 있었음
 */
package programmers_Java;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution_17 {
	public int solution(int[] people, int limit) {
		Arrays.sort(people);
		Deque<Integer> que = new ArrayDeque<>();
		for (int i : people) {
			que.add(i);
		}
		int answer = 0;

		while (!que.isEmpty()) {
			if (que.size() == 1) {
				que.pollLast();
				answer++;
			} else {
				int max = limit - que.peekFirst();
				int count = 0;
				for (int i = que.size() - 1; i >= 0; i--) {
					if (que.peekLast() > max) {
						answer++;
						que.pollLast();
					} else {
						break;
					}
				}

				if(que.size() >= 2) {
					que.pollFirst();
					que.pollLast();
					answer++;
				}
			}
		}
		
		return answer;
	}
}