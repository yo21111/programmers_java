//프로그래머스 게임 맵 최단거리
// 효율성 2~4번 시간 초과
package programmers_Java;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_18 {
	public int solution(int[][] maps) {
		int[] cp = { 0, 0 };

		Queue<String> que = new LinkedList<>();
		que.add("0,0");
		int answer = -1;
		
		while (!que.isEmpty()) {
			plus(maps, cp, que);

			if(maps[maps.length-1][maps[0].length-1] != 1) {
				return maps[maps.length-1][maps[0].length-1];
			}

			String[] n = que.poll().split(",");
			cp[0] = Integer.parseInt(n[0]);
			cp[1] = Integer.parseInt(n[1]);
		}
		
		// 다 돌았을 때 도착지가 1 이상인지 확인
		return answer;
	}

	public static void plus(int[][] maps, int[] cp, Queue<String> que) {
		int[] dr = { 0, 0, 1, -1 };
		int[] dc = { 1, -1, 0, 0 };
		
		for(int i = 0; i < 4; i++) {
			int r = cp[1]+dr[i];
			int c =  cp[0]+dc[i];
			if ((0 <= c && c < maps.length) && (0 <= r && r < maps[0].length)) {
				if(!(r == 0 && c == 0) && maps[c][r] == 1) {
					maps[c][r] += maps[cp[0]][cp[1]];
					que.add(c+","+r);
				}
			}
			if(maps[maps.length-1][maps[0].length-1] > 1) {
				break;
			}
		}
	}
}