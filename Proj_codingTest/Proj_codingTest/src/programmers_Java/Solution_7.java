// ���α׷��ӽ�, ���� ����ǥ
/*
 n���� ����� �� a�� b�� �� ���忡�� �ٰ� �Ǵ��� ���ϴ� ����
 ��Ģ�� ���� �� ���ٰ� ������ ������ �Ӹ��� �����Ͽ�
 �ܼ��� map�� list�� Ȱ���Ͽ� ������ Ǯ����
 
 map�� index�� �ƴ� key�� Ȱ���Ͽ� crud �ϱ� ������
 keyset�� list�� �ű� �� sort�Ͽ� map���� index�� Ȱ���ϴ� ����� Ȱ���Ͽ���
 
 �ٸ� ������� Ǯ�̸� �� �� XOR �� shift�� ���� �����ؾ߰ڴٰ� ������ �����
 */
package programmers_Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution_7 {
	public int solution(int n, int a, int b) {
		Map<Integer, Integer> map = toMap(n, a, b);
		int count = 0;
		do {
			count++;
		}while(!game(map));
		return count;
	}

	public static boolean game(Map<Integer, Integer> map) {
		List<Integer> list = toList(map);
		for (int i = 0; i < list.size(); i += 2) {
			Integer left = map.get(list.get(i));
			Integer right = map.get(list.get(i + 1));
			if (left == 1 && right == 1) {
				return true;
			} else if(left == 1) {
				map.remove(list.get(i+1));
			} else if (right == 1) {
				map.remove(list.get(i));
			} else {
				map.remove(list.get(i));
			}
		}
		return false;
	}

	public static List<Integer> toList(Map<Integer, Integer> map) {
		List<Integer> list = new ArrayList<>();
		Set<Integer> set = map.keySet();
		for (Integer i : set) {
			list.add(i);
		}
		Collections.sort(list);
		return list;
	}

	public static Map<Integer, Integer> toMap(int n, int a, int b) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			if (i == a || i == b) {
				map.put(i, 1);
			} else {
				map.put(i, 0);
			}
		}

		return map;
	}
}