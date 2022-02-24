//프로그래머스, 행렬의 테두리 회전
/*
 항상 주의할 점
 1. 너무 어렵게 생각하지말자 간단하게 푸는 것이 최고다
 2. 위치 값은 역시 2차원 배열로 푸는게 제일 간단하다
 3. 문제 내용을 정확하게 읽고 개념적 정리 이후 문제를 풀자
 4. 문제에서 제시된 단어를 사용하면 더 이해가 더 쉬워진다
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