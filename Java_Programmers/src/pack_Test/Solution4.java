//프로그래머스, 정렬, H-Index
/*
 문제를 해석하는 것이 가장 어려웠던 문제
 문제를 정확히 이해했으면 풀이가 그리 어렵지는 않았음
 */
package pack_Test;

public class Solution4 {
	public int solution(int[] citations) {
		int hIdx = 0;
		int max = findMax(citations);
		for(int i = 0; i <= max; i++) {
			if(hIndex(citations, i)) {
				if (i >= hIdx) {
					hIdx = i;
				}
			}
		}
		return hIdx;
	}
	
	public static int findMax(int[] c) {
		int max = 0;
		for(int i : c) {
			if (i > max) max = i;
		}
		return max;
	}
	public static boolean hIndex(int[] c, int target) {
		int point = 0;
		for(int i = 0; i < c.length; i++) {
			if(c[i] >= target) point++;
		}
		if(point >= target) {
			return true;
		} else {
			return false;
		}
	}
}