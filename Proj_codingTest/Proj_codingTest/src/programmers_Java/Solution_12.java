// 프로그래머스, 완전 탐색,  카펫
// 완전 탐색 분류에 있기에 모두 탐색하는 방법 사용함
package programmers_Java;

import java.util.ArrayList;
import java.util.List;

public class Solution_12 {
	public int[] solution(int brown, int yellow) {
		int all = brown + yellow;

		List<Integer> w = new ArrayList<>();
		List<Integer> h = new ArrayList<>();

		for (int i = 3; i <= Math.sqrt(all); i++) {
			if (all % i == 0) {
				h.add(i);
				w.add(all / i);
			}
		}
		int[] answer = new int[2];
		for(int i = 0; i < w.size(); i++) {
			if((h.get(i)-2) * (w.get(i)-2) == yellow) {
				answer = new int[]{w.get(i), h.get(i)};
			}
		}
		return answer;
	}
}