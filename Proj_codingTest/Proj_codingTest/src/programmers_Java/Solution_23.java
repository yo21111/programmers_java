// 프로그래머스, n^2 배열 자르기
/*
 	2차원 배열을 활용하여 left 부터 rigth까지의 수를 배열로 리턴하는 문제
 	2차원 배열을 직접 만들어 하나하나 계산하면 반드시 시간초과가 일어남
 	이에 따라 / 와 % 를 활용하여 해당 부분 위치만 계산하고
 	col과 row 중 큰 값에 +1 한값이 해당 위치의 값임을 활용한 문제
 */

package programmers_Java;

import java.util.ArrayList;
import java.util.List;

public class Solution_23 {
	public long[] solution(int n, long left, long right) {
		// col : left / n -> 0,  row : left % n -> 2
		// col : right / n -> 1,  row : right % n -> 2
		
		List<Long> arr = new ArrayList<>();
		
		
		for(long i = left; i <= right; i++) {
			long col = i / n;
			long row = i % n;
			
			long target = Math.max(col, row) + 1;
			arr.add(target);
		}
		
		long[] answer = new long[arr.size()];
		
		for(int i = 0; i < answer.length; i++) {
			answer[i] = arr.get(i);
		}
		
		return answer;
	}
}