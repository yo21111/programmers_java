//���α׷��ӽ�, ����� �׵θ� ȸ��
/*
 �׻� ������ ��
 1. �ʹ� ��ư� ������������ �����ϰ� Ǫ�� ���� �ְ��
 2. ��ġ ���� ���� 2���� �迭�� Ǫ�°� ���� �����ϴ�
 3. ���� ������ ��Ȯ�ϰ� �а� ������ ���� ���� ������ Ǯ��
 4. �������� ���õ� �ܾ ����ϸ� �� ���ذ� �� ��������
 */

package programmers_Java;

public class Solution_11 {
	static int[][] table;
	public int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		table = new int[rows][columns];
		
		for(int i = 0; i <rows; i++) {
			for(int j = 0; j < columns; j++) {
				table[i][j] = i*columns+j+1;
			}
		}
		
		for(int i = 0; i < queries.length; i++) {
			answer[i] = rotate(queries[i]);
		}
		
		return answer;
	}
	
	public static int rotate(int[] q) {
		int x1 = q[0]-1;
		int y1 = q[1]-1;
		int x2 = q[2]-1;
		int y2 = q[3]-1;
		
		int temp = table[x1][y1];
		int min = temp;
		System.out.println("temp : " + temp);
		for(int i = x1; i <x2; i++) {
			table[i][y1] = table[i+1][y1];
			if(min > table[i+1][y1]) min = table[i+1][y1]; 
		}

		for (int i = y1; i < y2; i++) {
			table[x2][i] = table[x2][i+1];
			if(min > table[x2][i+1]) min = table[x2][i+1];
		}

		for(int i = x2; i > x1; i--) {
			table[i][y2] = table[i-1][y2]; 
			if(min > table[i-1][y2]) min = table[i-1][y2]; 
		}

		for(int i = y2; i > y1; i--) {
			table[x1][i] = table[x1][i-1];
			if(min > table[x1][i-1]) min = table[x1][i-1];
		}
		
		
		
		
		table[x1][y1+1] = temp;
		
		return min;
	}
}