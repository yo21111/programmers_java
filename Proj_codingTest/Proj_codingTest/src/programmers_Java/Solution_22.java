// 프로그래머스, 배달
/*
 1번 마을에서 K시간 안에 배달이 가능한 마을을 찾는 문제
 각 마을을 거쳐서 소요되는 시간을 찾을 수 있도록 BFS 를 사용하였음
 단 node를 별도 생성하지 않고 마을이 int임을 활용해서 list와 배열을 사용하였음
 a마을에서 b마을로 가는 길이 2개인 경우를 생각하지 못하여
 첫번째 테스트에서는 실패하였으나 현재 기록된 시간보다 짧은 경우 새로 시간을
 기록하는 코드를 추가 작성하여 통과하였음
 
 BFS로 처음 푼 문제
 */

package programmers_Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_22 {
	public int solution(int N, int[][] road, int K) {
		// 1번 마을에서 K시간 이하로 배달 동네를 찾아라
		Queue<Integer> que = new LinkedList<>();
		int[] time = new int[N];
		List<Integer> visit = new ArrayList<>();
		que.add(1);

		while (!que.isEmpty()) {
			int cur = que.poll();
			visit.add(cur);

			for (int i = 0; i < road.length; i++) {
				if (road[i][0] == cur) {
					if (visit.indexOf(road[i][1]) == -1 || time[road[i][1] - 1] > time[cur-1] + road[i][2]) {
						que.add(road[i][1]);
						visit.add(road[i][1]);
						time[road[i][1] - 1] = time[cur-1] + road[i][2];
					}
				} else if (road[i][1] == cur) {
					if (visit.indexOf(road[i][0]) == -1 || time[road[i][0] - 1] > time[cur-1] + road[i][2]) {
						que.add(road[i][0]);
						visit.add(road[i][0]);
						time[road[i][0] - 1] = time[cur-1] + road[i][2];
					}
				}
			}
		}
		
		int answer = 0;

		for(int i = 0; i < time.length; i++) {
			if(time[i] <= K) {
				answer++;
			}
		}
		
		return answer;
	}
}