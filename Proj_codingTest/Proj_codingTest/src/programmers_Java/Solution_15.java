//프로그래머스, 거리두기 확인하기
/*
 맨해튼 거리 2이내에 파티션이 없는 상태에서 거리두기 안한 상황을 찾는 문제
 P가 서로 붙어있거나 O의 상하좌우의 p 갯수가 1보다 큰 경우
 거리두기 안되어있는 것으로 반환하니 간단하게 해결되었음
 상하좌우를 확인하는 부분에서 중복코드가 있기 때문에
 해당 부분을 수정하면 더 깔끔한 코드가 될 듯
 */
package programmers_Java;

public class Solution_15 {
	public int[] solution(String[][] places) {
		int[] answer = new int[places.length];
		int[] curP = {0, 0};
		Loop : for(int i = 0; i < places.length; i++) {
			for(int j = 0; j < places[i].length; j++) {
				for(int k = 0; k < 5; k++) {
					curP[0] = j;
					answer[i] = !chkAround(curP, places[i]) ? 0 : 1;
					if(answer[i] == 0) continue Loop;
					curP[1] = k;
				}
			}
		}
		return answer;
	}

	// 1. 상하좌우 확인 메서드
	public static boolean chkAround(int[] curP, String[] place) {
		String target = place[curP[0]].charAt(curP[1]) + "";
		if(!target.equals("X")) {
			return chkProc(curP, target, place);
		} else {
			return true;
		}
	}
	
	// p의 상하좌웅에 p가 없는지 확인
	// o의 상하좌우에 p가 1개 이하가 맞는지 확인
	public static boolean chkProc(int[] curP, String target, String[] place) {
		if(curP[0] == 1 && curP[1] == 1) {
			System.out.println("now");
		}
		String nTarget = "";
		int count = 0;
		
		//1. 위
		if (curP[0]-1 >= 0 ) {
			nTarget = place[curP[0]-1].charAt(curP[1]) + "";
			if(target.equals("P")) {
				if(nTarget.equals("P")) {
					return false;
				}
			} else {
				if(nTarget.equals("P")) {
					count++;
				}
			}
		}
		//2. 오른쪽
		if (curP[1]+1 < 5 ) {
			nTarget = place[curP[0]].charAt(curP[1]+1) + "";
			if(target.equals("P")) {
				if(nTarget.equals("P")) {
					return false;
				}
			} else {
				if(nTarget.equals("P")) {
					count++;
				}
			}
		}
		//3. 아래
		if (curP[0]+1 < 5 ) {
			nTarget = place[curP[0]+1].charAt(curP[1]) + "";
			if(target.equals("P")) {
				if(nTarget.equals("P")) {
					return false;
				}
			} else {
				if(nTarget.equals("P")) {
					count++;
				}
			}
		}
		//4. 왼쪽
		if (curP[1]-1 >= 0 ) {
			nTarget = place[curP[0]].charAt(curP[1]-1) + "";
			if(target.equals("P")) {
				if(nTarget.equals("P")) {
					return false;
				}
			} else {
				if(nTarget.equals("P")) {
					count++;
				}
			}
		}
		System.out.println("count : "  + count);
		return count > 1 ? false : true; 
	}
}