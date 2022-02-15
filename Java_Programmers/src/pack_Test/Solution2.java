// 프로그래머스, 방문 길이
/*
 (0, 0)에서 시작하는 주인공이 String dirs에 따라 움직이게 되는데
 상하좌우 -5 ~ 5의 방안에서 벗어나지 않으면서 겹치는 길을 제외하고
 새로운 길을 총 몇번 지나가게 되는지 반환하는 문제
 
 주인공이 좌표를 움직이는 메서드를 만드는 것은 간단하였으나
 주인공이 움직인 길을 기록하고 중복되는지 확인하는 것에 신경을 많이썼음
 
 일단 중복이라는 점에서 Set을 사용해야겠다고 생각하였으며
 특히 1. a->b 로 지난 길이든 b->a로 지난 길이든 동일한 길이다.
 2. 새로운 길만 count 해야한다 라는 두가지 조건을 만족시킬수 있다고 생각하였음
 
 최초 set<int[]> 로 생각하였으나 같은 객체를 사용하면 같은 해시코드를 사용하여
 중복된 것으로 인식하기 때문에 여러 방법 중 String으로 변환하여 add하는 방법을 사용하였음
 */
package pack_Test;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
	public int solution(String dirs) {
			int[] curPos = {0,0};
			Set<Set<String>> outterSet = new HashSet<>();
			
			for (int i = 0; i < dirs.length(); i++) {
				Set<String> innerSet = new HashSet<>();
				innerSet.add(realValue(curPos));
				curPos = move(curPos, dirs.charAt(i));
				innerSet.add(realValue(curPos));
				
				if (innerSet.size()==1) {
					continue;
				} else {
					outterSet.add(innerSet);
				}
			}
			
			int answer = outterSet.size();
			return answer;
		}

	public static String realValue(int[] curPos) {
		String str = "[" + curPos[0] + ", " + curPos[1] + "]";
		return str;
	}

	public static int[] move(int[] curPos, char dir) {
		switch (dir) {
		case 'U':
			if (curPos[0] >= 5) {
				return curPos;
			} else {
				curPos[0] += 1;
			}
			break;
		case 'D':
			if (curPos[0] <= -5) {
				return curPos;
			} else {
				curPos[0] -= 1;
			}
			break;
		case 'L':
			if (curPos[1] <= -5) {
				return curPos;
			} else {
				curPos[1] -= 1;
			}
			break;
		case 'R':
			if (curPos[1] >= 5) {
				return curPos;
			} else {
				curPos[1] += 1;
			}
			break;
		}
		return curPos;
	}
}