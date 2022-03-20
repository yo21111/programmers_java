//프로그래머스 [1차] 프렌즈 4블록
/*
 기준블록으로부터 우, 하, 우하 블록이 같은 블록이면 체크 이후 없어지는 과정
 블록 이미지와 동일하게 String[]을 사용하면 블록이 없어져서 위의 블록이
 아래로 떨어지는 과정을 구현하기 막막하여 String[] 을 오른쪽으로 90도 돌린
 형태로 새롭게 배열을 만들었음
 
 이후에는 문제에서 주어진대로 확인하면서 구현함
 */
package programmers_Java;

public class Solution_21 {
	public int solution(int m, int n, String[] board) {
		boolean flag = false;
		
		String[] nBoard = toList(board, n);
		while(!flag) {
			int[][] ox = oxBoard(nBoard, m, n);
			flag = proc(nBoard, ox);
		}
		
		int sum = 0;
		for(int i = 0; i < nBoard.length; i++) {
			sum += nBoard[i].length();
		}
		
		int answer = m*n - sum;
		return answer;
	}
	
	public static boolean proc(String[] nBoard, int[][] ox) {
		boolean flag = true;
		
		for(int i = 0; i < nBoard.length; i++) {
			String tmp = "";
			for(int j = 0; j < nBoard[i].length(); j++) {
				if(ox[i][j] == 0) tmp += nBoard[i].charAt(j);
				if(ox[i][j] == 1) flag = false;
			}
			nBoard[i] = tmp;
		}
		return flag;
	}
	
	public static int[][] oxBoard(String[] nBoard, int m, int n) {
		int[][] ox = new int[n][m];
		for(int i = 0; i < nBoard.length; i++) {
			for(int j = 0; j < nBoard[i].length(); j++) {
				char now = nBoard[i].charAt(j);
				if(i+1 < nBoard.length && j+1 < nBoard[i].length() && j+1 < nBoard[i+1].length()) {
					if(now == nBoard[i+1].charAt(j) && now == nBoard[i].charAt(j+1) && now == nBoard[i+1].charAt(j+1)) {
						ox[i][j] = 1;
						ox[i+1][j] = 1;
						ox[i][j+1] = 1;
						ox[i+1][j+1] = 1;
					}
				}
			}
		}
		return ox;
	}
	
	public static String[] toList(String[] board, int n) {
		String[] arr = new String[n];
		for(int i = 0; i < board[0].length(); i++) {
			String tmp = "";
			for(int j = board.length-1; j >= 0; j--) {
				tmp += board[j].charAt(i);
			}
			arr[i] = tmp;
		}
		return arr;
	}
}