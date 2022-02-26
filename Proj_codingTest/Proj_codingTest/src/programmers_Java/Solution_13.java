// 프로그래머스, 삼각 달팽이
/*
 삼각형 모양으로 숫자가 1씩 증가하면서 위의 행부터 숫자를 읽어오는 문제
 왼쪽 아래 직각을 가지는 삼각형으로 모양을 변형해서
 아래, 오른쪽, 왼쪽 대각선으로 숫자가 계속해서 증가하는 코드를 생각하였음
 
 각각 메서드들은 비슷한 구성을 띄고 있기 때문에
 중복코드를 제거할 수 있을 것 같음
 */
package programmers_Java;

public class Solution_13 {
	public int[] solution(int n) {
		int[][] table = new int[n][n];
		int[] curP = {-1, 0};
		
		// n이 1일때까지 for문 돌리기
		int now = 1;
		for(int i = n; i >= 1; i--) {
			if(now%3 == 1) {
				down(table, i, curP);
			} else if (now%3 == 2) {
				right(table, i, curP);
			} else {
				up(table, i, curP);
			}
			now++;
		}
		int[] answer = toAns(n, table);
		return answer;
	}
	
	public static int[] toAns(int n, int[][] table) {
		int[] arr = arr(n);
		int idx = 0;
		for(int i = 0; i < table.length; i++) {
			for(int j = 0; j < table[0].length; j++) {
				if(table[i][j] != 0) {
					arr[idx] = table[i][j];
					idx++;
				}
			}
		}
		return arr;
	}
	
	public static void down(int[][] table, int n, int[] curP) {
		int target = 0;
		if(curP[0] != -1) {
			target = table[curP[0]][curP[1]];
		}
		for(int i = 1; i <= n; i++) {
			curP[0] += 1;
			target++;
			table[curP[0]][curP[1]] = target;
		}
	}
	
	public static void right(int[][] table, int n, int[] curP) {
		int target = table[curP[0]][curP[1]];
		for(int i = 1; i <= n; i++) {
			curP[1] += 1;
			target++;
			table[curP[0]][curP[1]] = target;
		}
	}
	
	public static void up(int[][] table, int n, int[] curP) {
		int target = table[curP[0]][curP[1]];
		for(int i = 1; i <= n; i++) {
			curP[0] -= 1;
			curP[1] -= 1;
			target++;
			table[curP[0]][curP[1]] = target;
		}
	}
	
	public static int[] arr(int n) {
		int sum = 0;
		for(int i = n; i >= 1; i--) {
			sum += i;
		}
		
		int[] arr = new int[sum];
		return arr;
	}
}