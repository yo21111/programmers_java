// 프로그래머스, 숫자의 표현

/*
 연속되는 자연수의 합으로 n을 나타낼 수 있는 경우의 수 찾기
 효율성 테스트도 있기 때문에 연속으로 더했을 때 n을 넘지 않는
 n/2 까지 확인 하였음
 추가적으로 해당 숫자 그자체로도 나타낼 수 있기 때문에
 n : n 인경우를 포함(answer+1)
 
 * 참고
 주어진 자연수를 연속된 자연수의 합으로 표현하는 방법의 수는 
 주어진 수의 홀수 약수의 개수와 같다라는 정수론 정리가 있음
 */

package programmers_Java;

public class Solution_20 {
	public int solution(int n) {
		int answer = 0;

		for (int i = 1; i <= n / 2; i++) {
			int t = 0;
			int plus = i;
			while (t < n) {
				t += plus;
				plus++;
			}
			if (t == n) {
				answer++;
			}
		}
		return answer + 1;
	}
}