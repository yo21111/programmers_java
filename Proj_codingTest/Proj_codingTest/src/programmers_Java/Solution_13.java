// ���α׷��ӽ�, �ﰢ ������
/*
 �ﰢ�� ������� ���ڰ� 1�� �����ϸ鼭 ���� ����� ���ڸ� �о���� ����
 ���� �Ʒ� ������ ������ �ﰢ������ ����� �����ؼ�
 �Ʒ�, ������, ���� �밢������ ���ڰ� ����ؼ� �����ϴ� �ڵ带 �����Ͽ���
 
 ���� �޼������ ����� ������ ��� �ֱ� ������
 �ߺ��ڵ带 ������ �� ���� �� ����
 */
package programmers_Java;

public class Solution_13 {
	public int[] solution(int n) {
		int[][] table = new int[n][n];
		int[] curP = {-1, 0};
		
		// n�� 1�϶����� for�� ������
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