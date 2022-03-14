//프로그래머스, 땅따먹기

/*
 직전 인덱스와 겹치지 않는 최대 합계를 찾는 문제
 findMax()를 정의하여 이전 인덱스와 겹치지 않는 인덱스의 최대값을 확인하였고
 answer에서는 절대 나오지 않는 수를 인덱스로 설정함으로써
 메서드를 재활용하였음
 */
package programmers_Java;

public class Solution_19 {
	int solution(int[][] land) {
		for (int i = 1; i < land.length; i++) {
			for (int j = 0; j < land[i].length; j++) {
				land[i][j] += findMax(land[i - 1], j);
			}
		}
		
		int answer = findMax(land[land.length - 1], land[0].length);
		return answer;
	}

	public static int findMax(int[] prev, int idx) {
		int max = 0;

		for (int i = 0; i < prev.length; i++) {
			if (i != idx && max < prev[i]) {
				max = prev[i];
			}
		}

		return max;
	}
}