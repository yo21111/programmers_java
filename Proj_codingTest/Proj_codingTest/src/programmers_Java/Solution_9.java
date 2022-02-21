// 프로그래머스 , 스택/큐,  프린터
/*
 priorities 프린터 작업목록이 있을 때 우선순위가 큰 작업무터 진행될 때
 location 위치의 작업은 언제 일어날지 계산하는 작업
 */
package programmers_Java;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_9 {
	public int solution(int[] priorities, int location) {
		Queue<int[]> que = ready(priorities);
		Queue<Integer> manual = manual(priorities);
		int count = 0;
		
		while (true) {
			int[] arr = que.peek();
			int now = manual.peek();
			
			if(arr[1] == now) {
				if(arr[0] == location) {
					count++;
					break;
				} else {
					que.poll();
					manual.poll();
					count++;
				}
			} else {
				int[] pop = que.poll();
				que.add(pop);
			}
		}
		return count;
	}
	
	public static Queue<int[]> ready(int[] p) {
		Queue<int[]> que = new LinkedList<>();
		for(int i = 0; i < p.length; i++) {
			int[] arr = {i, p[i]};
			que.add(arr);
		}
		
		return que;
	}
	
	public static Queue<Integer> manual(int[] p) {
		Queue<Integer> que = new LinkedList<>();
		List<Integer> list = new LinkedList<>();
		for(int i : p) {
			list.add(i);
		}
		Collections.sort(list, Collections.reverseOrder());
		for(int i = 0; i < list.size(); i++) {
			que.add(list.get(i));
		}
		return que;
	}
}