// 프로그래머스, 가장 큰 정사각형 찾기
/*
 직사각형이 아닌 정사각형을 찾는 것이기에
 한 지점을 기준으로 왼쪽 위, 대각선 위가 같은 값이어야함을 이용하는 문제
 중첩 덧셈을 활용하여 정사각형 한변의 길이를 구하는 것
 */
package programmers_Java;

public class Solution_14 {
	public int solution(int[][] board) {
		int answer = 1;
		// 모든 값이 0인 경우 제외
		int chk = 0;
		for(int i = 0; i < board.length; i++) {
			for(int j : board[i]) {
				if(j == 1) chk = 1;
			}
		}
		
		if(chk != 1) return 0;
		
		for(int i = 1; i < board.length; i++) {
			for(int j = 1; j < board[i].length; j++) {
				if(board[i][j] == 0) {
					continue;
				}
				int up = board[i-1][j];
				int left = board[i][j-1];
				int uLeft = board[i-1][j-1];
				
				board[i][j] = Math.min(up, Math.min(left, uLeft)) + 1;
				answer = Math.max(answer, board[i][j]);
			}
		}
		
		return answer*answer;
	}
}