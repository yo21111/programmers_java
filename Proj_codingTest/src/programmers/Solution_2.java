// ���α׷��ӽ�, �ؽ�, ����

/*
 ��� 1���� ���� ����ä�� �ٸ� ����� ���� �Դ� ����� ���� ���ϴ� ����
 �ϴ� 2���� String �迭���� 1�� �ε����� �ش� ���� ������ �����ֱ� ������
 Map�� ����ؼ� �� ���� ���� ������ �����־���
 */

package programmers;

import java.util.HashMap;
import java.util.Map;

public class Solution_2 {
    public int solution(String[][] clothes) {
		int[] arr = toMap(clothes);
		int answer = 1;
		for (int i : arr) {
			answer *= i;
		}
		
		return answer-1;
	}
	public static int[] toMap(String[][] c) {
		Map<String, Integer> map = new HashMap<>();
		
		for (int  i = 0; i < c.length; i++) {
			if(map.containsKey(c[i][1])) {
				map.put(c[i][1], map.get(c[i][1])+1);
			} else {
				map.put(c[i][1], 1);
			}
		}
		
		int[] arr = new int[map.size()];
		int idx = 0;
		for(int i : map.values()) {
			arr[idx] = i+1;
			idx++;
		}
		
		return arr;
	}
}