// 프로그래머스, 해시, 위장

/*
 적어도 1개의 옷을 입은채로 다른 경우의 옷을 입는 경우의 수를 구하는 문제
 일단 2차원 String 배열에서 1번 인덱스에 해당 옷의 부위가 적혀있기 때문에
 Map을 사용해서 각 부위 옷의 갯수를 구해주었음
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