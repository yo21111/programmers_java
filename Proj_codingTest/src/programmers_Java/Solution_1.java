// 프로그래머스, 스택/큐, 다리를 지나는 트럭
/*
 무게제한이 있는 다리를 차들이 순서대로 모두 건더는 시간을 계산하는 문제
 무게제한 이하의 무게가 될 때에는 차량을 que에 올리고 넘을 때에는 
 차량이 통과하여 무게가 허용될때까지 0을 넣는 방법을 최초에 생각하였으나
 0을 언제 몇번 넣어야할지 고민이 되어 풀지 못했었던 문제
 
 시간을 계산하는 대신에 순환문을 한번 반복할 때 push와 poll이 각각 한번
 실행되도록 하게하여 시계의 움직임과 같은 느낌을 내려고 코드를 작성하였음
 
 order++ 임에도 truck_weights[order]와 같이 작성하여 
 ArrayIndexOutOfBounds 예외가 발생하였었음 if문으로 조건 만들어 주어서 처리함
 
 que 사용시 이전에는 해당 길이가 되면 poll 하는 형식을 사용하였었는데
 순환문 한번에 push와 pop 각각 한번 실행되도록 하는 것이 전체적인 맥락을
 이끌어가는 데 많은 도움이 됨을 느꼈음.
 */ 

package programmers_Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Integer> que = new LinkedList<>();
		for (int i = 0; i < bridge_length; i++) {
			que.add(0);
		}
		
		List<Integer> list = new ArrayList<>();
		int order = 0;
		int truck = 0;
		
		while (!que.isEmpty()) {
			if (order < truck_weights.length) {
				truck = truck_weights[order];
			}
			
			int bye = que.poll();
			weight += bye;
			list.add(bye);
			
			if (order < truck_weights.length && weight >= truck) {
				weight -= truck;
				que.add(truck);
				order++;
			} else if (order < truck_weights.length && weight < truck) {
				que.add(0);
			}
			
		}
		
		return list.size();
	}
}