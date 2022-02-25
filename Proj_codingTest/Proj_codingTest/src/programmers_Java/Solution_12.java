// ���α׷��ӽ�, ���� Ž��,  ī��
// ���� Ž�� �з��� �ֱ⿡ ��� Ž���ϴ� ��� �����
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