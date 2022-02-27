// ���α׷��ӽ�, ���� ū ���簢�� ã��
/*
 ���簢���� �ƴ� ���簢���� ã�� ���̱⿡
 �� ������ �������� ���� ��, �밢�� ���� ���� ���̾������ �̿��ϴ� ����
 ��ø ������ Ȱ���Ͽ� ���簢�� �Ѻ��� ���̸� ���ϴ� ��
 */
package programmers_Java;

public class Solution_14 {
	public int solution(int[][] board) {
		int answer = 1;
		// ��� ���� 0�� ��� ����
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