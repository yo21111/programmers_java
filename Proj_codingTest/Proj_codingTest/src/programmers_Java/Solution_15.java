//���α׷��ӽ�, �Ÿ��α� Ȯ���ϱ�
/*
 ����ư �Ÿ� 2�̳��� ��Ƽ���� ���� ���¿��� �Ÿ��α� ���� ��Ȳ�� ã�� ����
 P�� ���� �پ��ְų� O�� �����¿��� p ������ 1���� ū ���
 �Ÿ��α� �ȵǾ��ִ� ������ ��ȯ�ϴ� �����ϰ� �ذ�Ǿ���
 �����¿츦 Ȯ���ϴ� �κп��� �ߺ��ڵ尡 �ֱ� ������
 �ش� �κ��� �����ϸ� �� ����� �ڵ尡 �� ��
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

	// 1. �����¿� Ȯ�� �޼���
	public static boolean chkAround(int[] curP, String[] place) {
		String target = place[curP[0]].charAt(curP[1]) + "";
		if(!target.equals("X")) {
			return chkProc(curP, target, place);
		} else {
			return true;
		}
	}
	
	// p�� �����¿��� p�� ������ Ȯ��
	// o�� �����¿쿡 p�� 1�� ���ϰ� �´��� Ȯ��
	public static boolean chkProc(int[] curP, String target, String[] place) {
		if(curP[0] == 1 && curP[1] == 1) {
			System.out.println("now");
		}
		String nTarget = "";
		int count = 0;
		
		//1. ��
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
		//2. ������
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
		//3. �Ʒ�
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
		//4. ����
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