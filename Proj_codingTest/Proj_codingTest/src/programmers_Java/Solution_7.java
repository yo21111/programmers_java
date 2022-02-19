// 프로그래머스, 예상 대진표
/*
 n명의 사람들 중 a와 b가 몇 라운드에서 붙게 되는지 구하는 문제
 규칙이 있을 것 같다고 생각은 했지만 머리가 부족하여
 단순히 map과 list를 활용하여 문제를 풀었음
 
 map은 index가 아닌 key를 활용하여 crud 하기 때문에
 keyset을 list로 옮긴 후 sort하여 map에서 index를 활용하는 방법을 활용하였음
 
 다른 사람들의 풀이를 본 후 XOR 과 shift에 대해 공부해야겠다고 생각이 들었음
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